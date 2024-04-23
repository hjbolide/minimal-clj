(ns minclj.domain.auth-test
  (:require [clojure.test :refer [deftest is]]
            [minclj.domain.auth-context :as auth-context]))


(deftest test-platform-admin-truthy-values
  (let [auth-ctx {:platform-admin? true}]
    (is (true? (auth-context/platform-admin? auth-ctx)))))