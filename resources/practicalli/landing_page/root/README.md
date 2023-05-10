# {{top/ns}} {{main/ns}}

{{description}}

## Development Workflows

Drive a Browser connected REPL from an Editor or via a rich terminal UI (rebel)

### Emacs & CIDER

Open a ClojureScript (*.cljs) or Clojure file (e.g. deps.edn) in Emacs.

`cider-jack-in-cljs` command will launch a REPL process and start Figwheel.

> `.dir-locals.el` Emacs project configuration specifies `figwheel-main` as the build tool and `dev` as the build task to run.
>
> [Practicalli Spacemacs - ClojureScript Projects](https://practical.li/spacemacs/clojure-repl/clojurescript-repl/) walks through the steps to start a REPL with Figwheel-main

### Rich Terminal workflow

Starts a rich terminal UI REPL which also launches and controls the figwheel tool.

```shell
make repl
```

> The make repl task calls the command `clojure -M:figwheel/env:build/dev`

### Figwheel workflow

Once the REPL and Fighweel have started:

- ClojureScript code is compiled into JavaScript
- a browser tab/window is opened
- the index.html page with JavaScript app link is sent to the opened browser and rendered

Saved changes to the ClojureScript code and CSS will auto compile and resulting JavaScript sent to the browser without the need to reload.

Once the compilation process is complete, try evaluate code to test the Browser Connected REPL.

```clojure
(js/alert "Am I connected?")
```

An alert box should appear in the browser window.

### Clean build

To clean all compiled files:

```shell
make build-clean
```

Create an application build that can be deployed to GitHub pages

```shell
make dist
```

## License

Copyright © 2023 {{developer}}

Distributed under the Creative Commons Attribution Share-Alike 4.0 International
