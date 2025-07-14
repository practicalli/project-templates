# Change Log

All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

# [Unreleased]

## Added
- dev: ci scheduled stale issue & pr check (monthly)
- dev: update to clojure 1.12.1

## Changed
- dev: update clj-kondo to version 2024.09.27 in quality-checks workflow
- dev: update Clojure CLI to version 1.12.0.1479 in quality-checks workflow
- dev: update Clojure library to version 1.12.0 in deps.edn
- dev: update clojure-lint-action to v4
- dev: update setup-clojure to 13.1
- dev: update clojure cli to 1.12.0.1495
- dev: add standard Practicalli tasks to Makefile
- minimal: move `dev` files into `root` of template
- templates: clojure 0.12.0 in all templates
- templates: design-journal namespace in all templates


# 2024-09-09
## Added
- dev: outdated Makefile task to identify newer library versions using antq
- dev: updated library versions for `quality-checks.yaml` GitHub workflows
- templates: update library dependency versions, clojure, reitit, http-kit, tools.build

## Changed
- dev: update to clj-kondo 2024.08.29 in quality-checks workflow
- dev: megalinter-upgrade task to upgrade config
- dev: update megalinter config to version 8
- libs: monthly updates via make outdated (antq)

| :file     | :name                            | :current | :latest |
|-----------+----------------------------------+----------+---------|
| deps.edn  | io.github.seancorfield/deps-new  | v0.7.1   | v0.8.0  |
| deps.edn  | org.clojure/clojure              | 1.11.3   | 1.12.0  |
| pom.xml   | org.clojure/clojure              | 1.11.2   | 1.12.0  |

# 2024-04-20
## Changed
- service: system helper function in repl help menu
- security: update to clojure 1.11.2
- library: update tools.build to 0.10.0 - caches correctly in docker
- templates: update mulog-events/stop publisher help & example
- make: docker-build-log task to create log file of all docker output for diagnosis

# 2024-04-08

## Changed
- dev: repository trivy ignore CVE-2024-22871
- service: move mulog publisher inside donut system config
- readme: simplify readme, add overview, remove older examples
- service: refactor template-edn function to aid diagnosis
- service: mulog donut config for user repl startup
- service: party.donut/system  version 0.0.241

# 2024-01-23
## Changed
- health: remove FUNDING.yaml and use Practicalli Org file
- readme: update sponsorship link to practicalli-johnny account
- dev: add license to project and templates with gitignore pattern
- minimal: update `-main` to print return values


# 2024-01-05
## Changed
- dev: update upload-artifactv4 action in megalinter workflow
- dev: setup-java v4 action in quality-checks workflow
- dev: clojure cli 1.11.1.1435 in quality-checks workflow
- dev: deps-new v0.6.0 library dependency in deps.edn


# 2023-11-03
## Changed
- dev: remove `:build` from cider-jack-in configuration in .dir-locals.el
- templates: git ignore excluded all pattern from root directory, include general project and Clojure specific patterns
- dev: checkout action v4 in GitHub workflow
- template: checkout action v4 in all GitHub workflow
- dev: setup-clojure action v12.1 in GitHub workflow
- template: setup-clojure action v12.1 in all GitHub workflow
- template: Clojure CLI version 1.11.1.1413 in quality-check workflow
- template: lambdaisland kaocha version 1.87.1366
- dev: lambdaisland kaocha version 1.87.1366
- dev: update seancorfield/deps-new to v0.5.3


# 2023-08-02
## Changed
- minimal: remove `:build` from `.dir-locals.el` project configuration


# 2023-08-01
## Changed
- ci: update Clojure CLI version 1.11.1.1356
- ci: spell lychee link checker errors as warnings - false positives on github action versions, etc.
- ci: repository trufflehog secrets checker errors as warnings - false positive on secretlintrc.json


# 2023-07-26
## Changed
- minimal: refactor dev repl workflow files to be consistent with other templates
- minimal: require for mulog

# 2023-07-17-2
## Changed
- update integrant rule to use router_config source file

# 2023-07-17-1
## Added
- router with system-config template files (donut, integrant)

# 2023-07-17-1
## Changed
- fix(service) rouge port expression removed
- fix(service) `-main` takes port value on command line
- fix(service) redundant http-kit require
- fix(service) update start function in serice-repl (default)
- fix(service) router as `def` (default)


