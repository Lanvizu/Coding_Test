import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
min_x = float('inf')

def count_0(graph):
    global min_x
    now_sum = sum(row.count(0) for row in graph)
    min_x = min(min_x, now_sum)

def cctv(x, y, graph_now, dir):
    graph_new = [row[:] for row in graph_now]
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    nx, ny = x + dx[dir], y + dy[dir]
    while 0 <= nx < N and 0 <= ny < M and graph_new[nx][ny] != 6:
        if graph_new[nx][ny] == 0:
            graph_new[nx][ny] = 7
        nx, ny = nx + dx[dir], ny + dy[dir]
    return graph_new

def cctv_act(type, x, y, graph_now, dd):
    graph_next = [row[:] for row in graph_now]
    if type == 1:
        graph_next = cctv(x, y, graph_next, dd)
    elif type == 2:
        graph_next = cctv(x, y, graph_next, dd)
        graph_next = cctv(x, y, graph_next, (dd + 2) % 4)
    elif type == 3:
        graph_next = cctv(x, y, graph_next, dd)
        graph_next = cctv(x, y, graph_next, (dd + 1) % 4)
    elif type == 4:
        for i in range(3):
            graph_next = cctv(x, y, graph_next, (dd + i) % 4)
    return graph_next

def cctv_5(x, y, graph_now):
    graph_next = [row[:] for row in graph_now]
    for i in range(4):
        graph_next = cctv(x, y, graph_next, i)
    return graph_next 

def activate(cctv_list, graph_now):
    if not cctv_list:
        count_0(graph_now)
        return
    
    cctv_now = cctv_list.pop()
    x, y, cctv_type = cctv_now
    
    directions = 4 if cctv_type in [1, 3, 4] else 2 if cctv_type == 2 else 1
    
    for i in range(directions):
        graph_next = cctv_act(cctv_type, x, y, graph_now, i)
        activate(cctv_list.copy(), graph_next)
    
    cctv_list.append(cctv_now)

cctv_list = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 5:
            graph = cctv_5(i, j, graph)
        elif graph[i][j] in [1, 2, 3, 4]:
            cctv_list.append([i, j, graph[i][j]])

activate(cctv_list, graph)
print(min_x)