a = input().split("-")
size = len(a)

total = 0
for i in range(size):
    if i == 0:
        b = a[i].split("+")
        for j in range(len(b)):
            total += int(b[j])
    else:
        b = a[i].split("+")
        for j in range(len(b)):
            total -= int(b[j])

print(total)