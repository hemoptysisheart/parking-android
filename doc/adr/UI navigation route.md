# UI 네비게이션 루트 만들기

## 결정사항

Jetpack Compose UI 네비게이션에 사용할 루트(route)
는 [`Destination`](../../app/src/main/java/com/github/hemoptysisheart/parking/app/navigation/MainNavGraph.kt)에서
정의한 `String.route(vararg arguments: Pair<String, Any?>)`를 사용한다.

## 이유

1. 가독성 개선 : 기존의 `String.replace`를 사용하면 교체대상 문자열(값 플레이스홀더) 생성과 값 교체 코드가 반복되어 가독성이 떨어진다.
2. 네비게이션(`<action>`에 해당) 클래스 보류 : 각각의 네비게이션 정보를 래핑하는 메서드, 클래스 정의는 보류한다. 네비게이션 갯수가 늘어나면 추가한다.

## 참고

- [Kotlin DSL 및 Navigation Compose의 유형 안전성](https://developer.android.com/guide/navigation/navigation-type-safety)
