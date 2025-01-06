# -------------------------------------- #
# Practicalli Makefile
#
# Consistent set of targets to support local development of Clojure
# and build the Clojure service during CI deployment
#
# `-` before a command ignores any errors returned

# Requirements
# - cljstyle
# - Clojure CLI aliases
#   - `:dev/env` to include `dev` directory on class path
#   - `:test/env` to include `test` directory and libraries to support testing
#   - `:test/run` to run kaocha kaocha test runner and supporting paths and dependencies
#   - `:repl/rebel` to start a Rebel terminal UI
#   - `:build/task` to build this project into a jar or uberjar
# - docker
# - mega-linter-runner
# -------------------------------------- #

# -- Makefile task config -------------- #
# .PHONY: ensures target used rather than matching file name
# https://makefiletutorial.com/#phony
.PHONY: all clean  deps dist docs lint pre-commit-check repl test test-ci test-watch
# -------------------------------------- #

# -- Makefile Variables ---------------- #
# run help if no target specified
.DEFAULT_GOAL := help

# Column the target description is printed from
HELP-DESCRIPTION-SPACING := 24

# Tool variables
CLOJURE_TEST_RUNNER = clojure -M:test/env:test/run
CLOJURE_EXEC_TEST_RUNNER = clojure -X:test/env:test/run
DOCKER-BUILD-LOGFILE := docker-build-log-$(shell date +%y-%m-%d-%T).md
MEGALINTER_RUNNER := npx mega-linter-runner --flavor java --env "'MEGALINTER_CONFIG=.github/config/megalinter.yaml'" --remove-container
OUTDATED_FILE := outdated-$(shell date +%y-%m-%d-%T).md

# Makefile file and directory name wildcard
# EDN-FILES := $(wildcard *.edn)
# ------------------------------------ #

# -- Help ------------------------------ #
# Source: https://nedbatchelder.com/blog/201804/makefile_help_target.html

help:  ## Describe available tasks in Makefile
	@grep '^[a-zA-Z]' $(MAKEFILE_LIST) | \
	sort | \
	awk -F ':.*?## ' 'NF==2 {printf "\033[36m  %-$(HELP-DESCRIPTION-SPACING)s\033[0m %s\n", $$1, $$2}'
# -------------------------------------- #

# -- Clojure Workflow ------------------ #
repl: rebel  ## Start default REPL configuration

rebel:  ## Run Clojure REPL with rich terminal UI (Rebel Readline)
	$(info -- Run Rebel REPL ------------------------)
	clojure -M:dev/env:test/env:repl/rebel

reloaded:  ## Run Clojure REPL with rich terminal UI (Rebel Readline)
	$(info -- Run Rebel REPL ------------------------)
	clojure -M:repl/reloaded

deps: deps.edn  ## Prepare dependencies for test and dist targets
	$(info -- Download test and service libraries ---)
	clojure -P -M:test/run && clojure -P -T:build/task

dist: build-uberjar ## Build and package Clojure service
	$(info -- Build and Package Clojure service -----)

clean:  ## Clean Clojure tooling temporary files
	$(info -- Clean Clojure temporary files ---------)
	- rm -rf ./.cpcache ./.clj-kondo/cache ./.lsp

run:  ## Run Service using clojure.main
	$(info -- Download test and service libraries ---)
	clojure -M:run/service

outdated: ## Check deps.edn & GitHub actions for new versions
	$(info -- Search for outdated libraries ---------)
	- clojure -T:search/outdated > $(OUTDATED_FILE)
# -------------------------------------- #

# -- Testing --------------------------- #
test-config:  ## Print Kaocha test runner configuration
	$(info -- Runner Configuration ------------------)
	$(CLOJURE_TEST_RUNNER) --print-config

test-profile:  ## Profile unit test speed, showing 3 slowest tests
	$(info -- Runner Profile Tests ------------------)
	$(CLOJURE_TEST_RUNNER) --plugin  kaocha.plugin/profiling

test:  ## Run unit tests - stoping on first error
	$(info -- Runner for unit tests -----------------)
	$(CLOJURE_EXEC_TEST_RUNNER)

test-all:  ## Run all unit tests regardless of failing tests
	$(info -- Runner for all unit tests -------------)
	$(CLOJURE_EXEC_TEST_RUNNER) :fail-fast? false

test-watch:  ## Run tests when changes saved, stopping test run on first error
	$(info -- Watcher for unit tests, fail fast -----)
	$(CLOJURE_EXEC_TEST_RUNNER) :watch? true

