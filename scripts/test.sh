#!/bin/sh
set -e

# Create and start emulator
echo no | $PWD/android-sdk-linux/tools/android create avd --force -n test -t $ANDROID_TARGET --abi $ANDROID_ABI;
$PWD/android-sdk-linux/tools/emulator -avd test -no-skin -no-audio -no-window &