[![Build Status](https://travis-ci.org/adsf117/Clean_Post_AAC.svg?branch=develop)](https://travis-ci.org/adsf117/Clean_Post_AAC.svg?branch=develop)
[![codecov](https://codecov.io/gh/adsf117/Clean_Post_AAC/branch/develop/graph/badge.svg)](https://codecov.io/gh/adsf117/Clean_Post_AAC)
[![CodeFactor](https://www.codefactor.io/repository/github/adsf117/clean_post_aac/badge)](https://www.codefactor.io/repository/github/adsf117/clean_post_aac) 

#  Postapp Android Architecture Components
Follow :

[MVVM Components](https://devexperto.com/mvvm-vs-mvp/) 

[Continuous Integration](https://www.martinfowler.com/articles/continuousIntegration.html) [Using Tavis](https://travis-ci.org/)

## How it looks
![alt text](https://github.com/adsf117/Clean_Post_AAC/blob/develop/info/how_it_looks.gif)

## Getting Started
This project uses the Gradle build system. To build this project, use the gradlew build command or use "Import Project" in Android Studio.

There are one Gradle pluggin to run  the test and get the coverage report using jacoco
`./gradlew jacocoTestReport`

the data commes from Create an app that lists all messages and their details from [Jsonplaceholder](https://jsonplaceholder.typicode.com)
end points :
* [GET post](https://jsonplaceholder.typicode.com/posts) 
* [GET User](https://jsonplaceholder.typicode.com/users) 
* [GET comments?postId={id}](https://jsonplaceholder.typicode.com/comments?postId=1) 

When the database is created by first time triger worker `SycDataWorker`  in order to dowload the post and User data and save it 

There are three main layer: 
data: in this module has all details Service and Data base 
model: has the object 
presentation This module has all android framework 

each modules has his own object and interact using mappers.
The viewModel are injecting by a own factory but is easy replace the implemantation by Dagger2 or koin

![alt text](https://github.com/adsf117/Clean_Post_AAC/blob/develop/info/Clean%20Post%20AAC.png)


--------------

## TODO 
* DataBase there 3 tables without relationship (TODO improve that)
 * create the viewModesl test 
 * create the Storage test

--------------

 
## Libraries Used :

* [Room](https://developer.android.com/jetpack/androidx/releases/room)
* [Workout manager](https://developer.android.com/topic/libraries/architecture/workmanager/advanced/coroutineworker)
* [Navigation Component](https://codelabs.developers.google.com/codelabs/android-navigation/index.html?index=..%2F..index#0)
* [ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2) 
* [Data Binding](https://codelabs.developers.google.com/codelabs/android-databinding/index.html?index=..%2F..index#5) 
* [Retrofit2](https://square.github.io/retrofit/)
* [Coroutines](https://developer.android.com/kotlin/coroutines)
--------------

## References:

Google Codelabs:
* [Kotlin Bootcamp Course](https://codelabs.developers.google.com/kotlin-bootcamp/)
* [Navigation Codelab](https://codelabs.developers.google.com/codelabs/android-navigation/index.html?index=..%2F..index#6)
* [Android Room with a View - Kotlin](https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/index.html?index=..%2F..index#0)
* [Using Kotlin Coroutines in your Android App](https://codelabs.developers.google.com/codelabs/kotlin-coroutines/index.html?index=..%2F..index#6)
* [Background Work with WorkManager - Kotlin](https://codelabs.developers.google.com/codelabs/android-workmanager-kt/index.html?index=..%2F..index#0)


Raywenderlich
* [Jetpack navigation controlle](https://www.raywenderlich.com/5365-jetpack-navigation-controller)
* [Android Architecture Components: Getting Started](https://www.raywenderlich.com/164-android-architecture-components-getting-started)
* [android architecture components livedata](https://www.raywenderlich.com/4980-android-architecture-components-livedata)
* [android architecture components viewmodel](https://www.raywenderlich.com/5046-android-architecture-components-viewmodel)
* [Jetpack workmanager getting started](https://www.raywenderlich.com/9161-jetpack-workmanager-getting-started)

Others:
* [How to configure JaCoCo for Kotlin & Java project](http://vgaidarji.me/blog/2017/12/20/how-to-configure-jacoco-for-kotlin-and-java-project/)
* [Mocking Coroutines](https://proandroiddev.com/mocking-coroutines-7024073a8c09)










