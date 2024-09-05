plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.kapt")
    alias(libs.plugins.kotlinxSerialization)
    id("com.google.gms.google-services") version "4.4.2"
    id("com.google.devtools.ksp")
    id("com.google.firebase.crashlytics") version "3.0.2"
}

android {
    namespace = "com.project.mytemplate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.project.mytemplate"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    applicationVariants.all {
        addJavaSourceFoldersToModel(
            File(layout.buildDirectory.get().asFile, "generated/ksp/$name/kotlin")
        )
    }
}

val ktor_version: String by project

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.auth.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Jetpack Compose
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material3:material3:1.0.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    // Koin
    val koinVersion = "3.5.6"
    val koinAnnotationsVersion = "1.3.1"
    implementation(platform("io.insert-koin:koin-bom:$koinVersion"))
    implementation("io.insert-koin:koin-core")
    implementation("io.insert-koin:koin-androidx-compose")
    implementation("io.insert-koin:koin-annotations:$koinAnnotationsVersion")
    ksp("io.insert-koin:koin-ksp-compiler:$koinAnnotationsVersion")

    implementation("io.insert-koin:koin-android:3.4.0")
    implementation("io.insert-koin:koin-android")


    // Corrutinas
    val kotlinCoroutinesVersion = "1.8.0"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutinesVersion")

    // Ktor
    implementation (libs.ktor.client.core.v2312)
    implementation (libs.ktor.client.okhttp.v2312)
    implementation (libs.ktor.client.logging)
    testImplementation (libs.ktor.client.mock)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.server.content.negotiation)
    implementation (libs.ktor.ktor.serialization.kotlinx.json.v239)

    // Navegacion
    implementation("androidx.compose.material:material:1.6.8")
    implementation("androidx.navigation:navigation-compose:2.7.7")

    //Room
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    //Icon Material
    implementation("androidx.compose.material:material-icons-extended:1.5.0")

    // DataStore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")
    implementation ("androidx.datastore:datastore-preferences-core:1.0.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.2.0"))
        //authentification
    implementation("com.google.firebase:firebase-analytics")
        //crashlytics
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation ("com.google.firebase:firebase-analytics-ktx")

}