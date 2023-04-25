# {{raw-name}}

```none
██████╗ ██████╗  █████╗  ██████╗████████╗██╗ ██████╗ █████╗ ██╗     ██╗     ██╗
██╔══██╗██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██║██╔════╝██╔══██╗██║     ██║     ██║
██████╔╝██████╔╝███████║██║        ██║   ██║██║     ███████║██║     ██║     ██║
██╔═══╝ ██╔══██╗██╔══██║██║        ██║   ██║██║     ██╔══██║██║     ██║     ██║
██║     ██║  ██║██║  ██║╚██████╗   ██║   ██║╚██████╗██║  ██║███████╗███████╗██║
╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝
```

## Project Status

TODO: add status badges for <https://{{scm/domain}}/{{developer}}/{{scm/repo>}} workflows and issues

{{description}}

Project created with [deps-new](https://github.com/seancorfield/deps-new) and the [practicalli/application template](https://github.com/practicalli/project-templates)

## Run the service

Run the service (clojure.main)

```shell
clojure -M:run/app
```

Run the greet function (clojure.exec), optionally passing a `:name` key and value as arguments

```shell
clojure -X:run/greet :team-name '"team name"'
```

## Development

Practicalli workflow overview:

- start a REPL process in a Terminal
- open the project in a Clojure Editor and connected to the REPL
- write code and evaluate expressions in the editor using the source code files

[Practicalli Clojure CLI Config](https://practical.li/clojure/clojure-cli/practicalli-config/) should be used with this project to support all aliases used.

This project uses `make` tasks to run the Clojure tests, kaocha test runner and package the service into an uberjar.  The `Makefile` uses `clojure` commands and arguments which can be used directly if not using `make`.

`make` command in a terminal will list all the tasks available

```shell
make
```


### Run Clojure REPL

Start the REPL with the [Practicalli REPL Reloaded](https://practical.li/clojure/clojure-cli/repl-reloaded/) aliases to include the custom `user` namespace (`dev/user.clj`) which provides additional tools for development (Portal data inspector, hotload libraries, namespace reload)

```shell
make repl
```

The local nREPL server port will be printed, along with a help menu showing the REPL Reloaded tools available.

Evaluate the {{top/ns}}.{{main/ns}} namespace and a mulog publisher will start, sending pretty printed events to the console. Evaluate `(mulog-publisher)` to stop the mulog publisher.

Call the `-main` function with or without an argument, or call the `greet` function directly passing an optional key and value pair.

`(namespace/refresh)` will reload any changed namespaces in the Clojure project.


### Clojure Editor

If a REPL has been run from a terminal, use the editor **connect** feature.

Otherwise, use the `:dev/reloaded` alias from Practicalli Clojure CLI Config to starting a REPL process from within a Clojure editor.


### Unit tests

Run unit tests of the service using the kaocha test runner

```shell
make test
```

> If additional libraries are required to support tests, add them to the `:test/env` alias definition in `deps.edn`

`make test-watch` will run tests on file save, stopping the current test run on the first failing test.  Tests will continue to be watched until `Ctrl-c` is pressed.

## Format Code

Check the code format before pushing commits to a shared repository, using cljstyle to check the Clojure format, MegaLinter to check format of all other files and kaocha test runner to test the Clojure code.

Before running the `pre-commit-check`

* [install cljstyle](https://github.com/greglook/cljstyle/releases){target=_blank}
* MegaLinter runs in a Docker container, so ensure Docker is running

```shell
make pre-commit-check
```

Run cljstyle only

* `make format-check` runs cljstyle and and prints a report if there are errors
* `make format-fix` updates all files if there are errors (check the changes made via `git diff`)

Run MegaLinter only

* `make lint` runs all configured linters in `.github/config/megalinter.yaml`

Run Kaocha test runner only

* `make test` runs all unit tests in the project, stopping at first failing test
* `make test-watch` detect file changes and run all unit tests in the project, stopping at first failing test


## Deployment

Build an uberjar to deploy the service as a jar file

```shell
make build-uberjar
```

* `make build-config` displays the tools.build configuration
* `make build-clean` deletes the build assets (`target` directory)

```shell
make docker-build
```

* `make docker-down` shuts down all services started with `docker-build`
* `make docker-build-clean`

Or build and run the service via the multi-stage `Dockerfile` configuration as part of a CI workflow.


## License

Copyright © {{now/year}} {{developer}}

[Creative Commons Attribution Share-Alike 4.0 International](http://creativecommons.org/licenses/by-sa/4.0/")
