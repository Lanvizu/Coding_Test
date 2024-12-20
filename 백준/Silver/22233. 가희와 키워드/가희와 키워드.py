# 딕셔너리 형태로 저장한 후 관리
# 없는 경우 무시 있는 경우에만 제거.

import sys
input = sys.stdin.readline

N, M = map(int,input().split())
graph = {}

for _ in range(N):
    now = str(input().rstrip())
    graph[now] = True

for _ in range(M):
    targets = list(map(str, input().split(',')))
    targets[-1] = targets[-1].rstrip()

    for target in targets:
        if target in graph:
            graph.pop(target)
    print(len(graph))