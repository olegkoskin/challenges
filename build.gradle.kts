allprojects {
    apply(plugin = "java")
    group = "challenges"
    version = "0.0.1-SNAPSHOT"

    repositories {
        jcenter()
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_13
        targetCompatibility = JavaVersion.VERSION_13
    }

    tasks.withType<JavaExec> {
        enableAssertions = true
    }
}

val test by tasks.getting(Test::class) {
    // Use junit platform for unit tests
    useJUnitPlatform()
}
