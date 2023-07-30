# 개발 환경

## Android Studio

### 설정

![Version Control - Commit](asset/preferences%20commit.png)

- ☑️ Reformat code
- ☑️ Optimize imports
- ☑️ Analyze code
- ☑️ Check TODO (Show All)
- ☑️ Run 'CI test'

![Version Control - Git](asset/preferences%20git.png)

- ☑️ Auto-update if push of the current branch was rejected
- Update method : [ ] Merge ☑️ Rebase

![Markdown preview](asset/choose%20boot%20runtime.png)

Markdown 프리뷰를 실행할 수 있도록 JCEF 런타임을 선택.

### 플러그인

- [GitToolBox](https://plugins.jetbrains.com/plugin/7499-gittoolbox)
- [Kotest](https://plugins.jetbrains.com/plugin/14080-kotest)
- [Native Terminal](https://plugins.jetbrains.com/plugin/9966-native-terminal)
- [scrcpy](https://plugins.jetbrains.com/plugin/14565-scrcpy)
- [.ignore](https://plugins.jetbrains.com/plugin/7495--ignore)

## macOS

- [Homebrew](https://brew.sh)
- [android-platform-tools](https://developer.android.com/studio/releases/platform-tools)
- [scrcpy](https://github.com/Genymobile/scrcpy)

### Homebrew

```shell
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

### Android 관련 툴

```shell
brew install android-platform-tools scrcpy
```
