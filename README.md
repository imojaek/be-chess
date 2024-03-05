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
