import sys
input = sys.stdin.readline

n = int(input())
graph = []
n_list = []
total = 0
n_list.append(0)
for _ in range(n):
    now, high = map(int, input().split())
    while n_list:
        tar_h = n_list[-1]
        if tar_h > high:
            total += 1
            n_list.pop()
        elif tar_h == high:
            break
        else:
            n_list.append((high))
            break
while n_list:
    if n_list.pop() != 0:
        total += 1
print(total)