# Practicalli project templates

```none
██████╗ ██████╗  █████╗  ██████╗████████╗██╗ ██████╗ █████╗ ██╗     ██╗     ██╗
██╔══██╗██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██║██╔════╝██╔══██╗██║     ██║     ██║
██████╔╝██████╔╝███████║██║        ██║   ██║██║     ███████║██║     ██║     ██║
██╔═══╝ ██╔══██╗██╔══██║██║        ██║   ██║██║     ██╔══██║██║     ██║     ██║
██║     ██║  ██║██║  ██║╚██████╗   ██║   ██║╚██████╗██║  ██║███████╗███████╗██║
╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝
```

## Overview

Create new projects with a REPL driven development focus, including production level features where relevant. The templates are used by [deps-new](https://github.com/seancorfield/deps-new) via a user or project alias.

Templates provide

- `:practicalli/minimal` essential tools, libraries and example code
- `:practicalli/service` production level web services with http-kit, reitit and swagger. Optional `:component` management with `:donut` or `:integrant`


## Configuration

[![Latest Release](https://img.shields.io/github/v/release/practicalli/project-templates?display_name=tag)](https://github.com/practicalli/project-templates/releases)

```clojure
io.github.practicalli/project-templates {:git/tag "2024-09-09" :git/sha "0d11ca4"}
```

### Add alias

`:project/create` alias is provided by [Practicalli Clojure CLI Config](https://practical.li/clojure/clojure-cli/practicalli-config/).

The `project/create` alias definition combines [seancorfield/deps-new](https://github.com/seancorfield/deps-new) and practicalli/project-templates so that all Practicalli templates are available within one alias.

```clojure
  :project/create
  {:replace-deps {io.github.seancorfield/deps-new
                  {:git/tag "v0.8.0" :git/sha "2f96530"}
                  io.github.practicalli/project-templates
                  {:git/tag "2024-09-09" :git/sha "0d11ca4"}}
   :exec-fn      org.corfield.new/create
   :exec-args    {:template practicalli/application
                  :name practicalli/playground}}
```

> [![Latest Release](https://img.shields.io/github/v/release/practicalli/project-templates?display_name=tag)](https://github.com/practicalli/project-templates/releases) page includes the release `:git/tag` and `:git/sha` values for `io.github.practicalli/project-templates`


## Usage

Create a new project using the `:project/create` alias from [Practicalli Clojure CLI Config](https://practical.li/clojure/clojure-cli/practicalli-config/), using `practicalli/minimal` template by default

```shell
clojure -T:project/create
```

Override the defaults used to create a project using command line options

* `:template` to specify a different template to create the project from, e.g. `:template practicalli/service`
* `:name` and value to create a project with a different name, e.g. `github-org/project-name`
* `:target-dir` to specify a directory to create the project in
* `:overwrite` an existing project with the same `:target-dir name`, `true` updates, `:delete` deletes existing project and replaces it with new project

```shell
clojure -T:project/create :template practicalli/service \
:name practicalli/gameboard :target-dir gameboard-service
```


## Templates Roadmap

🧰 General purpose

* [practicalli/service](https://github.com/practicalli/project-templates/issues/2) - production grade HTTP service, basic routing (reitit-ring & middleware)
  * `:component :donut` argument to manage system with donut-party/system
  * `:component :integrant` argument to manage system with Integrant and Integrant REPL
* [practicalli/application](https://github.com/practicalli/project-templates/issues/4) - general application, limited code
* [practicalli/minimal](https://github.com/practicalli/project-templates/issues/19) - Clojure CLI project, tools-build, kaocha test runner alias, Make tasks, GitHub quality checks workflow
* TODO: practicalli/api - production grade API service (reitit-ring, clojure.spec validation)
* TODO: practicalli/library - general library, deploymnent to Maven/Clojars
* TODO: [practicalli/blog](https://github.com/practicalli/project-templates/issues/1) - cryogen project with Practicalli Customisation
* TODO: practicalli/jetty - basic web server
* TODO: practicalli/httpkit - basic web server

🕸️  Web UI

* DONE: [#15](https://github.com/practicalli/project-templates/issues/15) practicalli/landing-page - a simple landing page with figwheel and Bulma.io CSS
* TODO: practicalli/single-page-app - a simple landing page with figwheel and Bulma.io CSS
* TODO: practicalli/catalog - a catalog front-end webapp with [firebase persistence](https://firebase.google.com/), user OAuth authentication, figwheel, Reagent, Bulma.io CSS
* TODO: practicalli/store-front - a catalog front-end webapp with stripe integration, [firebase persistence](https://firebase.google.com/), OAuth authentication, figwheel, Reagent, Bulma.io CSS

🔬 Data Science ‍

* TODO: practicalli/notebook - clerk or notespace projects
* TODO: practicalli/dashboard - visualising data sources to communicate information and concepts
* TODO: practicalli/visualisation - oz or hanami projects
* TODO: practicalli/data-transform - tablecloth & code for data set manipulation

🐈 Miscellaneous

* TODO: practicalli/zulip-bot
* TODO: practicalli/slack-bot
* TODO: practicalli/mastodon-bot

3rd party templates

* [Clerk template](https://github.com/mentat-collective/clerk-utils/tree/main/resources/clerk_utils/custom)


## Sponsor Practicalli

[![Sponsor practicalli-johnny](https://raw.githubusercontent.com/practicalli/graphic-design/live/buttons/practicalli-github-sponsors-button.png)](https://github.com/sponsors/practicalli-johnny/)

The majority of my work is focused on the [Practicalli series of books and videos](https://practical.li/) and supporting projects.

Thank you to [Cognitect](https://www.cognitect.com/), [Nubank](https://nubank.com.br/) and a wide range of other [sponsors](https://github.com/sponsors/practicalli-johnny#sponsors) for your continued support


## Development

List all the available project tasks using the `make` help

```shell
make
```

> This project uses `make` tasks to run the Clojure tests, kaocha test runner and package the service into an uberjar.  The `Makefile` uses `clojure` commands and arguments that can be used directly if not using `make`.

Start a Clojure REPL process with a rich terminal UI, nREPL server for editor connection and including the `build.clj` script on the class path

```shell
make repl
```

Run kaocha unit test runner to check the template configuration against the seancorfield/deps-new template specification

```shell
make test
```

Run tests when ever there are file changes using kaocha watch (requires `:test/watch` from Practicalli Clojure CLI Config)

```shell
make test-watch
```

> [Practicalli Blog: Create deps-new template for Clojure CLI projects](https://practical.li/blog-staging/posts/create-deps-new-template-for-clojure-cli-projects/)

## License

Copyright © 2023 Practicalli

Creative Commons Attribution Share-Alike 4.0 International
