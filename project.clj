(defproject minclj "1.0.0"
  :description "Minimal clj project"
  :url "https://example.com"
  :license {:name         "MIT License"
            :url          "https://opensource.org/license/mit"
            :distribution :manual}
  :min-lein-version "2.7.0"

  :dependencies [[org.clojure/clojure "1.11.1"]]

  :jvm-opts ["-server" "-Duser.timezone=UTC"]
  :source-paths ["src/clj"]

  :test-paths ["test/unit/clj"]

  :resource-paths ["resources"]
  :target-path "target/%s/"

  :main ^:skip-aot minclj.core

  :profiles {:uberjar {:omit-source true
                       :aot         :all}

             :dev     {:dependencies   []

                       :plugins        []

                       :source-paths   ["env/dev/clj"]

                       :resource-paths ["env/dev/resources"
                                        "test/unit/resources"]

                       :test-selectors {:unit             (fn [m] (not (or (:integration m)
                                                                         (.contains (str (:ns m)) "test.integration.")
                                                                         (:functional m)
                                                                         (.contains (str (:ns m)) "test.functional."))))}

                       :eftest         {:capture-output? false
                                        :multithread?    false
                                        :fail-fast?      true}}

             :test    {:source-paths   ["env/test/clj"]
                       :resource-paths ["env/test/resources"]}

             :prod    {:source-paths   ["env/prod/clj"]
                       :resource-paths ["env/prod/resources"]}}

  :repositories []

  :aliases {"unit"             ["eftest" ":unit"]
            "test"             ["do" "unit"]
            "ltest"            ["do" "lint," "test"]
            "mltest"           ["do" "mlint," "test"]
            "coverage"         ["cloverage"]}

  :cloverage {:ns-exclude-regex [#"(.*-test$|.*-fixture$)"]
              :test-ns-regex    [#".*-test$"]}

  :eftest {:capture-output? false
           :multithread?    false})
