plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply false
    id("app.cash.paparazzi") version "1.3.1" apply false
}

allprojects {
    tasks.withType<Test> {
        // exclude tests which match given path -PexcludeTests='**/some_path/**'
        if (project.hasProperty("excludeTests")) {
            exclude(project.property("excludeTests") as String)
        }
    }
}
