# java-lotto
로또 미션 진행을 위한 저장소

# To do list

- Money
    - [x] [제약조건] 돈은 0 이상의 정수여야 한다.
    - [x] 돈은 값이 커질 수 있으니 BigInteger 로 저장한다.
- LotteryBuyingMoney
    - [ ] 로또 한 장의 가격은 1000원이다.
    - [ ] [제약조건] 로또 구매 가격은 로또 가격에 자연수를 곱한 값이어야 한다.
- LotteryNumber
    - [ ] 로또 번호는 개수가 제한되어있고 값이 변하지 않는 불변객체이므로 캐싱한다.
    - [ ] [제약조건] 로또 번호는 1 이상 45 이하이다.
- LotteryNumbers
    - [ ] 로또 번호들에 대한 일급 컬렉션이다.
    - [ ] [제약조건] 로또 번호는 6개이다.
- Lottery
    - [ ] [제약조건] 로또 번호는 겹칠 수 없다.
- LotteryFactory
    - [ ] 자동 로또를 하나 발급한다.
    - [ ] 번호를 입력받아 수동 로또를 발급한다.
- LotteryCreationStrategy
    - [ ] createNumbers(): LotteryNumbers
- RandomLotteryCreationStrategy
    - [ ] 난수 발생을 이용하여 로또 번호를 생성한다.
- ManualLotteryCreationStrategy
    - [ ] 생성자의 인자로 번호들을 입력받고, 그대로 로또 번호를 생성한다.
- WinningLottery
    - [ ] 로또 1 장과 보너스 번호 1 개를 인스턴스 변수로 갖는다.
    - [ ] 로또를 인자로 받아 로또를 평가해 Rank 를 반환한다.
    - [ ] [제약조건] 로또 1 장의 번호와 보너스 번호는 겹치면 안 된다.
- Result
    - [ ] 당첨 로또와 로또들의 리스트를 생성자의 인자로 받는다.
    - [ ] 로또들을 평가해 Rank 들을 얻어내 Map<Rank, Long> 으로 만든다.
- Rank
    - [ ] 당첨 번호의 개수와 보너스 당첨 여부를 인자로 받아 적절한 Rank 를 반환한다.
    - [ ] 당첨 금액을 반환한다.
