# 1. 총 움직인 길이 < 지름길의 길이
# 2. 지름길의 도착하는 곳 > D
# 두 경우에는 지름길을 탈 이유가 없음
# 0 50 10
# 0 50 20 X -> 이미 50의 최소가 10으로 지정됨
# 50 100 10 20
# 100 151 10 X -> 2번 예외 범위 벗어남
# 100 140 90 X -> 1번 예외 지름길이 더 김

# N 최대가 12개인데 이건 DP 해도 되는거 아닌가
# 다익스트라로 진행

import sys
import heapq
input = sys.stdin.readline

N, D = map(int,input().split())

# 지름길 예외 처리
def exp(a,b,c):
    if b-a < c:
        return False
    if b > D:
        return False
    return True

r_list = []
for i in range(N):
    a,b,c = list(map(int,input().split()))
    if exp(a,b,c):
        r_list.append((a,b,c))

def dijkstra(start, g):
    dist = [i for i in range(D+1)]
    min_cost = dist[D]
    q = [(start, 0)]
    while q:
        now, cost = heapq.heappop(q)
        for ne_start, ne_end, ne_cost in g:
            if now <= ne_start:
                total_cost = ne_start - now + cost + ne_cost
                if total_cost < dist[ne_end]:
                    dist[ne_end] = total_cost
                    min_cost = min(D-ne_end+total_cost, min_cost)
                    heapq.heappush(q, (ne_end, total_cost))
    return min_cost

min_cost = dijkstra(0,r_list)
print(min_cost)