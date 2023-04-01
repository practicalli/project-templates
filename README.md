# Practicalli project templates


```none
██████╗ ██████╗  █████╗  ██████╗████████╗██╗ ██████╗ █████╗ ██╗     ██╗     ██╗
██╔══██╗██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██║██╔════╝██╔══██╗██║     ██║     ██║
██████╔╝██████╔╝███████║██║        ██║   ██║██║     ███████║██║     ██║     ██║
██╔═══╝ ██╔══██╗██╔══██║██║        ██║   ██║██║     ██╔══██║██║     ██║     ██║
██║     ██║  ██║██║  ██║╚██████╗   ██║   ██║╚██████╗██║  ██║███████╗███████╗██║
╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝
```



## Templates provided

* DOING: practicalli/service - production grade HTTP service
* TODO: practicalli/api - production grade API service (reitit-ring)
* TODO: practicalli/application - general application, limited code
* TODO: practicalli/library - general library, deploymnent to Maven/Clojars
* TODO: practicalli/data-science-notebook - general library, deploymnent to Maven/Clojars
* TODO: practicalli/data-science-visualisation - general library, deploymnent to Maven/Clojars


3rd party templates
* Clerk template - https://github.com/mentat-collective/clerk-utils/tree/main/resources/clerk_utils/custom

## Usage

Create a new project using the `:project/create` alias from Practialli Clojure CLI Config


Or install  `seancorfield/deps-new` with the `project-create` tool name:

```bash
clojure -Ttools install io.github.seancorfield/deps-new '{:git/tag "v0.5.0"}' :as project-create
```

> Note: once the template has been published (to a public git repo), the invocation will be the same, except the `:local/root` dependency will be replaced by a git or Maven-like coordinate.


## Development

Start a Clojure REPL process with a rich terminal UI, nREPL server for editor connection and including the `build.clj` script on the class path

```shell
make repl
```

Run kaocha unit test runner to check the template configuration against the seancorfield/deps-new template

```shell
make test
```

Run tests when ever there are file changes using kaocha watch

```shell
make test-watch
```

Or use the `clojure` binary directly (see `Makefile` for examples)


> [Practicalli Blog: Create deps-new template for Clojure CLI projects](https://practical.li/blog-staging/posts/create-deps-new-template-for-clojure-cli-projects/)


## License

Copyright © 2023 Practicalli

Creative Commons Attribution Share-Alike 4.0 International
