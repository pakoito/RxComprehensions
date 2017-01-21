# RxComprehensions

RxComprehensions is a library to reduce boilerplate and simplify your `Observable` chains.

## Rationale

As your code starts getting more and more functional, you find that you have to chain multiple `Observable` by means of `flatMap()`, `concatMap()`, or `switchMap()`. This causes indentation levels to go quite high, and would often require that you split the code in several methods just to keep it readable.

```java
Observable<String> getUserFriends =
    profileClicks()
            .flatMap { position ->
                getUserFromProfile(position)
                        .flatMap { user ->
                            requestFriendListForUser(position, user.id)
                                    .flatMap { friends ->
                                        storeUserAndFriends(user, friends)
                                                .flatMap { result ->
                                                    toUserDisplayString(position, user, friends, result)
                                                }
                                    }
                        }
            }
```

**Comprehensions** are a language feature that allow you to define such a chain in a way where every observable is a function at topmost indentation, yet still contains all the parameters received in the previous functions.

## Usage

### Map comprehensions

RxComprehensions contains static methods `doFM()` for `flatMap()`, `doCM()` for `concatMap()`, `doSM()` for `switchMap()`. Each takes from 1 to 9 `FunctionN` each with an increasing number of parameters, and returns an `Observable` of the type of the return of the last function.

```java
Observable<String> getUserFriends =
    // chained with flatMap()
    RxComprehensions.doFM(
        () -> profileClicks(),
        position -> getUserFromProfile(position),
        position, user -> requestFriendListForUser(position, user.id),
        position, user, friends -> storeUserAndFriends(user, friends),
        position, user, friends, result -> toUserDisplayString(position, user, friends, result)
    );
```

### Compose comprehensions

RxComprehensions contains static methods `doCo()` for `compose()`. Each takes from 1 to 9 `Transformer<T, U>` (RxJava 1.X) or `ObservableTransformer<T, U>` (RxJava 2.X), and returns an `Observable` of the type of the return of the last one.

```java
Observable<List<Siblings>> getRelatives =
    // chained with compose()
    RxComprehensions.doCo(
        () -> requestRelative("12345"),
        validate(),
        assureThreads(Schedulers.io(), AndroidSchedulers.main()),
        respectLifecycle(activity),
        toUILayerModel(),
        groupSiblings()
    );

Observable<RelativeDto> requestRelative(String id) { /* ... */ }

ObservableTransformer<RelativeDto, RelativeDto> validate() { /* ... */ }

ObservableTransformer<RelativeDto, RelativeDto> assureThreads(Scheduler in, Scheduler out) { /* ... */ }

ObservableTransformer<RelativeDto, RelativeDto> respectLifecycle(Activity activity) { /* ... */ }

ObservableTransformer<RelativeDto, Relative> toUILayerModel() { /* ... */ }

ObservableTransformer<Relative, List<Siblings>> groupSiblings() { /* ... */ }
```

## Distribution

### RxJava 1.X

Add as a dependency to your `build.gradle`
```groovy
repositories {
    ...
    maven { url "https://jitpack.io" }
    ...
}
    
dependencies {
    ...
    compile 'com.github.pakoito.RxComprehensions:rxcomprehensions:1.2.0'
    ...
}
```
or to your `pom.xml`

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.pakoito.RxComprehensions</groupId>
    <artifactId>rxcomprehensions</artifactId>
    <version>1.2.0</version>
</dependency>
```

### RxJava 2.X

Add as a dependency to your `build.gradle`
```groovy
repositories {
    ...
    maven { url "https://jitpack.io" }
    ...
}
    
dependencies {
    ...
    compile 'com.github.pakoito.RxComprehensions:rxcomprehensions2:1.2.0'
    ...
}
```
or to your `pom.xml`

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.pakoito.RxComprehensions</groupId>
    <artifactId>rxcomprehensions2</artifactId>
    <version>1.2.0</version>
</dependency>
```

## License

Copyright (c) pakoito 2016

The Apache Software License, Version 2.0

See LICENSE.md
