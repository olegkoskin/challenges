allprojects {
    apply(plugin = "java")
    apply(plugin = "groovy")

    group = "challenges"
    version = "0.0.1-SNAPSHOT"

    repositories {
        jcenter()
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<JavaExec> {
        enableAssertions = true
    }

    dependencies {
        add("testImplementation", "org.codehaus.groovy:groovy-all:2.5.7")
        add("testImplementation", "org.spockframework:spock-core:1.3-groovy-2.5")
    }
}
