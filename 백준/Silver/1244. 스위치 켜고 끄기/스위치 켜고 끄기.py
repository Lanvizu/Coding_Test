import sys
input = sys.stdin.readline
N = int(input())
graph = list(map(int, input().split()))
M = int(input())

def switch_now(now):
    global graph
    if graph[now-1] == 1:
        graph[now-1] = 0
    else:
        graph[now-1] = 1

def man_switch(now):
    plus = now
    global graph
    while(now <= N):
        switch_now(now)
        now += plus 

def woman_switch(now):
    global graph
    switch_now(now)
    i = 1
    while(now - i > 0 and now + i <= N):
        if graph[now-i-1] == graph[now+i-1]:
            switch_now(now-i)
            switch_now(now+i)
            i += 1
        else:
            break

for i in range(M):
    A, B = map(int, input().split())
    if A == 1:
        man_switch(B)
    else:
        woman_switch(B)

for i in range(0,len(graph),20):
    print(*graph[i:i + 20])
