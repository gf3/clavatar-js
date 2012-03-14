(ns clavatar-js.core
  (:require [clojure.string :as string]
            [goog.crypt :as crypt]
            [goog.crypt.Md5 :as md5]))

(def ^:private gravatar-base-url "gravatar.com/avatar/")

(defn- gen-hash
  "Generate the MD5 sum for a given email address."
  [email]
  (let [email (string/trim (string/lower-case email))
        hasher (new goog.crypt.Md5)]
    (.update hasher email)
    (crypt/byteArrayToHex (.digest hasher))))

(defn- gen-params
  "Build the params given a set of options."
  [& {size :size default :default rating :rating}]
  (str "?s=" size "&r=" (name rating) "&d=" (name default) "&"))

(defn ^:export gravatar
  "Return the URL of the Gravatar image for a given email.
  Options are:
      size    -- size of image
      https   -- whether or not to use https
      rating  -- one of :pg, :g, :x,: r which are Parental Guidance,
                 General Audience, Explicit, and Restricted respectively.
      default -- default image if the one choosen doesn't exist. One of:
                 :404       -- a 404 error,
                 :mm        -- cartoon-style silhouetted outline of a person,
                 :identicon -- geometric pattern based on an email hash,
                 :monsterid -- generated 'monster' with different colors, faces, etc,
                 :wavatar   -- generated faces with differing features and background,
                 :retro     --generated 8-bit arcade-style pixelated faces"
  [email & {:keys [size https rating default]
            :or {size 50 https true rating :pg default :retro}}]
  (let [url (str gravatar-base-url
                 (gen-hash email)
                 (gen-params :size size :default default :rating rating))]
    (str (if https "https://secure" "http://www") "." url)))

