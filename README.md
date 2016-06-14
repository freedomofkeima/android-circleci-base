# android-circleci-base

[![CircleCI](https://circleci.com/gh/freedomofkeima/android-circleci-base.svg?style=svg)](https://circleci.com/gh/freedomofkeima/android-circleci-base)

This repository contains my Android base code which can be used to build other Android applications. It has an integration to [CircleCI](https://circleci.com/).

# How to Release

You need to configure following values in `gradle.properties` and update your `build.gradle` file.

```
productKeyStore=
productKeyStorePassword=
productKeyAlias=
productKeyAliasPassword=
```

## Unit Test

By using Android SDK, you can create a new AVD (let's say, the name is `testing`), and run the following command to run it:

```
$ emulator -avd testing -no-audio -no-window -no-boot-anim
```

The entire process may take up to 5 minutes.

You can run unit tests locally by:

```
$ ./gradlew -i connectedAndroidTest --stacktrace
```

## Additional Information

CircleCI sometimes throws an exception `com.android.ddmlib.ShellCommandUnresponsiveException`. If this problem occurs, you need to press rebuild it again.

Guidelines:

* [Android Code Style](https://source.android.com/source/code-style.html)
* [Android Guideline](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md)

Other references for application design:

* http://www.innofied.com/13-android-development-best-practices/
* http://code.tutsplus.com/articles/introduction-to-android-design-patterns--cms-20808

Other references for security design:

* http://developer.android.com/intl/ja/training/articles/security-tips.html
* http://developer.android.com/intl/ja/google/play/billing/billing_best_practices.html#obfuscate
* http://www.jssec.org/dl/android_securecoding_en.pdf

## License

MIT License.

Last Updated: June 14, 2016

