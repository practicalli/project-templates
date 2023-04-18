# Change Log

All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

## [Unreleased]

### Added
- ci: add commonly used GitHub workflows and configuration files
  - MegaLinter lints docs, code and config files
  - Lint Review uses clj-kondo & reviewdog to add errors as comments
  - Scheduled Version Check uses antq to check library and action versions
  - Changelog Checker uses changlog enforcer to support good communication
  - Quality Check run clj-kondo, cljstyle and kaocha test runner
  - CODEOWNERS sets GitHub users automatically added to pull requests as reviewers
  - FUNDING links project to GitHub users sponsorship page
  - pull_request_template provides template for pull requests

## 2023-04-12

### Added

- [#2](https://github.com/practicalli/project-templates/issues/2) `practicalli/service` template initial release

[Unreleased]: https://github.com/practicalli.template/service/compare/2023.04.12...HEAD
