(ns kkj-list.views
  (:require
   [re-frame.core :as rf]
   [kkj-list.events :as events]
   [kkj-list.subs :as subs]))

(defn nav-bar []
  [:div.nav-bar
   [:button 
    {:on-click #(rf/dispatch [::events/set-active-page :home])} 
    [:i.fas.fa-home.icon] "Home"]
   [:button 
    {:on-click #(rf/dispatch [::events/set-active-page :expenses])} 
    [:i.fas.fa-coins.icon] "Despesas"]
   [:button 
    {:on-click #(rf/dispatch [::events/set-active-page :tasks])} 
    [:i.fas.fa-tasks.icon] "Tarefas"]
   [:button 
    {:on-click #(rf/dispatch [::events/set-active-page :wishes])} 
    [:i.fas.fa-star.icon] "Desejos"]])

(defn home-page []
  [:div.main-container
   [:h1 "✨ KKJ List ✨"]
   [:div.card
    [:h2 "Bem-vindo ao seu gerenciador de despesas e listas!"]
    [:p "O jeito mais fofo de organizar suas contas e listas 🌸"]]])

(defn expenses-page []
  [:div.main-container
   [:h2 "💰 Despesas"]
   [:div.card
    [:button.cute-button
     [:i.fas.fa-plus.icon] "Nova Despesa"]]])

(defn main-panel []
  (let [active-page @(rf/subscribe [::subs/active-page])]
    [:div
     [nav-bar]
     (case active-page
       :home [home-page]
       :expenses [expenses-page]
       [home-page])]))
