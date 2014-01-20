#!/bin/sh
set -e

#!/bin/sh
if [ "$TRAVIS_PULL_REQUEST" != "false" ]; then
  echo "This is a pull request. No deployment will be done."
  exit 0
fi
if [ "$TRAVIS_BRANCH" != "master" ]; then
  echo "Testing on a branch other than master. No deployment will be done."
  exit 0
fi

RELEASE_DATE=`date '+%Y-%m-%d %H:%M:%S'`
RELEASE_NOTES="Build: $TRAVIS_BUILD_NUMBER - Uploaded: $RELEASE_DATE"

curl "http://testflightapp.com/api/builds.json"  \
    -F file=@"$TRAVIS_BUILD_DIR/MyFirstApp/build/apk/MyFirstApp-release.apk" \
    -F api_token=$TESTFLIGHT_API_TOKEN \
    -F team_token=$TESTFLIGHT_TEAM_TOKEN \
    -F notify=true \
    -F distribution_lists="$TESTFLIGHT_DISTRIBUTION_LIST" \
    -F notes="$RELEASE_NOTES"