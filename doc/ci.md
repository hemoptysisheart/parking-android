# CI

자동으로 작업 브랜치(혹은 PR)가 [`main`](https://github.com/hemoptysisheart/parking-android/tree/main)에 반영해도 괜찮은지 판단하는 시스템.

## 파일

[`ci.yml`](../.github/workflows/ci.yml)

## 기능

1. 단위 테스트 실행.
    - `gradle test`

## 설정

### `local.properties`

1. [`Actions secrets`](https://github.com/hemoptysisheart/parking-android/settings/secrets/actions)로 이동.
   ![초기 상태](asset/ci/actions%20secret%20-%20init.png)
2. [`New repository secret`](https://github.com/hemoptysisheart/parking-android/settings/secrets/actions/new) 클릭.
   ![새 시크릿](asset/ci/actions%20secret%20-%20new.png)
3. 설정값 추가.
   ![파일 내용](asset/ci/actions%20secret%20-%20set.png)
    - `GOOGLE_MAPS_API_KEY`
4. `Add secret` 클릭.
   ![결과](asset/ci/actions%20secret%20-%20added.png)
5. GitHub Actions용 `local.properties` 파일 생성.
    - [`echo ${{ secrets.FILE_LOCAL_PROPERTIES }} >> local.properties`](../.github/workflows/ci.yml#L16-L18)

## 참고

- [Encrypted secrets](https://docs.github.com/en/actions/security-guides/encrypted-secrets)
