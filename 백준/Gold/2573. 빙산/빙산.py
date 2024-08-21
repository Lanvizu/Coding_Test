def oneYear(n, m, ice):
    for i in range(n):
        for j in range(m):
            if ice[i][j] != 0:
                count = 0
                # 주변 0의 개수를 세는 부분
                if i > 0 and ice[i-1][j] == 0:
                    count += 1
                if j > 0 and ice[i][j-1] == 0:
                    count += 1
                if i < n-1 and ice[i+1][j] == 0:
                    count += 1
                if j < m-1 and ice[i][j+1] == 0:
                    count += 1
                ice[i][j] = max(0, ice[i][j] - count)

                # ice 가 0인 경우 이후 계산 문제 해결
                if ice[i][j] == 0 and i < n-1 and ice[i+1][j] !=0:
                    ice[i+1][j] += 1
                if ice[i][j] == 0 and j < m-1 and ice[i][j+1] !=0:
                    ice[i][j+1] += 1
    return ice

def dfs(x, y, visited, ice, count):
    stack = [(x, y)]
    while stack:
        cx, cy = stack.pop()
        if visited[cx][cy] > count or ice[cx][cy] == 0:
            continue
        
        visited[cx][cy] += 1
        
        # 4 방향으로 DFS 탐색
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        for dx, dy in directions:
            nx, ny = cx + dx, cy + dy
            if 0 <= nx < len(ice) and 0 <= ny < len(ice[0]) and ice[nx][ny] > 0:
                stack.append((nx, ny))

def countIceRegions(n, m, ice, visited, count):
    region_count = 0 

    for i in range(n):
        for j in range(m):
            if ice[i][j] != 0 and visited[i][j] == count: 
                dfs(i, j, visited, ice, count)
                region_count += 1

    return region_count

n, m = map(int, input().split())
ice = [list(map(int, input().split())) for _ in range(n)]

result = 0
count = 0
visited = [[0] * m for _ in range(n)]
while True:
    result += 1
    ice = oneYear(n, m, ice)
    
    region = countIceRegions(n, m, ice, visited, count)
    count += 1
    
    if region > 1:
        print(result)
        break
    elif region == 0:
        print(0)
        break
