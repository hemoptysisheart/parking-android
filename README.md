# Parking

주차장 찾기 앱.

## 목적

목적지와 주차장이 따로인 경우, 주차 문제를 포함해 최적 경로를 안내한다.

1. 운전자의 주차 문제 개선.
2. 주차장 사용률 개선.
3. 목적이 있는 차량 사용 데이터 수집.

## KPI(Key Performance Indicator)

고속 이동시의 사용시간.

### 보조 KPI

1. 앱 실행 횟수.
2. 장시간 사용 횟수.
3. 고속 이동시간과 앱 사용시간 일치율.

## 사용 시나리오

### 저녁 약속

친구와 저녁 약속으로 처음 가보는 곳에 가야 한다. 큰 차는 다른 일로 써야 하니 작은 차를 사용하기로 했다. 앱을 실행하고 약속장소까지 경로를 검색한다. 약속장소 근처에서 주차장이 3개가 검색된다. 역시 무리해서
큰 차를 선택하지 않은 게 옳았다. 검색된 주차장은 주차가 어려워서 작은 차만 주차할 수 있다는 평가다. 추천 주차장 중에서 목적지에 가장 가까운 곳을 선택해 운전을 시작한다. 경로 안내를 따라 운전을 하다보니
주차장이 가득 찼다는 알림과 함께 다음으로 가까운 주차장으로 변경된다. 주차를 하고 친구를 만나 이야기를 하다보니 주차요금 변경시간이 가까워졌다는 알림이 온다. 잠깐 나와서 다시 주차를 하고 돌아온다.

### 매장 관리

오늘부턴 3개 매장에 나가서 매장을 확인해야 한다. 그 중 2곳은 작아서 주차장이 없고 주변의 주차장을 써야 한다. 전임자에게 주변 주차장 목록을 공유 받았다. 목록 중에서 검색해서 운행을 시작한다. 주차를 한 후에
업무를 보고 돌아온다. QR 코드 스캔으로 회사 계정으로 주차요금을 정산하고 다음 매장으로 이동한다.

## 로드맵

### M1 : 사용자 모집

M2 이후로 나가기 위해 최소한의 유저 확보가 목표. 이 단계에서 수익은 목표을 목표로 하긴 어렵다.

1. 주차장을 포함한 네비게이션 앱.
2. 앱에 일정 관리 기능을 포함, 이동 시간을 고려한 정보 제공.
3. 주차장 리뷰를 포함한 정보 공유.

#### [요구사항](https://www.figma.com/file/rKJxXjvDtDNprvdojVxaaN/Parking?type=whiteboard&node-id=507-150)

1. 목적지 근처의 주차장을 경유하는 경로를 검색할 수 있다.
    1. 키워드로 목적지를 검색한다.
    2. 목적지를 검색하면 자동으로 주차장을 검색한다.
    3. 현재 위치에서 주차장까지, 주차장에서 목적지까지 경로를 자동으로 검색한다.
2. 검색어 이력을 기록한다.
3. 선택한 목적지 이력을 기록한다.
4. 선택한 경로 이력을 기록한다.
5. 목적지는 구글 Places를 사용하지만, 다른 서비스를 사용할 수도 있다.
    1. 지도를 구글맵이 아닌 다른 맵을 사용하게 될 수도 있다. 한국에선 구글맵으로 경로 안내를 할 수 없다.
6. 지도, API 등 외부 서비스 사용 비용을 절약하기 위해 중간 입력은 최대한 무시한다.
    1. 사용량을 초과했을 때를 대비해 사용자가 자신의 키를 입력할 수 있도록 한다.
7. 경로 안내는 현재 위치를 기반으로 다음에 어떤 행동을 해야 하는지 안내해야 한다.
8. 코드 수준에서 데이터와 인터페이스를 분리한다.
9. 목적지를 저장하고 관리할 수 있다.
10. 주차장을 저장하고 관리할 수 있다.
11. 자신의 데이터를 공개된 표준 형식의 파일로 백업할 수 있다.
12. 공개된 표준 형식의 파일을 입력할 수 있다.
13. 온라인에 자신의 데이터를 백업할 수 있다.
14. 온라인에 백업한 데이터는 다른 사용자와 공유할 수 있다.

### M2 : B2C 수익화

1. 차량용 애플리케이션 개발.
2. **보험**
    1. 주차중 접촉사고 등 경미한 사고에 대한 지원.
    2. 주차 사고에 관한 통계 데이터 판매.
3. **결제** : 주차요금 정산.

### M3 ~ : B2B 플랫폼

1. **모빌리티** : 카 쉐어링, 택시 등 이동 서비스 제공 사업으로 확장.
2. **차량관리**
    1. 앱을 이용해 수집한 운전자의 운전 데이터와 다른 사용자에게 얻은 차량의 통계 데이터를 기반으로 차량 관리에 필요한 정보를 제공하거나 서비스를 직접 제공.
    2. 다수의 차량을 이용하는 기업, 단체에 필요한 데이터를 제공하거나 위탁.
3. **주차장**
    1. 차량 이동의 필요와 주차 수요를 바탕으로 주차장 사업을 지원하거나 직접 제공.
    2. 주택 임대 및 매매에 주차장 연계.
4. **부동산**
    1. 출발 장소, 주차장소, 머무는 장소를 기반으로 분석 데이터를 생성하거나 직접 실행.
    2. 대형 주차장 중심으로 택지 조성.
5. **보험**
    1. 주차장에서 주행중 사고에 대한 보험으로 확대.
    2. _헬스케어_와 연계해 운전 외 보험으로 확대.
6. **헬스케어**
    1. _보험_을 기반으로 사고 후 치료, 회복 서비스 제공.
    2. 웨어러블 앱을 추가하고 헬스케어 확장.

## 기능

1. 자동차 목록 및 주차장소(차고지) 관리.
2. 지도 검색 및 주변 주차장 검색.
3. 주차장 평가 및 공유.
4. 주차장 빈자리 실시간 검색 및 알림.
5. 요금 결제.

## 설계

### UX

[Figma - Parking](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking)

### Information Architecture

[정보구조](doc/ia.md)

- [Information Architecture 우선](doc/adr/ia%201st.md)

TODO

### 모듈과 레이어

TODO

## 문서

- [Architectural Decision Record](doc/adr)
- [용어집](doc/glossary)
