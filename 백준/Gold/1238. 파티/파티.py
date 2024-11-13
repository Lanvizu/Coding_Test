import sys
import heapq
input = sys.stdin.readline

N, M, X = map(int,input().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    a,b,c = map(int, input().split())
    # 인접 리스트를 통해서 정보 처리
    graph[a].append((b,c))

def dijkstra(start, g):
    # 시작점에서 모든 경로 초기화
    dist = [float('inf')] * (N+1)
    dist[start] = 0
    q = [(0, start)]

    while q:
        now_t, now = heapq.heappop(q)
        if now_t > dist[now]:
            continue
        for next, weight in g[now]:
            total_t = now_t + weight
            if total_t < dist[next]:
                dist[next] = total_t
                heapq.heappush(q, (total_t, next))

    return dist

# X에서 모든 정점으로의 최단 경로
all_from_X = dijkstra(X, graph)

# 모든 정점에서 X로의 최단 경로
all_to_X = [0] * (N+1)
for i in range(1, N+1):
    if i != X:
        all_to_X[i] = dijkstra(i, graph)[X]

max_t = max(all_from_X[i] + all_to_X[i] for i in range(1, N+1) if i != X)
print(max_t)