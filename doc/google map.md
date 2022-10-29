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

## 참고

- [Android용 Maps SDK 빠른 시작](https://developers.google.com/maps/documentation/android-sdk/start)