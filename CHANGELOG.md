# Change Log

All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

## [Unreleased]

## 2023-04-22
### Changed
- `dev` directory separated from `root` and declarative copy rules defined, service.clj renamed to template to avoid format false positives
- format: exclude `dev` directory from format checks
- [#6](https://github.com/practicalli/project-templates/issues/6) add clojure.spec specification to response validation of scoreboard route
- [#7](https://github.com/practicalli/project-templates/issues/7) resolved multiple portal windows on refresh
- [#9](https://github.com/practicalli/project-templates/issues/9) update code examples in template with cljstyle fix

## 2023-04-21
### Changed
- docker compose template: fixed some typos preventing `docker-compose` from running

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
