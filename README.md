# ClientServiceManager

This library helps you to make HTTP requests.
It uses Retrofit 2 with OkHttp3 as client to establish the connection and RxAndroid/Java to handle asynchronous operations.
Data will emitt with LiveData by Callbacks.

Responses from servers will be hanlded by BaseResponse object.
That object contains:
- Body > Body of the response;
- Code > Code of the response;
- ErrorBody > In case of error, it will be saved in ErrorBody.

This library will help you to integrate, more easily, a MVVM architectural pattern by giving you:
- BaseRepository > Most commons Repository functions. 
- BaseViewModel > Most commons ViewModel functions.


All the library has been writte in Kotlin, I like it more.


# How to 

To get a Git project into your build:

Gradle ->

  Step 1. Add the repository to your build file
  
  Add it in your root build.gradle at the end of repositories:

    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
    
  Step 2. Add the dependency
  
    dependencies {
              implementation 'com.github.giovanniandreuzza:clientservicemanager:0.1.0'
      }
     
 
      
   
