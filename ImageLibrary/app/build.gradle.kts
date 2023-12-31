plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    id ("kotlin-android")
}

android {
    namespace = "com.example.imagelibrary"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.imagelibrary"
        minSdk = 30
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{

        viewBinding=true

    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // by viewModels를 사용하기 위한 의존성
    implementation ("androidx.activity:activity-ktx:1.7.2")
    implementation ("androidx.fragment:fragment-ktx:1.6.1")
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    // Converter ( JSON 타입 결과를 객체로 매핑 )
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    // okhttp3
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // SharedPreferences
    implementation ("com.google.code.gson:gson:2.8.5")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.9.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.9.0")

}