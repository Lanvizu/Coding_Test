import sys
input = sys.stdin.readline

H,W,N,M = map(int,input().split())

target_h = lambda: H // (N+1) + 1 if H % (N+1) != 0 else H // (N+1)
target_w = lambda: W // (M+1) + 1 if W % (M+1) != 0 else W // (M+1)

answer = target_h() * target_w()
print(answer)