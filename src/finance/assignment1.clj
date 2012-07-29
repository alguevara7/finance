(ns finance.assignment1
  (:use [clojure.core])
  (:require [clojure.math.numeric-tower :as math]))

(defn fv
  "calculates 'future value' using the formula FV = PV * (1+r) ^ n

   'pv' present value.
   'r' interest rate.
   'n' number of periods.

   The interest rate is considered to be constant through all the periods"
  [pv r n]
  (* pv (math/expt (+ 1 r) n)))

(defn pv
  "calculates 'present value' using the formula PV = FV / (1+r) ^ n

   'fv' future value.
   'r' interest rate.
   'n' number of periods.

   The interest rate is considered to be constant through all the periods"
  [fv r n]
  (/ fv (math/expt (+ 1 r) n)))

(defn solution8 [cost-now cost-later years]
  "calculates the break even point"
  (- (math/expt (/ cost-later cost-now)
           (/ 1 5))
     1))
; (solution8 10000 20000 5)

(defn solution9 
  "calculates the net cost of purchasing a car"
  [cost years-to-own trade-in-value r]
  (- cost (pv (* trade-in-value cost) 0.05 4)))
; (def cost-a  (finance/solution9 32000 4 0.6 0.05))
; (def cost-b  (finance/solution9 28000 4 0.45 0.05))

(defn solution10
  "calculates present value of all future maintenance"
  [cost cost-r r years]
  (apply + (for [n (range 10)]
             (pv (fv 1590 0.06 n)
                         0.05
                         (+ n 1)))))
; (solution10 1590 0.06 0.05 10)

