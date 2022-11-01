# Version Control

1. [git](https://git-scm.com) 사용.
2. 리니어 히스토리를 사용한다.
3. [gitmoji](https://gitmoji.dev) 사용.

## 규칙

1. 커밋 메시지의 첫 줄에 커밋의 내용을 요약하는 메시지를 작성한다.
2. 커밋 메시지는 `gitmoji`와 ` `(공백)으로 시작한다.
3. 커밋 네트워크의 분기는 최대 2개만 발생한다.
4. 커밋 네트워크가 분기와 머지 커밋 사이의 커밋은 한 쪽 경로에서만 생긴다.

```
|/
*   20854ad - 🔀 Merge pull request #4 from hemoptysisheart/issue/update_project_docs (6일 전) <H2>
|\
| * a2f0ed3 - 📝 리니어 히스토리 샘플 갱신. (6일 전) <H2>
|/
*   c2627fd - 🔀 Merge pull request #3 from hemoptysisheart/issue/project_docs (6일 전) <H2>
|\
| * bb416b4 - 📝 리니어 히스토리 샘플 추가. (3주 전) <H2>
| *   f89c30b - 🔀 Merge pull request #2 from hemoptysisheart/issue/some_detail_docs (6일 전) <H2>
| |\
| | * 9face02 - 📝 ADR 템플릿 추가. (6일 전) <H2>
| | * b84321a - 📝 `README.md` 링크 규칙 추가. (6일 전) <H2>
| | * 8c52908 - 🩹 링크 경로에서 `README.md` 파일명 삭제. (6일 전) <H2>
| | * 0a18aee - 📝 git 규칙 추가. (6일 전) <H2>
| | * fb68c7c - 📝 용어집 추가. (6일 전) <H2>
| | * 0dd8b87 - 📝 DO 대신 IA를 작성하기로 결정. (6일 전) <H2>
| |/
| * b71dea5 - 📝 로드맵 추가. (6일 전) <H2>
| * 412eaec - ⬆️ 빠진 Hilt 의존성 업데이트. (6일 전) <H2>
| * 8603360 - 🔥 Figma 출력 이미지 삭제. (6일 전) <H2>
| * 3eb3b03 - 📝 앱 목표 추가. (6일 전) <H2>
| * d60506b - 💬 스타트업 메시지 변경. (6일 전) <H2>
| * ce65534 - 📝 디자인 문서 추가. (6일 전) <H2>
| * 9d0a049 - 💄 스플래시용 런처 액티비티 추가. (6일 전) <H2>
| * dfc34c6 - ⬆️ Hilt 업그레이드. `2.43.2` -> `2.44` (6일 전) <H2>
| * e987e66 - ⬆️ 안드로이드 플러그인 업그레이드. `7.3.0` -> `7.3.1` (6일 전) <H2>
| * 346475e - 💄 앱 아이콘 추가. (6일 전) <H2>
|/
*   37db4c0 - 🔀 Merge pull request #1 from hemoptysisheart/project_init (6일 전) <H2>
|\
| * 16c5bbf - 👷 CI 잡 이름 변경. (6일 전) <H2>
| * a30e6e4 - ⚗️ 브랜치 필터 수정 #3 (6일 전) <H2>
| * c1d39bb - ⚗️ 브랜치 필터 수정 #2 (6일 전) <H2>
| * 2ede98a - ⚗️ 브랜치 필터 수정. (6일 전) <H2>
| * ab604da - 💚 빌드 스크립트의 버전 수정. (6일 전) <H2>
| * 8fb9c1a - ⚗️ Hilt 의존성 추가. (6일 전) <H2>
| * cafa6bb - ⬆️ Gradle 업그레이드. `7.4` -> `7.5.1` (6일 전) <H2>
| * cbb7493 - 👷 CI 설정 추가. (6일 전) <H2>
| * 5bf6a69 - ➕ Jetpack 의존성 추가. (6일 전) <H2>
| * 190241a - 🏗️ 모듈구조 분할. (6일 전) <H2>
| * fe5b7ed - ➕ 테스트 의존성 추가, 업그레이드. (6일 전) <H2>
| * b585067 - 📝 앱 목표 추가. (6일 전) <H2>
|/
* 8e4e39f - 🎉 Init commit. (6일 전) <H2>
```

![Linear history](asset/linear%20history.png)

## 참고

- [ADR : git 규칙](adr/git%20rule.md)
- [A tidy, linear Git history](https://www.bitsnbites.eu/a-tidy-linear-git-history)
