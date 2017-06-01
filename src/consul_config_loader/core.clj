(ns consul-config-loader.core
  (:require [consul.core :as consul]
            [cheshire.core :as json]
            [clojure.string :as str]))

(defn- get-consul-json-value
  [raw-value]
  (try
    (json/parse-string raw-value)
    (catch Exception e raw-value)))

(defn- get-consul-pair
  [item]
  [(:key item) (get-consul-json-value (:value item))])

(defn- assoc-config-key-value
  [tree key value]
  (update-in tree (str/split key #"/") (fn [old-value] value)))

(defn load-config
  [base-key]
  (let [raw-config (:body (consul/kv-recurse :local base-key))
        decoded-config (map get-consul-pair raw-config)]
    (reduce
      (fn [acc item]
        (let [[key value] item]
          (if (str/ends-with? key "/")
            (assoc-config-key-value acc key {})
            (assoc-config-key-value acc key value))))
      {}
      decoded-config)))
