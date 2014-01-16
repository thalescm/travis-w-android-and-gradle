travis-w-android-and-gradle
===========================

--- 

Configuring an Eclipse Wizard generated project to be hosted on Travis, building and generating releases with gradle.

---

To fork this project, some configuration is needed.

##First of all: 

- Install the android sdk: http://developer.android.com/sdk/index.html
- Add ANDROID_HOME to your enviroment variables (the sdk directory) or the sdk.dir to the project's local.properties


Ok, now you're allright to start using the project.

You don't need to have gradle installed. To do any gradle task, just use the wrapper.
In your command line:

        ./gradlew <the task>

See the results!

##Bibliography

http://spring.io/guides/gs/gradle-android/

http://tools.android.com/tech-docs/new-build-system/user-guide#TOC-Multi-project-setup

