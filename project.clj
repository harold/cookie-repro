(defproject cookie-repro "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 ;; [org.clojure/clojurescript "1.10.879"] ;; last version w/o warning
                 ;; [org.clojure/clojurescript "1.10.891"] ;; first version w/ warning
                 [org.clojure/clojurescript "1.11.60"] ;; latest version as of today
                 ]
  :plugins [[lein-cljsbuild "1.1.8"]]
  :cljsbuild {:builds [{:id "prod"
                        :source-paths ["src"]
                        :compiler {:main "cookie-repro.webapp"
                                   :asset-path "/js/out"
                                   :output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js/out-prod"
                                   :optimizations :advanced}}]}
  :clean-targets ^{:protect false} ["target"
                                    "resources/public"]
  :aliases {"cljsprod" ["cljsbuild" "once" "prod"]})
