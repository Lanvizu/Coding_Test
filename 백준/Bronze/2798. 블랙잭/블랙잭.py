n, m = map(int, input().split())
data = list(map(int, input().split()))
data.sort()
answer = 0
for i in range(n - 2):
    for j in range(i + 1, n - 1):
        if data[i] + data[j] >= m:
            continue
        for k in range(j + 1, n):
            total = data[i] + data[j] + data[k]
            if m >= total > answer:
                answer = total
print(answer)
