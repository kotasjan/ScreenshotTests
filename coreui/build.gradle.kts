plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("app.cash.paparazzi")
}

android {
    namespace = "cz.jankotas.screenshottests.coreui"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    ksp {
        arg("skipPrivatePreviews", "true")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")

    implementation("androidx.compose.compiler:compiler:1.5.1")
    implementation(platform("androidx.compose:compose-bom:2023.06.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")

    debugImplementation("androidx.compose.ui:ui-tooling")

    implementation("com.airbnb.android:showkase:1.0.0-beta18")
    ksp("com.airbnb.android:showkase-processor:1.0.0-beta18")

    testImplementation(project(":coretest"))
    testImplementation("junit:junit:4.13.2")
}
