#!/bin/sh
set -e

#- android list sdk -a -e
echo "y" | $PWD/android-sdk-linux/tools/android update sdk --filter platform-tool,tool --no-ui --force > /dev/null;
echo "y" | $PWD/android-sdk-linux/tools/android update sdk --filter $ANDROID_SDKS --no-ui --force > /dev/null;

# Create and start emulator
echo no | $PWD/android-sdk-linux/tools/android create avd --force -n test -t $ANDROID_TARGET --abi $ANDROID_ABI;
$PWD/android-sdk-linux/tools/emulator -avd test -no-skin -no-audio -no-window &;