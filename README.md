# be-chess

2024 마스터즈 체스 프로젝트

## 주의할 점

- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.



---
## Step-2

- BoardTest 를 확인하고 Board 생성
  - [x] Pawn을 pieces 패키지로
  - [x] 외부에서 접근 가능한 색상 상수
  - [x] pawn을 보드에 추가하는 add(Pawn pawn)
    - 일단 Board를 Pawn[8][8] 선언했습니다.
    - 체스판이 8*8의 배치를 갖는다는 점에서 배열의 크기를 결정했고, 지금은 폰만 존재하기 때문에 형식은 Pawn입니다. 이후 pieces 같은 것으로 대체할 예정입니다.
    - findFreeBoard() : board의 빈자리를 찾아 xpos, ypos를 그 위치로 만들어 둡니다. 이렇게 정해진 위치에 add의 매개로 받은 pawn을 넣습니다.
  - [x] 폰의 개수를 확인하는 size()
  - [x] 보드의 특정 폰의 색상을 반환하는 findPawn(int index)
    - index를 통한 확인을 위해, Pawn이 add를 통해 등록될때 Board.pawnList에도 추가할 수 있도록 했습니다.

---
## Step-3

- 보드 초기화
  - [x] 각 색상마다 8개의 폰을 추가한다.
    - 흰색, 검은색 리스트를 만들어서 추가하고, ~~board 배열에 배치한다.~~
      - 마스터클래스 중에 나왔던 얘기로, 2차원 배열로 선언해뒀던 보드를 폐기하고, HashMap을 이용해서 보드를 구현해본다. 
    - add를 사용해서 보드의 특정위치에 말을 추가하려면 인자가 더 필요한데?
      - 체스의 좌표인 "A1" ~ "H8" 을 추가 인자로 해서 보드에 추가하려고 한다.

- 보드 출력
  - [x] representation을 생성자로 입력하는 대신에, 각 Piece가 색만 인자로 받고, 내부에서 enum인 ChessPiece의 값을 이용하려고 한다.
    - 왜? Pawn 클래스는 폰만 가질 것이기 때문에 색상 정보만으로 내부에서 판단해도 된다고 생각했다.
  - [x] board를 순회하면서 Pawn의 chessIcon 정보를 받아 문자열을 만든다.
  - [x] 이렇게 생성된 문자열을 반환한다.


- 콘솔 입력
  - [x] start : 초기화 및 출력 -> Board에서 작성한 initialize(), print()를 이용한다.
  - end : 종료

### 문제
- 데스크탑, 인텔리제이 테스트를 진행할 때, 환경에서 체스말 유니코드들에 대해 `error: unmappable character (0xE2) for encoding x-windows-949` 오류가 발생했습니다.

  File - Settings - File Encodings 에서 인코딩 방식을 모두 UTF-8로 바꿔주고, File - Invalidate Caches로 프로젝트를 다시 빌드해서 해결했습니다.

- 잘 동작하는지 테스트를 위해 메인 흐름에서 사용하지 않는 getter를 만들어서 테스트를 했습니다. 그런데 정상동작하는 것을 확인한 이후에도 테스트코드를 남겨둘지 고민을 했습니다.

- 2차원배열이 아닌 다른 방식으로의 board 구현하려면 어떻게 할까?
  - 좌표정보와 해당 좌표에 어떤 기물이 있는지만 확인하면 되겠다는 아이디어가 1번. 
  - 그리고 체스의 좌표는 A1~H8로 구분한다는 것을 보고, 이 좌표를 사용하고 싶어 HashMap<String position, Pawn pawn> 의 형태로 만들었습니다.
  - Key인 좌표는 "A1" ~ "H8" 의 값을 갖고, Value 에 Pawn 등의 기물이 배치될 것입니다.


### 테스트하기 좋은 코드?

https://jojoldu.tistory.com/681

---
## Step - 4

- StringUtils
  - [x] appendNewLine(String string) : System.getProperty("line.separator") 를 통해 운영체제에 따라 달라지는 개행문자를 커버할 수 있도록 한다.

- Piece
  - 기존에 폰은 색상정보만 가지고 있었는데, 이제 폰뿐만 아니라 킹, 퀸 등의 다른 기물도 포함해야 한다. 그래서 기물의 이름을 추가로 갖게 한다. 
  - 값 객체 -> 불변성을 유지해야 한다.

- 팩토리메소드
  - createNewPiece(String color, ChessPiece pieceType)
    - color와 pieceType 으로 12가지 체스기물을 구분하고 해당하는 생성메소드를 호출합니다.
  
값 객체 (Value Object)
- 불변하다.
  - 값 객체는 그 자체로 값을 가지고 있고, 값을 나타낸다. 생성된 이후에는 불변하기 때문에, 필요한 경우 다른 값을 갖는 객체를 생성해야한다. 
- 동등성으로 비교를 한다
  - 동등성으로 비교를 하기 때문에, 두 값 객체 내부의 값이 동일하면 그 객체들은 동등한 객체다. 

### 문제
기존에 아래처럼 폰이 등록될 position을 정할 때 int형 file을 String으로 바꿔 사용했습니다. 

```java
for (int file = 'A'; file <= 'H'; file++) {
    String targetPos = String.valueOf(file) + rank;
...
```

등록 및 출력을 동일한 로직으로 반복했기때문에 폰만 등록했을때는 문제가 없었습니다. 그런데 이번에 나이트, 비숍 등의 기물을 추가하면서 "A1", "B1" 형태의 문자열로 포지션을 입력했습니다.

