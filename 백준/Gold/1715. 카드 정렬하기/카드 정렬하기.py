import heapq

n = int(input())
card_list = []
for i in range(n):
    a = int(input())
    heapq.heappush(card_list, a)

total = 0
while len(card_list) > 1:

    a = heapq.heappop(card_list)
    b = heapq.heappop(card_list)
    c = a + b
    total += c
    heapq.heappush(card_list, c)

print(total)
