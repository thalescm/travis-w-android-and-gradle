#!/bin/sh
set -e

curl "http://testflightapp.com/api/builds.json"  \
    -F file=@"$TRAVIS_BUILD_DIR/MyFirstApp/build/apk/MyFirstApp-release.apk" \
    -F api_token=$TESTFLIGHT_API_TOKEN \
    -F team_token=$TESTFLIGHT_TEAM_TOKEN \
    -F notes="Build by Travis CI" \
    -F notify=True \
    -F distribution_lists="Internal"