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