(ns finance.core
  (:use [clojure.core])
  (:require [clojure.math.numeric-tower :as math]))

(defn fv-simple
  "calculates 'future value' using the formula FV = PV * (1+r) ^ n

   'pv' present value.
   'r' interest rate.
   'n' number of periods.

   The interest rate is considered to be constant through all the periods"
  [pv r n]
  (* pv (math/expt (+ 1 r) n)))

(defn pv-simple
  "calculates 'present value' using the formula PV = FV / (1+r) ^ n

   'fv' future value.
   'r' interest rate.
   'n' number of periods.

   The interest rate is considered to be constant through all the periods"
  [fv r n]
  (/ fv (math/expt (+ 1 r) n)))

(defn fv-annuity
  "calculates the 'future value' of an annuity
   'c' cost or payment
   'r' interest rate
   'n' number of periods (e.g. number of years)
  "
  [c r n]
  (* c (reduce + 1 (for [k (range (- n 1) 0 -1)] (math/expt (+ 1 r) k)))))

(defn pmt-fv
  "calculates the 'cost or payment' of an annuity, given a 'future value'
   'fv' future value
   'r' interest rate
   'n' number of periods (e.g. number of years)
  "
  [fv r n]
  (/ fv (reduce + 1 (for [k (range (- n 1) 0 -1)] (math/expt (+ 1 r) k)))))

(defn pv-annuity
  "calculates the 'present value' of an annuity
   'c' cost or payment
   'r' interest rate
   'n' number of periods (e.g. number of years)
  "
  [c r n]
  (* c (reduce + (for [k (range 1 (+ n 1))] (/ 1 (math/expt (+ 1 r) k))))))

(defn pmt-pv
  "calculates the 'cost or payment' of an annuity, given a 'present value'
   'pv' present value
   'r' interest rate
   'n' number of periods (e.g. number of years)
  "
  [pv r n]
  (/ pv (reduce + (for [k (range 1 (+ n 1))] (/ 1 (math/expt (+ 1 r) k))))))