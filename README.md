# kotlintest-spring
A module that allows
[kotlintest](https://github.com/kotlintest/kotlintest) to work together with
[Spring Framework](https://spring.io/)


[![Release](https://jitpack.io/v/ddmytrenko/kotlintest-spring.svg)](https://jitpack.io/#ddmytrenko/kotlintest-spring)


## How it works
Basically, we wrote our own runner that first starts the Spring Runner and then executes the Kotlin Test runner.

Sadly, the Spring Runner delegates to a JUnit Runner which throws an Exception if there are no JUnit tests in the class.
That's why we added our own test that does nothing (currently called `dummyTest()`).

In addition to that we enabled autowiring for the kotlin test spec classes by overwriting the beforeAll method and using a
static class to access the AutowireCapableBeanFactory.

## What do I need to do?
Instead of extending the normal `*Spec` classes you need to extend the `Spring*Spec` classes.

You also need to add the `@EnableKotlinTest` annotation to your test context in order for the static utility class to be
picked up.


## How to add it to the project

### Gradle
Add JitPack Maven repository
```gradle
    allprojects {
        repositories {
            maven { url 'https://jitpack.io' }
        }
    }
```

Add dependency
```gradle
    dependencies {
        testCompile "com.github.ddmytrenko:kotlintest-spring:$VERSION"
    }
```


## Versioning
| Version   | Kotlin | kotlintest | Spring Framework | Changelog                            |
|-----------|--------|------------|------------------|--------------------------------------|
| v7.5.38.4 | 1.2.21 | 2.0.7      | 4.3.10.RELEASE   | Add Spring spec interception feature |
| v7.5.38.1 | 1.2.21 | 2.0.7      | 4.3.10.RELEASE   | Fork and migrate to Gradle           |
