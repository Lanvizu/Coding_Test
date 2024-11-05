import sys
input = sys.stdin.readline
N, M = map(int, input().split())
result = {}
for _ in range(N):
    now_input = input().rstrip()
    if len(now_input) < M:
        continue
    if now_input in result:
        result[now_input] += 1
    else:
        result[now_input] = 1
result = sorted(result.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for key in result:
    print(key[0])