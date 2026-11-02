# 타겟 넘버 Lv2 [문제](https://school.programmers.co.kr/learn/courses/30/lessons/43165)

## 아이디어

- 같은 수를 더하거나 빼기만 가능 -> 자식노드가 2개
- 무조건 모든 수를 사용해서 target값이 나와야함 -> 모두 leaf노드까지 가야함 -> tree의 depth가 arr.length임

## 코드흐름

- State 레코드를 만들고, 여기에, 지금까지 계산된 수와 level을 저장
- stack을 활용해서, dfs구현, 다음 상태는 arr을 더하거나 뺀 2가지 경우를 넣어주고, level은 1 추가

## 배운점

- dfs 관련 문제에서 record를 사용하면 상태저장을 쉽게 할 수 있다.