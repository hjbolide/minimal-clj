(ns minclj.domain.auth-context)


(def AuthContext
  [:map
   [:platform-admin? boolean?]])


(defn platform-admin?
  {:malli/schema [:=> [:cat AuthContext] boolean?]}
  [this]
  (true? (:platform-admin? this)))
