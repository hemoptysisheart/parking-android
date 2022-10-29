# Google Map

1. GCP 콘솔 설정하기.
    1. 개발자 계정 지역 설정. 지금 거주지가 일본이고 일본 신용카드로 결제 설정을 했으니 일본으로 설정.
       ![지역 설정](asset/gcp/gcp%20account.png)
2. 프로젝트 생성.
    1. [리소스 관리](https://console.cloud.google.com/cloud-resource-manager)
       ![리소스 관리](asset/gcp/gcp%20resource%20manager.png)
    2. `프로젝트 만들기` -> 프로젝트 이름 지정(`parking`) -> `만들기`
       ![프로젝트 만들기](asset/gcp/create%20project.png)
       ![프로젝트](asset/gcp/create%20project%20result.png)
       ![새 프로젝트 상세](asset/gcp/parking%20project.png)
3. 맵 키 발급받기
    1. `Maps SDK for Android` -> `사용`
       ![Maps SDK for Android](asset/gcp/Maps%20SDK%20for%20Android.png)
       ![Maps SDK for Android 사용](asset/gcp/Maps%20SDK%20for%20Android%20enabled.png)
    2. `사용자 인증 정보` -> `키 표시`
       ![설정](asset/gcp/maps%20api%20credential.png)
       ![키](asset/gcp/maps%20api%20key.png)
4. 애플리케이션 설정.
    1. 의존성 추가
        - 플러그인 : `com.google.android.libraries.mapsplatform.secrets-gradle-plugin`
        - 라이브러리 :
    2. 권한 추가 : [`AndroidManifest.xml`](../app/src/main/AndroidManifest.xml)
       ```xml
       <?xml version="1.0" encoding="utf-8"?>
       <manifest xmlns:android="http://schemas.android.com/apk/res/android">
       
           <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
           <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
           <uses-permission android:name="android.permission.INTERNET" />
       
           <application>
               <meta-data
                   android:name="com.google.android.geo.API_KEY"
                   android:value="${GOOGLE_MAPS_API_KEY}" />
               <!-- ... -->
           </application>
       </manifest>
       ```
        - 권한 추가 : `android.permission.ACCESS_FINE_LOCATION`, `android.permission.ACCESS_NETWORK_STATE`
          , `android.permission.INTERNET`
        - 키 추가 : `<meta-data android:name="com.google.android.geo.API_KEY" android:value="${GOOGLE_MAPS_API_KEY}" />`
    3. 키 설정 추가 : [`sample-local.properties`](../sample-local.properties) 파일을 복사해서 `local.properties` 파일을 만들고, 설정을 변경.
       ![로컬 키 설정](asset/gcp/maps%20local%20config.png)
5. 지도 표시
    1. 의존성 추가 : `com.google.maps.android:maps-compose`, `com.google.android.gms:play-services-maps`
    2. UI 추가 : [`MapLayout()`](../app/src/main/java/com/github/hemoptysisheart/parking/app/activity/MapActivity.kt)

## 참고

- [Android용 Maps SDK 빠른 시작](https://developers.google.com/maps/documentation/android-sdk/start)
- [지도 Compose 라이브러리](https://developers.google.com/maps/documentation/android-sdk/maps-compose)
