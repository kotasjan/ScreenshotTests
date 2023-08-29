@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.paparazzi) apply false
}

allprojects {
    tasks.withType<Test> {
        // exclude tests which match given path -PexcludeTests='**/some_path/**'
        if (project.hasProperty("excludeTests")) {
            exclude(project.property("excludeTests") as String)
        }
    }
}
