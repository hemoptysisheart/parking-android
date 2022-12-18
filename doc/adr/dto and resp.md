# `DTO`와 `Resp`

## 결정사항

API의 응답을 받아 메모리로 올리는 `Resp`와 앱 로직에 전달하기 위한 `DTO`를 분리한다.

1. `Resp`와 `DTO`를 분리.
2. `Resp`의 속성은 `var`를 사용한다. `DTO`는 `val`을 사용할 수 있다.
3. `Resp`의 속성을 `?`으로 선언하고 기본값 `null`을 할당 한다.
4. `Resp`의 속성은 기본 자료형(`Int?`, `String?` 등)을 사용한다.

```kotlin
/**
 * 예제)
 */
data class Resp(
    var prop1: String? = null,
    var prop2: Int? = null
)
```

## 이유

API 특히 제3자 API인 경우, API의 정합성이나 안정성을 보장할 수 없다. 따라서 속성의 누락, 파싱 할 수 없는 값을 반환할 가능성이 존재한다. 따라서 통신내용을 메모리로 로딩(인스턴스로 변환)
하기위해 `Resp`를 사용하고, 검증을 통과한 경우 `DTO`로 앱 로직으로 전달한다.

## 참고

- [`AddressComponentResp`](../../core/src/main/java/com/github/hemoptysisheart/parking/core/client/google/response/AddressComponentResp.kt)
  과 [`AddressComponentDto`](../../core/src/main/java/com/github/hemoptysisheart/parking/core/client/google/dto/AddressComponentDto.kt)
  비교.