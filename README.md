# Automated CI Screenshot Testing using Showkase & Paparazzi

This multi-module project demonstrates the integration of
the [Showkase](https://github.com/airbnb/Showkase) library with
the [Paparazzi](https://github.com/cashapp/paparazzi) screenshot testing library. It showcases how
to document and test UI components across different modules of an Android project. A specialized
Github Actions CI job ensures all screenshot tests are up-to-date before any pull request can be
merged.

## Repository Structure:

- **coreui**: Contains app theming and shared UI components.
- **feature**: An example module for a standalone feature.

## Key Features:

1. **Showkase Integration**: Visual documentation of UI components.
2. **Paparazzi Screenshot Tests**: Capture and comparison of UI screenshots.
3. **Emulator-Free Github Action**: Runs screenshot tests without an Android emulator.

## Setup:

### Prerequisites:

- Android Studio Flamingo | 2022.2.1
- JDK 17

### Steps:

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/kotasjan/ScreenshotTests.git
   ```

2. **Git Hooks Path Setup:**

   Set the path to the git hooks:
   ```bash
   git config core.hooksPath .githooks
    ```

3. **Git LFS Setup:**

   Install Git LFS:
   ```bash
   brew install git-lfs
   ```
   Ensure you've installed Git LFS to avoid warnings from githooks when pushing changes.

4. **Screenshot Verification and Recording:**

   To verify all screenshots in the app:
    ```bash
    ./gradlew verifyPaparazziDebug --continue
    ```

   To update all screenshots:
    ```bash
    ./gradlew recordPaparazziDebug
    ```

## CI Integration:

This project integrates with Github Actions for continuous integration. The Github Action job is set
up to ensure that screenshots are up-to-date. If there's a failure in screenshot verification, the
script [`.github/workflows/process_failed_screenshot_tests.sh`](https://github.com/kotasjan/ScreenshotTests/blob/main/.github/workflows/process_failed_screenshot_tests.sh)
runs. This script records new screenshots, adds them to a new branch, and sends feedback to the
Github Action, informing about the branch with the updated screenshots.

For the main CI configuration, refer
to [`.github/workflows/pull-request.yml`](https://github.com/kotasjan/ScreenshotTests/blob/main/.github/workflows/pull-request.yml).

## Branches:

- **main**: Core branch which also contains some recent updates of Paparazzi configuration and other
  minor changes.
- **showkase**: Setup of Showkase library & use of annotations for components, colors, and
  typography.
- **paparazzi**: Integrates Paparazzi, sets up GIT LFS, githooks, and contains screenshot tests for
  the SampleScreen in the feature module.
- **paparazzi-showkase**: Demonstrates the combined use of Paparazzi and Showkase, testing shared
  components, colors, and typography.
- **github-action**: Contains the Github Action setup for pull request checks, ensuring all
  screenshots are updated.
- **example-change**: Demonstrates a simple UI change that leads to screenshot tests failing.
  Observe the impact of this change in an
  open [pull request](https://github.com/kotasjan/ScreenshotTests/pull/4), where you can see the
  Github Action job failure. The resulting comment in the pull request provides
  a [link to the diff](https://github.com/kotasjan/ScreenshotTests/compare/example-ui-change...screenshots/pr-4)
  between the newly created branch and the PR target branch.

## Contributing:

Contributions in the form of fixes or improvements are always welcome! However, please note that
there are currently no plans to expand this project further. The primary objective of this project
was to demonstrate the combined use of Showkase, Paparazzi, and Github Action in a multi-module
Android project. Ensure you test your changes with the provided CI setup before submitting a PR.

## License:

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgements:

- [Showkase](https://github.com/airbnb/Showkase)
- [Paparazzi](https://github.com/cashapp/paparazzi)
- A special thanks to [David Vavra](https://github.com/davidvavra) for his
  project [showkase-screenshot-tests](https://github.com/davidvavra/showkase-screenshot-tests),
  which served as an initial inspiration.




