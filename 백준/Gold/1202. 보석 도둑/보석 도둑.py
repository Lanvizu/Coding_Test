# 최대한 많이 담기보단 최대한 비싸게 담아야한다.
# N과 K 는 최대 300,000
# 비싼 순서대로, 가벼운 가방부터 넣기. -> sorted()
# 우선순위 큐를 사용하자.
# 가벼운 가방부터 해당 무게보다 작은 보석을 새로운 heap에 추가
# 해당 가방보다 무거운 보석인 경우 heap에서 가장 비싼 보석 빼서 total에 추가
import sys
import heapq
input = sys.stdin.readline

N, K = map(int, input().split())
jew_list = [list(map(int,input().split())) for _ in range(N)]
bag_list = [int(input()) for _ in range(K)]

jew_list.sort(key=lambda x:(x[0], x[-1]))
bag_list.sort()

total = 0
heap = []
i = 0

for bag in bag_list:
    while i < N and bag >= jew_list[i][0]:
        heapq.heappush(heap,(-jew_list[i][1]))
        i += 1
    if heap:
        total -= heapq.heappop(heap)

print(total)