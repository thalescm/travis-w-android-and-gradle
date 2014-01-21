#!/bin/sh
set -e

  # Install base Android SDK
sudo apt-get update -qq;
if [ `uname -m` = x86_64 ]; then sudo apt-get install -qq --force-yes libgd2-xpm ia32-libs ia32-libs-multiarch > /dev/null; fi
wget http://dl.google.com/android/android-sdk_r22.3-linux.tgz;
tar xzf android-sdk_r22.3-linux.tgz;
# $PATH=${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools;


# Install Android build tools;
wget https://dl-ssl.google.com/android/repository/build-tools_r$ANDROID_BUILD_TOOLS_VERSION-linux.zip;
unzip build-tools_r$ANDROID_BUILD_TOOLS_VERSION-linux.zip -d $ANDROID_HOME;
mkdir -p $PWD/android-sdk-linux/build-tools/;
mv $PWD/android-sdk-linux/android-$ANDROID_OS_VERSION $PWD/android-sdk-linux/build-tools/$ANDROID_BUILD_TOOLS_VERSION;
# $PATH=${PATH}:${ANDROID_HOME}/build-tools;

#- android list sdk -a -e
echo "y" | $PWD/android-sdk-linux/tools/android update sdk --filter platform-tool,tool --no-ui --force > /dev/null;
echo "y" | $PWD/android-sdk-linux/tools/android update sdk --filter $ANDROID_SDKS --no-ui --force > /dev/null;