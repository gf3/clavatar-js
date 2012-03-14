(defproject clavatar-js "0.1.0-SNAPSHOT"
  :description "Gravatar for Clojurescript!"
  :dependencies [[org.clojure/clojure "1.3.0"]]
  :plugins [[lein-cljsbuild "0.1.2"]]
  :cljsbuild {:builds
              [{:source-path "src"
                :compiler {
                           :libs ["resources/crypt.js" "resources/hash.js" "resources/md5.js"]
                           :output-to "clavatar_js.js"
                           :optimizations :simple 
                           :pretty-print true}}]}
  :url "https://github.com/gf3/clavatar-js"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"})

