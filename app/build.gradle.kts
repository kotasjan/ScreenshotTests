plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "cz.jankotas.screenshottests"
    compileSdk = 33

    defaultConfig {
        applicationId = "cz.jankotas.screenshottests"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
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

    ksp {
        arg("skipPrivatePreviews", "true")
    }
}

dependencies {
    implementation(project(":coreui"))
    implementation(project(":feature:presentation"))

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.activity:activity-compose:1.7.2")

    implementation("androidx.compose.compiler:compiler:1.5.1")
    implementation(platform("androidx.compose:compose-bom:2023.06.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")

    implementation("com.airbnb.android:showkase:1.0.0-beta18")
    ksp("com.airbnb.android:showkase-processor:1.0.0-beta18")

    testImplementation("junit:junit:4.13.2")
}
