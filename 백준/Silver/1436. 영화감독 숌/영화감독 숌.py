n = int(input())

total = 0
now = 665

while total < n:
    now += 1
    now_str = str(now)

    for i in range(len(now_str) - 2):
        if now_str[i] == '6' and now_str[i + 1] == '6' and now_str[i + 2] == '6':
            total += 1
            break

print(now)
