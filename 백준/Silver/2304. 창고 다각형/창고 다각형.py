# 올라갈 때는 무조건 올라가기만,
# 내려갈 때는 반대로
# 앞, 뒤에서도 계단식으로 진행 -> 같아지는 순간이 마무리
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = []
graph_high = 0
start,end = 0, 0
for _ in range(N):
    target = list(map(int,input().split()))
    graph.append(target)
    graph_high = max(graph_high,target[1])
graph.sort(key=lambda x:(x[0]))
q1 = deque(graph)
q2 = deque(graph)
result = {}
total = 0
while q1:
    sn = q1.popleft()
    if start<=sn[1]:
        start = sn[1]
        result[sn[0]] = sn[1]

while q2:
    en = q2.pop()
    if end<=en[1]:
        end = en[1]
        if en[0] in result:
            break
        result[en[0]] = en[1]
result = sorted(result.items())
total += result[0][1]

for i in range(len(result)-1):
    now = result[i]
    next = result[i+1]
    if next[1] >= now[1]:
        total += (next[0] - now[0]-1) * now[1]
        total += next[1]

    else:
        total += (next[0] - now[0]-1) * next[1]
        total += next[1]
print(total)