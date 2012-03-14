# clavatar-js

A ClojureScript port of [Rayne's clavatar](https://github.com/Raynes/clavatar). This is a library to generate Gravatar URLs from email addresses.

## Usage

In your `project.clj`:

```clojure
[clavatar-js "0.1.0-SNAPSHOT"]
```

In your app:

```clojure
cljs.user> (clavatar-js.core/gravatar "gianni@runlevel6.org")
"https://secure.gravatar.com/avatar/4b0209ae3652cc5a7d53545e759fbe39?s=50&r=pg&d=retro&"
cljs.user> (clavatar-js.core/gravatar "gianni@runlevel6.org" :size 500)
"https://secure.gravatar.com/avatar/4b0209ae3652cc5a7d53545e759fbe39?s=500&r=pg&d=retro&"
cljs.user> (clavatar-js.core/gravatar "gianni@runlevel6.org" :size 500 :rating :g)
"https://secure.gravatar.com/avatar/4b0209ae3652cc5a7d53545e759fbe39?s=500&r=g&d=retro&"
cljs.user> (clavatar-js.core/gravatar "gianni@runlevel6.org" :default :mm) ; Sets the default image to mystery man.
"https://secure.gravatar.com/avatar/4b0209ae3652cc5a7d53545e759fbe39?s=50&r=pg&d=mm&"
cljs.user> (clavatar-js.core/gravatar "i@raynes.me" :default :mm :size 128 :https false)
"http://www.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1?s=128&r=pg&d=mm&"
```

## License

Distributed under the Eclipse Public License, the same as Clojure.

