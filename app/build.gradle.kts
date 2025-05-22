plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
}

android {
    namespace = "com.agus_221111031.skillup"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.agus_221111031.skillup"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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
//    Nav Drawer
    implementation ("com.google.android.material:material:1.10.0")
    implementation ("androidx.cardview:cardview:1.0.0")
    implementation ("com.google.android.material:material:1.10.0")
    implementation ("com.google.android.material:material:1.11.0")

    // Untuk DrawerLayout
    implementation ("androidx.drawerlayout:drawerlayout:1.2.0")
    // Untuk BottomNavigationView dan NavigationView
    implementation ("com.google.android.material:material:1.9.0")
    // Untuk AppCompatActivity, Toolbar, dan ActionBarDrawerToggle
    implementation ("androidx.appcompat:appcompat:1.6.1")
    // Untuk RecyclerView (digunakan di ExploreFragment)
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    // Untuk Fragment (ExploreFragment, LearnFragment, SearchFragment)
    implementation ("androidx.fragment:fragment-ktx:1.5.7")
    // Untuk Core KTX (opsional, membantu penulisan kode Kotlin)
    implementation ("androidx.core:core-ktx:1.10.1")
    // Untuk Activity KTX (opsional, membantu penulisan kode Kotlin)
    implementation ("androidx.activity:activity-ktx:1.7.2")

}