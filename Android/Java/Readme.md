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
        maven { url 'https://jitpack.io' }
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
        mavenCentral()
    }
}
```

**Kotlin:**

```kotlin
pluginManagement {
    repositories {
        ...
        maven(url = "https://jitpack.io")
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven(url = "https://jitpack.io")
        mavenCentral()
    }
}
```

## 4. Add the Choicely SDK

Add the following to your app-level `build.gradle` file inside the `dependencies` block.

**Java:**

```groovy
implementation platform("com.choicely.sdk:bom:1.0.3")
implementation "com.choicely.sdk:android-core"
```

**Kotlin:**

```groovy
implementation(platform("com.choicely.sdk:bom:1.0.3"))
implementation("com.choicely.sdk:android-core")
```

## 5. Add App Key and Other Config

Add your app key in `res/values/strings.xml`:

```xml
<resources>
    <string name="choicely_app_key" translatable="false">{App Key}</string>
</resources>
```

> **Note:**
> For testing purposes, you can use this app key:
>
> ```
> Y2hvaWNlbHktZXUvYXBwcy9kS1lHUUtUbWREa1pRb1ltZFRiZQ
> ```
>
> Or create a new app using Choicely Builder: [How to create apps with Choicely](https://www.choicely.com/tutorials/how-to-create-apps-with-choicely-using-an-app-template)

## 6. Create Application Class

Create an `Application` class and initialize the Choicely SDK inside `onCreate()`. Then, set your application class in `AndroidManifest.xml`.

**Java:**

```java
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ChoicelySDK.init(this);
    }
}
```

**Kotlin:**

```kotlin
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ChoicelySDK.init(this)
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

> **Note:** Make sure no launcher activity is enabled.

> **Note:** For real-time updates, you need to integrate the Firebase SDKs.

Our SDK allows you to create custom screens and embed Choicely content (articles, surveys, etc.) alongside your own UI logic.

## 7. Steps to Add a Custom Screen

### 7.1 Create a Custom Fragment

Create a fragment that extends `ChoicelyContentFragment`.

**Java:**

```java
public class MyCustomScreen extends ChoicelyContentFragment {
    ChoicelyTextView textView;
    EditText editText;
    Button button;
    FrameLayout articleContainer;
    FrameLayout surveyContainer;

    @Override
    protected int getLayout() {
        return R.layout.fragment_custom_screen;
    }

    @Override
    protected void onLayoutCreated(@NonNull View layout, @Nullable Bundle savedInstanceState) {
        textView = layout.findViewById(R.id.textView);
        editText = layout.findViewById(R.id.edittext);
        button = layout.findViewById(R.id.toastButton);
        articleContainer = layout.findViewById(R.id.article_container);
        surveyContainer = layout.findViewById(R.id.survey_Container);
    }

    @Override
    protected void updateContent(@NonNull ChoicelyScreenActivity act, @NonNull Bundle data) {
        setArticle();
        setSurvey();
    }

    private void setSurvey() {
        Bundle bundle = new Bundle();
        bundle.putString(ChoicelyIntentKeys.KEY, "SURVEY_KEY");
        ChoicelySurveyFragment surveyFragment = new ChoicelySurveyFragment();
        surveyFragment.setArguments(bundle);

        replaceFragment(surveyContainer.getId(), surveyFragment, false);
    }

    private void setArticle() {
        Bundle bundle = new Bundle();
        bundle.putString(ChoicelyIntentKeys.ARTICLE_KEY, "ARTICLE_KEY");
        ChoicelyArticleFragment articleFragment = new ChoicelyArticleFragment();
        articleFragment.setArguments(bundle);

        replaceFragment(articleContainer.getId(), articleFragment, false);
    }
}
```

**Kotlin:**

```kotlin
class MyCustomScreen : ChoicelyContentFragment() {
    private var textView: ChoicelyTextView? = null
    private var editText: EditText? = null
    private var button: Button? = null
    private var articleContainer: FrameLayout? = null
    private var surveyContainer: FrameLayout? = null

    override fun getLayout(): Int = R.layout.fragment_custom_screen

    override fun onLayoutCreated(layout: View, savedInstanceState: Bundle?) {
        textView = layout.findViewById(R.id.textView)
        editText = layout.findViewById(R.id.edittext)
        button = layout.findViewById(R.id.toastButton)
        articleContainer = layout.findViewById(R.id.article_container)
        surveyContainer = layout.findViewById(R.id.survey_Container)
    }

    override fun updateContent(act: ChoicelyScreenActivity, data: Bundle) {
        setArticle()
        setSurvey()
    }

    private fun setSurvey() {
        val bundle = Bundle().apply {
            putString(ChoicelyIntentKeys.KEY, "SURVEY_KEY")
        }
        val surveyFragment = ChoicelySurveyFragment().apply {
            arguments = bundle
        }
        replaceFragment(surveyContainer?.id ?: 0, surveyFragment, false)
    }

    private fun setArticle() {
        val bundle = Bundle().apply {
            putString(ChoicelyIntentKeys.ARTICLE_KEY, "ARTICLE_KEY")
        }
        val articleFragment = ChoicelyArticleFragment().apply {
            arguments = bundle
        }
        replaceFragment(articleContainer?.id ?: 0, articleFragment, false)
    }
}
```

*The rest of the setup including content factory and registering the factory in the application class can follow the same approach in Java and Kotlin as outlined above.*
