# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/iskandarsetiadi/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-optimizationpasses 5
-repackageclasses ''

# Android common:
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

-keepclassmembers class * {
    static final %                *;
    static final java.lang.String *;
}

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.content.Context {
   public void *(android.view.View);
   public void *(android.view.MenuItem);
}

-keepclassmembers class * implements android.os.Parcelable {
    static ** CREATOR;
}

# Preserve annotations, line numbers, and source file names (added manually)
-keepattributes *Annotation*,SourceFile,LineNumberTable

# Ignore warnings (added manually)
-dontwarn android.app.*
-dontwarn android.view.*

# Android support library (added manually)
-dontnote android.support.v4.**
-dontnote android.support.v7.**

# Keep resources file (In order to prevent not found resource issue)
-keepattributes InnerClasses
-keep class **.R
-keep class **.R$* {
    <fields>;
}

-adaptresourcefilenames    **.properties,**.gif,**.jpg
-adaptresourcefilecontents **.properties,META-INF/MANIFEST.MF

# Keep native & callbacks
-keepclasseswithmembernames class *{
    native <methods>;
}

-keepattributes JNINamespace
-keepattributes CalledByNative
-keepattributes *Annotation*
-keepattributes EnclosingMethod
