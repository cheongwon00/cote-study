# 이중우선순위큐 Lv3 [문제](https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java)

## 아이디어

- 최대, 최소 둘다 -> heap 2개를 사용
- 한쪽에서 삭제된값 어떻게 공유?? -> idx로 삭제된 값 저장

## 코드흐름

- minHeap, maxHeap 두 곳에, (idx,val)인 record를 저장, deleted배열에 삭제된 idx 저장
- 최대 삭제, 최소삭제시 deleted 배열에 표시, Heap에서 peek로 삭제된 idx면 계속 제거 후, 삭제되지 않은 값을 찾음

## 배운점

- 같은 값들을 서로다른 자료구조 2개에서 관리하기