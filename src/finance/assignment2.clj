(ns finance.assignment2
  (:use [clojure.core])
  (:require [clojure.math.numeric-tower :as math]))

(defn fv
  "calculates the 'future value' of an annuity
   'c' cost or payment
   'r' interest rate
   'n' number of periods (e.g. number of years)
  "
  [c r n]
  (* c (reduce + 1 (for [k (range (- n 1) 0 -1)] (math/expt (+ 1 r) k)))))

(defn fv-pmt
  "calculates the 'cost or payment' of an annuity, given a 'future value'
   'fv' future value
   'r' interest rate
   'n' number of periods (e.g. number of years)
  "
  [fv r n]
  (/ fv (reduce + 1 (for [k (range (- n 1) 0 -1)] (math/expt (+ 1 r) k)))))

(defn pv
  "calculates the 'present value' of an annuity
   'c' cost or payment
   'r' interest rate
   'n' number of periods (e.g. number of years)
  "
  [c r n]
  (* c (reduce + (for [k (range 1 (+ n 1))] (/ 1 (math/expt (+ 1 r) k))))))

(defn pv-pmt
  "calculates the 'cost or payment' of an annuity, given a 'present value'
   'pv' present value
   'r' interest rate
   'n' number of periods (e.g. number of years)
  "
  [pv r n]
  (/ pv (reduce + (for [k (range 1 (+ n 1))] (/ 1 (math/expt (+ 1 r) k))))))

