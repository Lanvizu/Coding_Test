# 다익스트라 사용하는 것 아닌가
import sys
import heapq
input = sys.stdin.readline

N, M = map(int,input().split())
# 1부터 N으로 가는 다익스트라 사용
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

def dijkstra(start, g):
    dist = [float('inf')] * (N+1)
    dist[start] = 0
    q = [(0, start)]

    while q:
        now_m, now = heapq.heappop(q)
        if now_m > dist[now]:
            continue
        for next, next_m in g[now]:
            total_m = now_m + next_m
            if total_m < dist[next]:
                dist[next] = total_m
                heapq.heappush(q,(total_m, next))
    return dist

dist_start = dijkstra(1, graph)
print(dist_start[N])
