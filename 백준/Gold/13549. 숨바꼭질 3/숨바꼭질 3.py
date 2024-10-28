from collections import deque
N, K = map(int, input().split())
# bfs를 사용하지 위한 deque 설정
q = deque()
# N과 K 중 큰 값을 기준으로 2배 만큼 경우의 수 초기화
graph = [-1 for _ in range(max(N,K)*2 + 1)]
n_count = [N,0]
q.append(n_count)
while(q):
    # 선입 선출
    n_count = q.popleft()
    now = n_count[0]
    count = n_count[1]
    # print(n_count)
    if now > 2*max(N,K) or now < 0 or graph[now] != -1:
        continue

    graph[now] = count
    # 2배 증가를 먼저 적용
    q.appendleft([2*now, count])
    q.append([now+1, count + 1])
    q.append([now-1, count + 1])
        
# print(graph)
print(graph[K])