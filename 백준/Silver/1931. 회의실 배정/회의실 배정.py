n = int(input())

data = [list(map(int, input().split())) for _ in range(n)]
data.sort()
result = []
for i in range(n):
    if i == 0:
        result.append(data[0][1])
        result.append(1)
    else:
        if result[0] <= data[i][0]:
            result[0] = data[i][1]
            result[1] += 1
        elif result[0] > data[i][1]:
            result[0] = data[i][1]

print(result[1])
