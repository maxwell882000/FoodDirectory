
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "app.food_directory.data"
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
    arg("room.incremental", "true")
}

dependencies {
    implementation(projects.base)
    api(projects.model)

    api(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.paging.runtime)

    api(libs.androidx.room.common)
    api(libs.androidx.paging.common)
    api(libs.timber)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.interceptor)
    testImplementation(libs.okhttp.mockwebserver)

    // Retrofit
    api(libs.retrofit)
    api(libs.moshi)
    api(libs.retrofit.converter.moshi)

    // Coroutines
    api(libs.coroutines.core)
//
    implementation(libs.hilt.library)
    kapt(libs.hilt.compiler)

    // Data store
    api(libs.datastore)
}
