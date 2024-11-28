import sys
input = sys.stdin.readline

A,B = map(int,input().split())

def cal_2(target):
    cnt = 0
    now = target
    while now // 2 > 0:
        now = now // 2
        cnt += 1
    return cnt

def count(N):
    return int((2**(N-1))*N)

def cal(target):
    now = target
    total = 0
    while now > 0:
        now_2 = cal_2(now) # 3 / 2
        now -= 2**now_2 # 13-8=5 / 5-4=1
        total += count(now_2) + now + 1 # 12+5+1 / 4+1+1 
    return total

print(cal(B) -cal(A-1))
