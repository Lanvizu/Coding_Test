import sys
from collections import deque

input = sys.stdin.readline
H, W = map(int,input().split())
graph = list(map(int, input().split()))
q = deque()

# 시작을 n 이후 다음으로 높은 벽을 m 이라 지정
# 물의 높이만 알게되면 구하기 쉬운듯
# now_W 다음 최대 높이 출력
def next_max_wall(now_H, now_W):
    new_wall =[0,0]
    for i in range(now_W+1, W):
        if now_H < graph[i]:
            new_wall = [graph[i], i]
            return new_wall
        if new_wall[0] < graph[i]:
            new_wall = [graph[i], i]
    return new_wall

now_wall = [0,0]
for i in range(W-1):
    if graph[i] <= graph[i+1]:
        continue
    now_wall = [graph[i], i]
    break

new_wall = next_max_wall(now_wall[0], now_wall[1])
q.append(new_wall)
total = 0
# 다음으로 높은 벽이 있는 경우만 반복
while q:
    new_wall = q.pop()
    cal_H = min(now_wall[0], new_wall[0])
    for i in range(now_wall[1] + 1, new_wall[1]):
        total += cal_H - graph[i]
    now_wall = new_wall
    new_wall = next_max_wall(now_wall[0], now_wall[1])
    if new_wall == [0,0]:
        continue
    q.append(new_wall)

print(total)
