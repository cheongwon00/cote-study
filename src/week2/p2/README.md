# 불량 사용자 Lv2 [문제](https://school.programmers.co.kr/learn/courses/30/lessons/64064)

## 아이디어

- 범위가 크지 않음 -> 완전탑색?
- 문자열 패턴 -> regular expression
- 중복 처리 -> set?

## 코드흐름

- 우선 dfs+백트랙킹을 이용해서 순열을 만들어줌
- regular expression을 이용해서, 패턴 매칭을 시켰을때 모두 만족하면
- set에 넣어서 중복은 제외함

## 배운점

- Permutation
- Regular expression
