import sys
import heapq
input = sys.stdin.readline

N, M = map(int, input().split())

# 인덱스에 넣고 싶은데 그러기에는 너무나 많은 10^9
# 범위를 기준으로 이분탐색 어떰
# 우선순위 큐에 넣고 이분탐색 돌리자

q = [(-1,'null')]
power = set()
for i in range(N):
    a,b = map(str,input().split())
    b = int(b)
    if b in power:
       continue 
    power.add(b)
    heapq.heappush(q,(b,a))

# len = 5 01234
# 5 -> 2 -> 1

for _ in range(M):
    target = int(input())
    high = len(q)-1
    low = 0
    now = high//2
    while True:

        if q[now][0] >= target > q[now-1][0]:
            print(q[now][1])
            break

        elif q[now][0] < target:
            if now+1 == high:
                print(q[high][1])
                break
            low = now + 1
            now = (low + high)//2

        else:
            # if now-1 == low:
            #     print(q[][])
            high = now
            now = (low + high)//2
            
            

            # 7 (0~ 6) -> len(q) 8 
            # tar 2
            # now = (tlen-1) // 2 -> 3 -> tlen = 3
            # now // 2 -> 1