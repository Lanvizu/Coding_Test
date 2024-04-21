n = input()
dist = list(map(int, input().split()))
cost = list(map(int, input().split()))

cost_now = cost[0]
dist_sum = 0
total = 0
for i in range(len(dist)):
    dist_sum += dist[i]
    if cost_now >= cost[i + 1]:
        total += dist_sum * cost_now
        cost_now = cost[i + 1]
        dist_sum = 0
    elif i == len(dist)-1:
        total += dist_sum * cost_now

print(total)
