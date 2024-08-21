from collections import deque

def bfs(home, mart, end):
    queue = deque([home])
    visited = set()
    visited.add(tuple(home))

    while queue:
        now = queue.popleft()

        if abs(end[0] - now[0]) + abs(end[1] - now[1]) <= 1000:
            return True
        for m in mart:
            if tuple(m) not in visited:
                dis = abs(m[0]- now[0]) + abs(m[1] - now[1])
                if dis <= 1000:
                    visited.add(tuple(m))
                    queue.append(m)

    return False

t = int(input())

for _ in range(t):
    n = int(input())
    home = list(map(int, input().split()))
    mart = [list(map(int, input().split())) for _ in range(n)]
    end = list(map(int, input().split()))
    
    if bfs(home, mart, end):
        print("happy")
    else:
        print("sad")