test-watch-all:  ## Run all tests when changes saved, regardless of failing tests
	$(info -- Watcher for unit tests ----------------)
	$(CLOJURE_EXEC_TEST_RUNNER) :fail-fast? false :watch? true
# -------------------------------------- #

# -- Build tasks ----------------------- #
build-config: ## Pretty print build configuration
	$(info --------- View current build config ------)
	clojure -T:build/task config

build-jar: ## Build a jar archive of Clojure project
	$(info --------- Build library jar --------------)
	clojure -T:build/task jar

build-uberjar: ## Build a uberjar archive of Clojure project & Clojure runtime
	$(info --------- Build service Uberjar  ---------)
	clojure -T:build/task uberjar

build-uberjar-echo: ## Build a uberjar archive of Clojure project & Clojure runtime
	$(info -- Build service Uberjar  ----------------)
	$(info -- Prerequisites newer than target -------)
	echo $?
	clojure -T:build/task uberjar

build-clean: ## Clean build assets or given directory
	$(info -- Clean Build  --------------------------)
	clojure -T:build/task clean
# -------------------------------------- #

# -- Code Quality ---------------------- #
pre-commit-check: format-check lint test  ## Run format, lint and test targets

format-check: ## Run cljstyle to check the formatting of Clojure code
	$(info -- cljstyle Runner show errors -----------)
	cljstyle check

format-fix:  ## Run cljstyle and fix the formatting of Clojure code
	$(info -- cljstyle Runner fix errors ------------)
	cljstyle fix

lint:  ## Run MegaLinter with custom configuration (node.js required)
	$(info -- MegaLinter Runner ---------------------)
	$(MEGALINTER_RUNNER)

lint-fix:  ## Run MegaLinter with applied fixes and custom configuration (node.js required)
	$(info -- MegaLinter Runner fix errors ----------)
	$(MEGALINTER_RUNNER) --fix

lint-clean:  ## Clean MegaLinter report information
	$(info -- MegaLinter Clean Reports --------------)
	- rm -rf ./megalinter-reports

megalinter-upgrade:  ## Update MegaLinter config to latest version
	$(info --------- MegaLinter Upgrade Config ---------)
	npx mega-linter-runner@latest --upgrade
# -------------------------------------- #

# -- Docker Containers ----------------- #
docker-build:  ## Build Clojure project and run with docker compose
	$(info -- Docker Compose Build ------------------)
	docker compose up --build --detach

docker-build-log:  ## Build Clojure project and run with docker compose - log to file
	$(info --------- Docker Compose Build ---------)
	docker compose up --build --detach &> $(DOCKER-BUILD-LOGFILE) | tee $(DOCKER-BUILD-LOGFILE)

docker-build-clean:  ## Build Clojure project and run with docker compose, removing orphans
	$(info -- Docker Compose Build, remove orphans --)
	docker compose up --build --remove-orphans --detach

docker-down:  ## Shut down containers in docker compose
	$(info -- Docker Compose Down -------------------)
	docker compose down

docker-inspect:  ## Inspect given docker image - image-id=12e45fg89
	$(info -- Docker Image Prune --------------------)
	docker inspect --format='{{json .Config}}' $(image-id) | jq

docker-image-prune:  ## Prune docker images
	$(info -- Docker Image Prune --------------------)
	docker image prune

docker-container-prune:  ## Prune docker containers
	$(info -- Docker Container Prune ----------------)
	docker container prune

docker-prune: docker-image-prune docker-image-prune  ## Prune docker images and containers

swagger-editor:  ## Start Swagger Editor in Docker
	$(info -- Run Swagger Editor at locahost:8282 ---)
	docker compose -f swagger-editor.yaml up -d swagger-editor --detatch

swagger-editor-down:  ## Stop Swagger Editor in Docker
	$(info -- Run Swagger Editor at locahost:8282 ---)
	docker compose -f swagger-editor.yaml down
# -------------------------------------- #

# -- Continuous Integration ------------ #
# .DELETE_ON_ERROR: halts if command returns non-zero exit status
# https://makefiletutorial.com/#delete_on_error

# TODO: focus runner on ^:integration` tests
test-ci: deps  ## Test runner for integration tests
	$(info -- Runner for integration tests ---------)
	clojure -P -X:test/env:test/run

# Run tests, build & package the Clojure code and clean up afterward
# `make all` used in Docker builder stage
.DELETE_ON_ERROR:
all: test-ci dist clean  ## Call test-ci dist and clean targets, used for CI
# -------------------------------------- #
