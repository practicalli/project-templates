# Change Log

All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

## [Unreleased]

## Added
- [#19](https://github.com/practicalli/project-templates/issues/19) `practicalli/minimal` template
- templates: link to Practicalli Clojure Project templates section for help after new project is created
### Changed
- ci: update MegaLinter GitHub Action v7 in MegaLnter workflow
- ci: set monthly schedule and cron examples for alternative schedules
- dev: `MEGALINTER_RUNNER` Makefile variable for repeated commands with common options

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
