# dp 아닌가
# 두가지 경우 밖에 없으니까
# A를 추가하는 경우와 B를 추가 후 뒤집는 과정

# 시간초과 -> 이미 만들어진 문장은 제외하자.
import sys

input = sys.stdin.readline
S = str(input().rstrip())
T = str(input().rstrip())
result = 0

def dp(S, T):
    global result
    if len(S) < len(T):
        S_A = S + 'A'
        # 원본, 뒤집은 것이 T 안에 있는 경우만 dp
        if S_A in T or S_A[::-1] in T:
            dp(S_A, T)
        S_B = S + 'B'
        if S_B in T or S_B[::-1] in T:
            dp(S_B[::-1], T)
    else:
        if S == T:
            result = 1
            return

dp(S, T)
print(result)
