import sys
input = sys.stdin.readline
N = int(input())
graph = [0] * (N+1)
for i in range(1,N+1):
    graph[i] = int(input())

def target_dfs(now, target, visited):
    global total_count
    if visited[now]:
        return
    visited[now] = True
    if target == graph[now]:
        for i in range(1, N+1):
            if visited[i] and selected[i] == False:
                selected[i] = True
                total_count += 1
    else:
        target_dfs(graph[now], target, visited)


selected = [False] * (N+1)
total_count = 0
for i in range(1, N+1):
    visited = [False] * (N+1)
    target_dfs(i,i,visited)
    
print(total_count)
for i in range(1,N+1):
    if selected[i]:
        print(i)