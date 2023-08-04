#!/bin/bash

if [[ -z ${GITHUB_TOKEN} ]]; then
  echo "Missing GITHUB_TOKEN variable"
  exit 1
fi

if [[ -z ${GITHUB_REPOSITORY} ]]; then
  echo "Missing GITHUB_REPOSITORY variable"
  exit 1
fi

if [[ -z ${PULL_REQUEST_BRANCH} ]]; then
  echo "Missing PR_BRANCH variable"
  exit 1
fi

./gradlew recordPaparazziDebug

PULL_REQUEST_NUMBER=${GITHUB_REF#refs/pull/}
PULL_REQUEST_NUMBER=${PULL_REQUEST_NUMBER/\/merge/}
NEW_BRANCH_NAME="screenshots/pr-$PULL_REQUEST_NUMBER"
echo "::set-output name=PULL_REQUEST_NUMBER::$PULL_REQUEST_NUMBER"

git config user.name "CI/CD"
git config user.email "kotasjn@gmail.com"

git fetch --all
git checkout --track "origin/$PULL_REQUEST_BRANCH"
git checkout -b "$NEW_BRANCH_NAME"
git add -A
git commit -m "Update screenshots"
git push --force "https://$GITHUB_TOKEN@github.com/$GITHUB_REPOSITORY.git"

echo "::set-output name=PULL_REQUEST_COMMENT::\"Screenshot tests failed.\\n\\n[See differences](https://github.com/$GITHUB_REPOSITORY/compare/$PULL_REQUEST_BRANCH...$NEW_BRANCH_NAME)\\n\\nMerge the branch if it's an intentional change.\""
