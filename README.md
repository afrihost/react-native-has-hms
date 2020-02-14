# react-native-has-hms

Huawei Mobile Services utility to check if a device is running the HMS service.

## Getting started

Only supported for Android.

---

`npm install react-native-has-hms --save`  
or  
`yarn add react-native-has-hms`

---

### Link up the library

`react-native link react-native-has-hms`

### Huawei Developer Console

1. You will need to sign up with a Huawei Developer Account. That can be done here [https://developer.huawei.com/consumer/en/](https://developer.huawei.com/consumer/en/)
2. This guide can also help with the setup of your app. [The guide here](https://developer.huawei.com/consumer/en/codelab/HMSPreparation/index.html#0).
3. You will need to get a file with the name `agconnect-services.json`
4. Add the `agconnect-services.json` file to your `android` directory.

### Additional android setup

1. In `android/build.gradle`
   1. Add minimum SDK version to at least 17
   2. Add the maven repo for Huawei
   3. Add dependencies for `com.huawei.agconnect` and `com.google.gms`

```javascript
//...
buildscript {
    ext {
        buildToolsVersion = "28.0.3"
        minSdkVersion = 17 //<----- Change this to at least version 17, this is required by Huawei Mobile Services
        compileSdkVersion = 28
        targetSdkVersion = 28
    }
    repositories {
        google()
        jcenter()
        maven { url 'https://developer.huawei.com/repo/' } //<----- Add Huawei Maven repository
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.5.3'
        classpath 'com.huawei.agconnect:agcp:1.2.0.300'  // <------ Add Huawei Services Core classpath
        classpath 'com.google.gms:google-services:4.3.3' // <------ Add Google Services Core classpath
    }
}
//...
```

2. In `android/app/build.gradle`
   1. At the bottom of the file add `apply plugin: 'com.huawei.agconnect'`

```javascript
//...
apply plugin: 'com.huawei.agconnect'
// ...
```

## Usage

```javascript
import HasHms from "react-native-has-hms";

...

hasGoogleMobileServices = async () => {
    const hasGMS = await HasHms.isGMSAvailable()
    console.log("Is your device running Google Mobile Services?", hasGMS)
    return hasGMS
}

hasHuaweiMobileServices = async () => {
    const hasHMS = await HasHms.isHMSAvailable()
    console.log("Is your device running Huawei Mobile Services?", hasHMS)
    return hasHMS
}

...
```
