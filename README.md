# [NEXTSTEP: 4주차] 블랙잭

---

### 기능 요구 사항

* 블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.
* 플레이어는 게임을 시작할 때 배팅 금액을 정해야 한다.
* 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
* 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
  단, 카드를 추가로 뽑아 21을 초과할 경우 배팅 금액을 모두 잃게 된다.
* 처음 두 장의 카드 합이 21일 경우 블랙잭이 되면 베팅 금액의 1.5 배를 딜러에게 받는다. 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 베팅한 금액을 돌려받는다.
* 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다. 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관
  없이 승리해 베팅 금액을 받는다.

```console
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

pobi의 배팅 금액은?
10000

jason의 배팅 금액은?
20000

딜러와 pobi, jason에게 2장의 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

딜러는 16이하라 한장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 수익
딜러: 10000
pobi: 10000 
jason: -20000
```

### 기능 목록

- [X] 플레이어 이름은 쉼표를 기준으로 구분
- [X] 각 플레이어는 베팅 금액 입력
- [ ] 베팅 금액이 숫자가 아닌 경우 예외처리
- [ ] 베팅 금액이 음수일 경우 예외처리
- [ ] 카드의 종류 13가지 존재
- [ ] 게임 시작시 모든 플레이어는 카드 2장씩 받음
- [ ] Ace는 1또는 11로 계산
- [ ] king, Queen, Jack은 각각 10으로 계산
- [ ] 각 플레이어는 21이 넘지 않는다면, 원하는 만큼 카드를 받을 수 있음
- [ ] 딜러는 17미만이면 자동으로 카드를 받음
- [ ] 플레이어의 처음 2장이 블랙잭이면 베팅 금액의 1.5배를 받음
- [ ] 플레이어가 딜러를 이기면 베팅 금액을 그대로 받음
- [ ] 플레이어가 21을 초과하면 베팅 금액을 잃음
- [ ] 딜러가 21을 초과할 경우, 승패 상관없이 모든 플레이어의 베팅 금액 그대로를 받음

---