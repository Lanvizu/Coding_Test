import sys

input = sys.stdin.readline

R,C = map(int,input().split())
graph = [list(str(input())) for _ in range(R)]
check=[0]*26
result=0
count=1
dx=[0,0,1,-1]
dy=[1,-1,0,0]
def DFS(x,y,count):
    global result
    result=max(count,result)
    for i in range(4):
        nx = dx[i]+x
        ny = dy[i]+y
        if 0<=nx<R and 0<=ny<C: 
            if check[ord(graph[nx][ny])-65]==0: 
                check[ord(graph[nx][ny])-65]=1
                DFS(nx,ny,count+1)
                check[ord(graph[nx][ny])-65]=0      
check[ord(graph[0][0])-65]=1                      
DFS(0,0,1)
print(result)