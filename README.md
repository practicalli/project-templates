# Practicalli Clojure CLI project templates


```none
██████╗ ██████╗  █████╗  ██████╗████████╗██╗ ██████╗ █████╗ ██╗     ██╗     ██╗
██╔══██╗██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██║██╔════╝██╔══██╗██║     ██║     ██║
██████╔╝██████╔╝███████║██║        ██║   ██║██║     ███████║██║     ██║     ██║
██╔═══╝ ██╔══██╗██╔══██║██║        ██║   ██║██║     ██╔══██║██║     ██║     ██║
██║     ██║  ██║██║  ██║╚██████╗   ██║   ██║╚██████╗██║  ██║███████╗███████╗██║
╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝
```



## Templates provided

* DOING: practicalli.template/service - production grade HTTP service
* TODO: practicalli.template/api - production grade API service (reitit-ring)
* TODO: practicalli.template/application - general application, limited code
* TODO: practicalli.template/library - general library, deploymnent to Maven/Clojars
* TODO: practicalli.template/data-science-notebook - general library, deploymnent to Maven/Clojars
* TODO: practicalli.template/data-science-visualisation - general library, deploymnent to Maven/Clojars


3rd party templates
* Clerk template - https://github.com/mentat-collective/clerk-utils/tree/main/resources/clerk_utils/custom

## Usage




If `deps-new` is installed as a `project-new` "tool" via:

```bash
clojure -Ttools install io.github.seancorfield/deps-new '{:git/tag "v0.5.0"}' :as project-new
```

> Note: once the template has been published (to a public git repo), the invocation will be the same, except the `:local/root` dependency will be replaced by a git or Maven-like coordinate.


## Development

Run tests

> [Practicalli Blog: Create deps-new template for Clojure CLI projects](https://practical.li/blog-staging/posts/create-deps-new-template-for-clojure-cli-projects/)


## License

Copyright © 2023 Practicalli

Creative Commons Attribution Share-Alike 4.0 International
