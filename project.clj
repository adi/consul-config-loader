(defproject org.clojars.sqreept/consul-config-loader "1.0.0"
  :description "Loads all consul key value items starting at a given prefix."
  :url "https://github.com/adi/consul-config-loader"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [org.clojure/clojure "1.8.0"]
                 [consul-clojure "0.7.1"]
                 [cheshire "5.7.1"]]
  :main ^:skip-aot consul-config-loader.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
