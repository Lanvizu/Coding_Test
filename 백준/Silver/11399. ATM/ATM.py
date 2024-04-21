n = (int(input()))
data = list(map(int, input().split()))

data.sort()

result = 0
total = 0
for i in range(n):
    result += data[i]
    total += result

print(total)