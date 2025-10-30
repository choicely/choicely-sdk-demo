# Choicely Android SDK · Quick Start

Quickly integrate the Choicely Android SDK into a fresh project by following these steps. This guide covers repository setup, dependencies, and essential configuration for both Java and Kotlin projects.

## 1. Create an Android Project

Open Android Studio and click **New Project** to create a new project. Choose your desired project template, for example **Empty Activity**, and click **Next**. Now enter your app name and package name.

## 2. Set Java & Kotlin and AGP Version

Make sure to set the Java version to **17** and Kotlin version to **2.2.10** in your project settings. Also, ensure that you are using the latest version of the Android Gradle Plugin (AGP) for optimal compatibility with the Choicely SDK.

## 3. Open Build.gradle (App)

Navigate to the `build.gradle` file located in the app module. This is where you'll add the necessary configurations for the Choicely SDK.

### Set Compile Options

```kotlin
compileOptions {
    sourceCompatibility JavaVersion.VERSION_17
    targetCompatibility JavaVersion.VERSION_17
}
kotlinOptions {
    jvmTarget = "17"
}
```

### Add Repository Server

To access the Choicely SDK, add the Maven Central repository to your project.

**Java:**

```groovy
pluginManagement {
    repositories {
        ...
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        mavenCentral()
    }
}
```

**Kotlin:**

```kotlin
pluginManagement {
    repositories {
        ...
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        mavenCentral()
    }
}
```

## 4. Add the Choicely SDK

Add the following to your app-level `build.gradle` file inside the `dependencies` block.

**Java:**

```groovy
implementation platform("com.choicely.sdk:bom:1.1.0")
implementation "com.choicely.sdk:android-core"
```

**Kotlin:**

```groovy
implementation(platform("com.choicely.sdk:bom:1.1.0"))
implementation("com.choicely.sdk:android-core")
```

> **Note:**
> For testing purposes, you can use this app key:
>
> ```
> Y2hvaWNlbHktZXUvYXBwcy9kS1lHUUtUbWREa1pRb1ltZFRiZQ
> ```
>
> Or create a new app using Choicely Builder: [How to create apps with Choicely](https://www.choicely.com/tutorials/how-to-create-apps-with-choicely-using-an-app-template)

## 5. Create Application Class

Create an `Application` class and initialize the Choicely SDK inside `onCreate()`. Then, set your application class in `AndroidManifest.xml`.

**Java:**

```java
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ChoicelySDK.init(this,"Y2hvaWNlbHktZXUvYXBwcy9kS1lHUUtUbWREa1pRb1ltZFRiZQ");
    }
}
```

**Kotlin:**

```kotlin
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ChoicelySDK.init(this,"Y2hvaWNlbHktZXUvYXBwcy9kS1lHUUtUbWREa1pRb1ltZFRiZQ")
    }
}
```

**Add Application Class in Manifest**

```xml
<application
    android:name=".MyApplication"
    ...other attributes...
>
    ...
</application>
```

