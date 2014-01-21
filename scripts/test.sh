#!/bin/sh
set -e

#- android list sdk -a -e
echo "y" | android update sdk --filter platform-tool,tool --no-ui --force > /dev/null;
echo "y" | android update sdk --filter $ANDROID_SDKS --no-ui --force > /dev/null;

# Create and start emulator
echo no | android create avd --force -n test -t $ANDROID_TARGET --abi $ANDROID_ABI;
emulator -avd test -no-skin -no-audio -no-window &;