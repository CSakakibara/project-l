(ns kkj-list.events
  (:require
   [re-frame.core :as rf]
   [kkj-list.db :as db]))

;; Inicialização
(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

;; Navegação
(rf/reg-event-db
 ::set-active-page
 (fn [db [_ page]]
   (assoc db :active-page page)))

;; Despesas
(rf/reg-event-db
 ::add-expense
 (fn [db [_ expense]]
   (update db :expenses conj expense)))
