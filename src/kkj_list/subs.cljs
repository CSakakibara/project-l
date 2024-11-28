(ns kkj-list.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 ::active-page
 (fn [db]
   (:active-page db)))

(rf/reg-sub
 ::expenses
 (fn [db]
   (:expenses db)))

(rf/reg-sub
 ::balances
 :<- [::expenses]
 (fn [expenses]
   ;; TODO: implementar cálculo de saldos
   {}))