## 2023-07-14
### Added
- [#19](https://github.com/practicalli/project-templates/issues/19) `practicalli/minimal` template
- templates: link to Practicalli Clojure Project templates section for help after new project is created
- [#22](https://github.com/practicalli/project-templates/pull/22) Service template with `:component` option for `:donut` and `:integrant`
- service: run task to run service using clojure.main

### Changed
- ci: update MegaLinter GitHub Action v7 in MegaLnter workflow
- ci: set monthly schedule and cron examples for alternative schedules
- dev: `MEGALINTER_RUNNER` Makefile variable for repeated commands with common options
- service: refactor integrant config and code
- minimal: correct dependencies config
- application: refactor portal and mulog REPL startup
- dev: clarify use of templates

## 2023-06-11
## Added
- `practicalli/landing-page` template
### Changed
- ci: simplify megalinter workflow, remove apply fix configuration
- dev: Makefile task for local megalinter runner with apply fixes

## 2023-04-22
### Changed
- [#13](https://github.com/practicalli/project-templates/issues/13) docker: swagger-editor as separate compose configuration
- [#12](https://github.com/practicalli/project-templates/issues/12) docker: postgres image healthcheck (compose.yaml)
- [#11](https://github.com/practicalli/project-templates/issues/11) docker: container healthcheck configuration (Dockerfile)
- [#10](https://github.com/practicalli/project-templates/issues/10) service: resolve docker compose container exits
- dev: docker tasks detach from containers, update task docs
- dev: update unit test tasks
- dev: minor dev/user updates
- docker: refactor container name & update config docs
- docker: swagger-editor as separate configuration
- application: specify development workflow steps
- application: enhance main app namespace code
- application: remove :test/watch alias
- application: update main-namespace in build script
- service: development section elaboration and formatting
- ci: update funding account name
- ci: setup-clojure & create-pull-request version update
- ci: update megalinter config for markdown, yaml, secrets


## 2023-04-22
### Changed
- `dev` directory separated from `root` and declarative copy rules defined, service.clj renamed to template to avoid format false positives
- format: exclude `dev` directory from format checks
- [#6](https://github.com/practicalli/project-templates/issues/6) add clojure.spec specification to response validation of scoreboard route
- [#7](https://github.com/practicalli/project-templates/issues/7) resolved multiple portal windows on refresh
- [#9](https://github.com/practicalli/project-templates/issues/9) update code examples in template with cljstyle fix

## 2023-04-20
### Changed
- make: lint task uses npx megalinter command (no manual install)
- make: lint task removes Docker container after all test have run (avoid stale containers)
- format: cljstyle fix for clojure code in templates
- ci: use GitHub Actions major versions in all GitHub workflows
- ci: ignore markdown headings in MegaLinter
- ci: cljstyle configuration - remove duplicate defn rule

## 2023-04-19
### Changed
- MegaLinter workflow and configuration for all templates:
  - enable lint groups, disable tools causing false positives
  - include first interaction to add practicalli contributing guide to initial pull request
  - move linter specific configuration to config/megalinter.yaml
- clj-kondo: CI specific configuration
- markdownlint: recreate jsonc config from template
- changelog check: add echo statements for greater clarity
- lint review: add echo statements for greater clarity
- update all GitHub Actions to latest available versions (from scheduled-version-check report)
- removed debug code from templates

## 2023-04-18

### Added

- project-template ci: add commonly used GitHub workflows and configuration files
  - MegaLinter lints docs, code and config files
  - Lint Review uses clj-kondo & reviewdog to add errors as comments
  - Scheduled Version Check uses antq to check library and action versions
  - Changelog Checker uses changlog enforcer to support good communication
  - Quality Check run clj-kondo, cljstyle and kaocha test runner
  - CODEOWNERS sets GitHub users automatically added to pull requests as reviewers
  - FUNDING links project to GitHub users sponsorship page
  - pull_request_template provides template for pull requests
- [#4](https://github.com/practicalli/project-templates/issues/4) `practicalli/application` production template
  - Dockerfile and compose.yaml example configuration
  - Makefile for build automation
  - GitHub workflows (MegaLinter, Lint Review, Changelog, Version Check)
  - Mulog Event logging and Portal publisher
  - REPL Reloaded tooling support

### Changed

- removed tools.build build script created by deps-new template - not required

## 2023-04-12

### Added

- [#2](https://github.com/practicalli/project-templates/issues/2) `practicalli/service` template initial release

[Unreleased]: https://github.com/practicalli.template/service/compare/2023.04.12...HEAD
