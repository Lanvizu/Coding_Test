import sys
from collections import deque
N = int(input())
M = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
target = list(map(int, input().split()))
target = set(target)
visited = [False] * N

# 특정 위치와 연결된 모든 도시 리스트로 출력
def bfs(graph, visited, now):
    q = deque()
    q.append(now)
    result = []
    result.append(now + 1)
    visited[now] = True
    while q:
        nx = q.popleft()
        for i in range(N):
            if visited[i] or graph[nx][i] == 0:
                continue
            visited[i] = True
            q.append(i)
            result.append(i + 1)
    return result

def target_count(result, target):
    count = 0
    for city in result:
        if city in target:
            count += 1
    if count >= len(target):
        print('YES')
        return True
    elif 0 < count < len(target):
        print('NO')
        return True
    else:
        return False

for i in range(N):
    if visited[i]:
        continue
    result = bfs(graph, visited, i)
    if target_count(result, target):
        break