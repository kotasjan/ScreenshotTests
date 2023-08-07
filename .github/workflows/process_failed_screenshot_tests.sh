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
git commit -m "📸 Update screenshots "
git push --force "https://$GITHUB_TOKEN@github.com/$GITHUB_REPOSITORY.git"

printf -v PULL_REQUEST_COMMENT "Screenshot tests failed.\n\n[See differences](https://github.com/%s/compare/%s...%s)\n\nMerge the branch if it's an intentional change." "$GITHUB_REPOSITORY" "$PULL_REQUEST_BRANCH" "$NEW_BRANCH_NAME"
EOF=$(dd if=/dev/urandom bs=15 count=1 status=none | base64)
{
  echo "PULL_REQUEST_COMMENT<<$EOF"
  echo "$PULL_REQUEST_COMMENT"
  echo "$EOF"
} >>"$GITHUB_OUTPUT"
