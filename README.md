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

Create a new project using the `:project/create` alias from [Practialli Clojure CLI Config](https://practical.li/clojure/clojure-cli/practicalli-config/)

```shell
clojure -T:project/create
```

Or add a specific `:name` and value to create a project with a different name

```shell
clojure -T:project/create :name practicalli.template/gameboard
```

> `seancorfield/deps-new` can also be installed as a Clojure CLi tool, for example with the `project-create` tool name:
> ```bash
> clojure -Ttools install io.github.seancorfield/deps-new '{:git/tag "v0.5.0"}' :as project-create
> ```
>
> Create a new project, specifying the template and name of the projects
>
> ```shell
> clojure -Tproject-create practicalli/service :name practicalli.gameboard/service
> ```


> Note: once the template has been published (to a public git repo), the invocation will be the same, except the `:local/root` dependency will be replaced by a git or Maven-like coordinate.

<details>
<summary>Clojure CLI Alias definition</summary>

Combined
```clojure
  :project/create
  {:replace-deps {io.github.seancorfield/deps-new
                  {:git/tag "v0.5.0" :git/sha "48bf01e"}
                  practicalli/clojure-cli-project-templates
                  {:local/root "/home/practicalli/projects/practicalli/clojure-cli-project-templates/"}}
   :exec-fn      org.corfield.new/create
   :exec-args    {:template practicalli.template/service
                  :name practicalli.gameboard/service}}
```

</details>





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
