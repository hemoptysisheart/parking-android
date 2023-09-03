# CI

자동으로 작업 브랜치(혹은 PR)가 [`main`](https://github.com/hemoptysisheart/parking-android/tree/main)에 반영해도 괜찮은지 판단하는 시스템.

## 파일

[`ci.yml`](../.github/workflows/ci.yml)

## 기능

1. 단위 테스트 실행.
    - `./gradlew clean :util:test :domain:test testDebugUnitTest --continue`

## 설정

### `local.properties`

1. [`Actions secrets`](https://github.com/hemoptysisheart/parking-android/settings/secrets/actions)로 이동.
   ![초기 상태](asset/ci/actions%20secret%20-%20init.png)
2. [`New repository secret`](https://github.com/hemoptysisheart/parking-android/settings/secrets/actions/new) 클릭.
   ![새 시크릿](asset/ci/actions%20secret%20-%20new.png)
3. Google Maps Platform 키 추가.
   ![파일 내용](asset/ci/actions%20secret%20-%20set%20gmp%20key.png)
    - `GOOGLE_MAPS_API_KEY`
4. `Add secret` 클릭.
   ![결과](asset/ci/actions%20secret%20-%20added.png)
5. GitHub Actions용 `local.properties` 파일 생성.
    - [`echo GOOGLE_MAPS_PLATFORM_API_KEY=${{ secrets.GOOGLE_MAPS_PLATFORM_API_KEY }} >> local.properties`](../.github/workflows/ci.yml#L15)

### Firebase

GitHub Actions에서 실행한 단위테스트 결과를 업로드하고 리뷰할 수 있도록 한다.

1. Firebase 프로젝트 추가.
   ![프로젝트 추가](asset/ci/firebase%20-%20new%20project.png)
2. 서비스 계정으로 이동.
   ![프로젝트 설정](asset/ci/firebase%20-%20open%20setting.png)
   ![서비스 계정](asset/ci/firebase%20-%20open%20service%20account.png)
   ![서비스 계정](asset/ci/firebase%20-%20service%20account.png)
3. CLI에서 로그인
   `firebase login`
   ![CLI login](asset/ci/firebase%20-%20login%20cli.png)
   ![OAuth 승인 1](asset/ci/firebase%20-%20login%20oauth%201.png)
   ![OAuth 승인 2](asset/ci/firebase%20-%20login%20oauth%202.png)
4. GitHub 연결 설정.
   ![GitHub 연결](asset/ci/firebase%20-%20integrate%20github%201.png)
   ![GitHub OAuth](asset/ci/firebase%20-%20integrate%20github%202.png)
   ![GitHub Service Account](asset/ci/firebase%20-%20integrate%20github%20sa.png)
5. 생성된 워크플로우.
   ![](asset/ci/firebase%20-%20integrate%20github%20workflow.png)

## 참고

- [Encrypted secrets](https://docs.github.com/en/actions/security-guides/encrypted-secrets)
- [GitHub Actions](https://docs.github.com/actions)
    - [Default environment variables](https://docs.github.com/actions/learn-github-actions/variables#default-environment-variables)
- [GitHub pull 요청을 통해 실시간 및 미리보기 채널에 배포](https://firebase.google.com/docs/hosting/github-integration)
