pluginManagement {
    repositories {
//        maven("https://maven.aliyun.com/nexus/content/groups/public/")
//        maven("https://s01.oss.sonatype.org/content/groups/public")
//        maven { url 'https://maven.aliyun.com/nexus/content/groups/public/' }
//        maven { url "https://s01.oss.sonatype.org/content/groups/public" }
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://www.jitpack.io")
//        maven { url 'https://www.jitpack.io' }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
//        maven("https://maven.aliyun.com/nexus/content/groups/public/")
//        maven("https://s01.oss.sonatype.org/content/groups/public")
        google()
        mavenCentral()
        maven("https://www.jitpack.io")
//        maven { url 'https://www.jitpack.io' }
    }
}

rootProject.name = "DesignPattern"
include(":app")
