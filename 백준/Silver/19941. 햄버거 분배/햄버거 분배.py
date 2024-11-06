#20 1
#HHPHPPHHPPHPPPHPHPHP

# 왼쪽부터 차례대로라 가정했을때
# 중간에 선택하지 않는 경우가 최대한 많은 결과가 나올 수 있나
#  PHHHPPPPPHH 3
# 그런 경우는 없지 않나

import sys
input = sys.stdin.readline

N, K = map(int, input().split())
graph = list(input().rstrip())
visited = [False] * N

total = 0
for i in range(N):
    if graph[i] == 'H':
        continue
    # P인 경우 가장 왼쪽 부터
    left = lambda: 0 if i - K < 0 else i - K
    right = lambda: N-1 if i+K > N-1 else i+K

    for j in range(left(), right()+1):
        if j == i:
            continue
        if visited[j]:
            continue
        if graph[j] == 'P':
            continue
        visited[j] = True
        total += 1
        break
print(total)