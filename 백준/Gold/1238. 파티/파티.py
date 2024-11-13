import sys
import heapq
input = sys.stdin.readline

N, M, X = map(int, input().split())

# 정방향 그래프 생성
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def dijkstra(start, g):
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
shortest_paths_from_X = dijkstra(X, graph)

# 모든 정점에서 X로의 최단 경로
shortest_paths_to_X = [0] * (N+1)
for i in range(1, N+1):
    if i != X:
        shortest_paths_to_X[i] = dijkstra(i, graph)[X]

# 최대 왕복 시간 계산
max_round_trip = max(shortest_paths_from_X[i] + shortest_paths_to_X[i] for i in range(1, N+1) if i != X)
print(max_round_trip)