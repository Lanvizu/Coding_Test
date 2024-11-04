import sys
input = sys.stdin.readline

T = int(input())

def count_2(n):
    global total_count
    count = int(n/2) + 1
    total_count += count

def count_3(n):
    count = int(n/3) + 1
    for i in range(count):
        now_n = n - (i*3)
        count_2(now_n)

for _ in range(T):
    n = int(input())
    total_count = 0
    count_3(n)
    print(total_count)