n = int(input())
total_list = []
for i in range(n):
    a = int(input())
    total_list.append(a)

total_list.sort()
a_max = 0
for i in range(n):
    x = (n - i) * total_list[i]
    if x > a_max:
        a_max = x

print(a_max)
