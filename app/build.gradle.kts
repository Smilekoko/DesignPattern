//apply plugin : 'com.android.application'

//android {
//    compileSdkVersion 28
//    buildToolsVersion "28.0.3"
//    namespace "com.example.jingbin.designpattern"
//    defaultConfig {
//        applicationId "com.example.jingbin.designpattern"
//        minSdkVersion 19
//        targetSdkVersion 29
//        versionCode 5
//        versionName "3.1"
//        testInstrumentationRunner 'androidx.test.runner.AndroidJUnitRunner'
//    }
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile ('proguard-android.txt'), 'proguard-rules.pro'
//        }
//    }
//
//    // databinding
//    dataBinding {
//        enabled = true
//    }
//
//    compileOptions {
//        sourceCompatibility JavaVersion . VERSION_1_8
//                targetCompatibility JavaVersion . VERSION_1_8
//    }
//
//    // 其他 designpattern
//    signingConfigs {
//        release {
//            storeFile file ("./designpattern")
//            storePassword "designpattern"
//            keyAlias "designpattern"
//            keyPassword "designpattern"
//        }
//        debug {
//            storeFile file ("./designpattern")
//            storePassword "designpattern"
//            keyAlias "designpattern"
//            keyPassword "designpattern"
//        }
//    }
//}

//dependencies {
//    androidTestImplementation('androidx.test.espresso:espresso-core:3.1.0', {
//        exclude group : 'com.android.support', module: 'support-annotations'
//    })
//    implementation 'androidx.appcompat:appcompat:1.0.0'
//    testImplementation 'junit:junit:4.13.2'
//    implementation fileTree (include: ['*.jar'], dir: 'libs')
//
//    implementation "com.github.youlookwhat:ByRecyclerView:1.3.2"
//    implementation 'androidx.recyclerview:recyclerview:1.2.1'
//}

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.jingbin.designpattern"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.jingbin.designpattern"
        minSdk = 24
        //noinspection EditedTargetSdkVersion
        targetSdk = 35
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("com.github.youlookwhat:ByRecyclerView:1.3.2")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
//    implementation fileTree (include: ['*.jar'], dir: 'libs')
}