기물을 모두 추가하고 출력결과를 확인해보니, 폰만 출력되는 것을 확인했고, 이유를 찾아보니 폰의 position이 672 682 등의 숫자로만 되어있었습니다. 
int형 file을 사용해서 벌어진 문제였고, char형으로 변경해서 의도했던 동작을 하도록 수정했습니다.

---

### 추가적인 키워드
ParameterizedTest
- 어떤 메소드를 테스트할 때, 여러가지 데이터를 매개인자로 넣어 테스트할 수 있도록 해준다.
- ValueSource, CsvSource, EnumSource 등
- NullSource, EmptySource, NullAndEmptySource
  - 위와 아래의 source를 동시에 사용할 수 있다. 빈 문자 뿐 아니라 추가로 유효한 문자를 넣고 싶다면 아래와 같이..

```java
@ParameterizedTest
@NullAndEmptySource
@ValueSource(strings = {"  ", "\t", "\n"})
void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
```

- MethodSource : 명시하는 소스들 뿐 아니라 메소드의 반환값도 source로 사용할 수 있다.
```java
@ParameterizedTest
@MethodSource // hmm, no method name ...
void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input) {
    assertTrue(Strings.isBlank(input));
}

private static Stream<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument() {
    return Stream.of(null, "", "  ");
}
```

https://www.baeldung.com/parameterized-tests-junit-5

---

## 테스트코드의 메소드가 public이어야 했고, 이제는 public이 아니어도 되는 이유?

[칼리아 PR에 있는 호눅스 코멘트](https://github.com/codesquad-members-2024/be-chess/pull/107/files/3190f431b61aa9b8882cc10772d787bad9e1ee24#r1515378529) 

이전에도 그랬고, 지금도 그렇듯 테스트를 작성할때 다른 메소드들을 `리플렉션`으로 받아와서 테스트를 했다.

그런데, JUnit이 만들어지던 시기의 Java는 JDK1.1 버전이었고, 이때의 자바는 리플렉션을 public 메소드에서만 허용을 했기 때문이라고 한다.

그러한 이유로 JUnit의 테스트메소드가 public이어야 한다는 제약이 생겼다. JDK의 제약은 1.2버전부터 리플렉션을 모든 접근권한에서 가능토록 바꾸었지만, JUnit의 제약은 JUnit4까지 지속되었다.

그리고 JUnit5 부터는 이러한 제약이 사라지고, 테스트메소드의 어노테이션으로 @Test를 주어야 한다는 제약만 남았다.

https://mangkyu.tistory.com/280
https://groups.google.com/g/ksug/c/xpJpy8SCrEE?pli=1

## 테스트코드를 위한 메소드를 어떻게 처리해야 하는가?

1. public 으로 선언해서 사용한다.
2. 다른 접근제한자로 선언해두고, 테스트코드에서 리플렉션을 사용해 불러온다.
3. 어떻게 할까?

---
### Step - 5

- [x] Piece 내부에 enum 선언해서 색상과 기물 정보를 담아둔다.
- 빈칸을 모두 NO_PIECE로 채워야 하나..??
  - Map으로 관리하는 체스보드에서 빈칸인지 확인은 HashMap.containsKey 로 확인하면 될 것 같은데...
- `(Why?) 왜 그렇게 하면 좋은지에 대해 생각해 보자.` 
  - 모든 칸에 같은 타입의 객체인 Piece를 두면, 이후 기물들간의 상호작용 로직을 원활하게 할 수 있을까?
  - 이동도 Piece 서로 간의 교환을 통해서?

- [x] 색, 기물종류 별 개수 확인하기 - countPiece(Color, Type)
- [x] 주어진 위치의 기물조회 - findPiece(String position)

- Move(Piece, String position) 
  - 단순히 Piece를 해당 위치로 옮긴다?
  - [x] 이동 위치의 Piece와 이동할 Piece의 위치를 교환한다?
    - 64개 Piece를 유지하면서 상식으로는 일반적인 흐름.
  - 체스보드를 해시맵으로 구현했기 때문에, 목표 좌표에 해당하는 요소를 제거하고, put(position, Piece) 로 넣어줬습니다.


- isSameColor, isSameType 을 만들어뒀는데 `isSamePiece` 에 대해서는 나중에 효용을 다시 판단할 필요가 있음.

---


이 메소드의 존재로 나머지 코드가 사실상 중복코드가 되어 버렸네요.
Piece(color, type) 생성자와 어떤 차이가 있을까요?



---

Spring 코드

캡슐화 상속화 추상화 다형성

테스트코드 DisplayName

코드, 테스트코드가 모두 깔끔하면 주석 없이도 이해가 편하지만, 그렇지 않기때문에 복잡한 메소드으 ㅣ경우 주석 한두줄정도.

유지보수 > 가독성 > 성능 : 

덩치가 커진 클래스는 복잡해지면 다른 클래스로 책임을 위임(전가)하며 덩치를 줄일 수 있다.

이중 리스트의 의미 -> 일급객체를 사용해보라고.

> PR은 기능 단위, 커밋 단위는 가장 작게. (메소드 하나정도?) 
> 커밋 메시지를 한줄로 요약할 수 없다? "~고" 같은 말이 들어간다? 좀 더 줄여야한다.

> 원격 저장소의 커밋은 건들지 말자. 읽기 전용이라고 생각할 것. 다른 사람이 사용할 때 문제가 생길 수 있음.

> 상속보다는 컴포지션을 사용하라.

> 작은 목표를 세워서 성공경험을 느껴라. 그리고 칭찬해라.


> WAS + HTTP