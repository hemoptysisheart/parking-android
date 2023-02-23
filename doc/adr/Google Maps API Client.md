# Google Maps API Client

## 결정사항

구글이 제공하는 라이브러리를 쓰지 않고 자체 구현한다.

## 이유

1. `enum`을 사용하지 않고 `String` 기반으로 되어있다.
2. API 문서엔 있지만 라이브러리에서 구현하지 않은 속성이 있다.
3. 로그 출력을 위한 `toString()` 고려가 없다.
4. Kotlin co-routine을 지원하지 않는다.

## 참고

- [Google Maps 웹 서비스용 클라이언트 라이브러리](https://developers.google.com/maps/documentation/directions/client-library)