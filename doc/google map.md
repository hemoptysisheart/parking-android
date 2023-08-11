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
    1. [`Maps SDK for Android`](https://console.cloud.google.com/marketplace/product/google/maps-android-backend.googleapis.com)
       -> `사용`
       ![Maps SDK for Android](asset/gcp/Maps%20SDK%20for%20Android.png)
       ![Maps SDK for Android 사용](asset/gcp/Maps%20SDK%20for%20Android%20enabled.png)
    2. `사용자 인증 정보` -> `키 표시`
       ![설정](asset/gcp/maps%20api%20credential.png)
       ![키](asset/gcp/maps%20api%20key.png)
4. Places API 설정.
    1. [Places API](https://console.cloud.google.com/apis/library/places-backend.googleapis.com) -> `사용` 클릭.
       ![Places API](asset/gcp/gcp%20places%20api.png)
    2. [API list](https://console.cloud.google.com/google/maps-apis/api-list)에서 확인.
       ![API list](asset/gcp/project%20api%20list.png)
    3. 사용자 인증 정보 -> `Places API` 선택 -> `사용자 인증 정보 만들기` 선택 -> `API 키` 선택.
       ![Places API 사용자 인증 정보](asset/gcp/places%20api%20credential%201.png)
       ![Places API 사용자 인증 정보 - 키 종류](asset/gcp/places%20api%20credential%202.png)
       ![Places API 사용자 인증 정보 - 결과](asset/gcp/places%20api%20credential%203.png)
5. Directions API 설정.
    1. [Directions API](https://console.cloud.google.com/apis/library/directions-backend.googleapis.com) -> `사용` 클릭.
       ![Directions API](asset/gcp/gcp%20directions%20api.png)
    2. [API list](https://console.cloud.google.com/google/maps-apis/api-list)에서 확인.
       ![Directions API 활성화](asset/gcp/api%20list%20-%20directions%20api%20enabled.png)
    3. API 키 활성화.
       ![API 키 연결 - 1](asset/gcp/link%20key%20with%20directions%20api%20-%201.png)
       ![API 키 연결 - 2](asset/gcp/link%20key%20with%20directions%20api%20-%202.png)
       ![API 키 연결 - 3](asset/gcp/link%20key%20with%20directions%20api%20-%203.png)
       ![API 키 연결 - 4](asset/gcp/link%20key%20with%20directions%20api%20-%204.png)
6. 애플리케이션 설정.
    1. 의존성 추가
        - 플러그인 : `com.google.android.libraries.mapsplatform.secrets-gradle-plugin`
        - 라이브러리 :
    2. 권한 추가 : [`AndroidManifest.xml`](../app/src/main/AndroidManifest.xml)
       ```xml
       <?xml version="1.0" encoding="utf-8"?>
       <manifest xmlns:android="http://schemas.android.com/apk/res/android">
       
           <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
           <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
           <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
           <uses-permission android:name="android.permission.INTERNET" />
       
           <application>
               <meta-data
                   android:name="com.google.android.geo.API_KEY"
                   android:value="${GOOGLE_MAPS_PLATFORM_API_KEY}" />
           </application>
       </manifest>
       ```
        - 권한 추가 : `android.permission.ACCESS_FINE_LOCATION`, `android.permission.ACCESS_NETWORK_STATE`
          , `android.permission.INTERNET`
        - 키 추가 : `<meta-data android:name="com.google.android.geo.API_KEY" android:value="${GOOGLE_MAPS_API_KEY}" />`
   3. 키 설정 추가 : [`sample-local.properties`](../sample-local.properties) 파일을 복사해서 `local.properties` 파일을 만들고, 설정을 변경.
      ![로컬 키 설정](asset/gcp/maps%20local%20config.png)
7. 지도 표시
    1. 의존성 추가 : `com.google.maps.android:maps-compose`, `com.google.android.gms:play-services-maps`
    2. UI 추가 : [`MapLayout()`](../app/src/main/java/com/github/hemoptysisheart/parking/app/activity/MapActivity.kt)

## Trouble Shooting

### `SecurityException`

만약 `Caused by: java.lang.SecurityException: GoogleCertificatesRslt: not allowed` 에러로 지도가 표시되지 않는다면 다음 조치를 취한다.

1. Android Studio 캐시 삭제.
2. API 키 재발급.

```
Unable to update local snapshot for com.google.android.libraries.consentverifier#com.github.hemoptysisheart.parking, may result in stale flags.
java.util.concurrent.ExecutionException: java.lang.SecurityException: GoogleCertificatesRslt: not allowed: pkg=com.github.hemoptysisheart.parking, sha256=[8489853f8dda1efd4b138a3254330953d06fb845a6aeefdd542ee8af0d4adaeb], atk=false, ver=233013044.true (go/gsrlt)
	at m.ank.s(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):21)
	at m.ank.get(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):5)
	at m.app.a(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):2)
	at m.aou.h(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):7)
	at m.zm.c(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):1)
	at m.zo.run(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):5)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:463)
	at java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:307)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1137)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:637)
	at java.lang.Thread.run(Thread.java:1012)
Caused by: java.lang.SecurityException: GoogleCertificatesRslt: not allowed: pkg=com.github.hemoptysisheart.parking, sha256=[8489853f8dda1efd4b138a3254330953d06fb845a6aeefdd542ee8af0d4adaeb], atk=false, ver=233013044.true (go/gsrlt)
	at android.os.Parcel.createExceptionOrNull(Parcel.java:3011)
	at android.os.Parcel.createException(Parcel.java:2995)
	at android.os.Parcel.readException(Parcel.java:2978)
	at android.os.Parcel.readException(Parcel.java:2920)
	at m.fh.c(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):11)
	at m.sb.a(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):39)
	at m.jo.e(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):11)
	at m.km.t(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):10)
	at m.km.u(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):22)
	at m.km.e(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):16)
	at m.kq.handleMessage(:com.google.android.gms.dynamite_mapsdynamite@233013044@23.30.13 (190400-0):774)
	at android.os.Handler.dispatchMessage(Handler.java:102)
	at android.os.Looper.loopOnce(Looper.java:201)
	at android.os.Looper.loop(Looper.java:288)
	at android.os.HandlerThread.run(HandlerThread.java:67)
```

## 참고

- [Android용 Maps SDK 빠른 시작](https://developers.google.com/maps/documentation/android-sdk/start)
- [지도 Compose 라이브러리](https://developers.google.com/maps/documentation/android-sdk/maps-compose)
