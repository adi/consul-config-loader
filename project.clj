(defproject org.clojars.sqreept/consul-config-loader "1.0.0"
  :description "Loads all consul key value items starting at a given prefix."
  :url "https://github.com/adi/consul-config-loader"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [
                 [org.clojure/clojure "1.8.0"]
                 [consul-clojure "0.7.1"]
                 [cheshire "5.7.1"]]
  :main ^:skip-aot consul-config-loader.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
