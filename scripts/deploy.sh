#!/bin/sh
set -e

RELEASE_DATE=`date '+%Y-%m-%d %H:%M:%S'`
RELEASE_NOTES="Build: $TRAVIS_BUILD_NUMBER - Uploaded: $RELEASE_DATE"

curl "http://testflightapp.com/api/builds.json"  \
    -F file=@"$TRAVIS_BUILD_DIR/MyFirstApp/build/apk/MyFirstApp-release.apk" \
    -F api_token=$TESTFLIGHT_API_TOKEN \
    -F team_token=$TESTFLIGHT_TEAM_TOKEN \
    -F notify=true \
    -F distribution_lists="$TESTFLIGHT_DISTRIBUTION_LIST" \
    -F notes="$RELEASE_NOTES"