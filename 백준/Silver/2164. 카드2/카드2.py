N = int(input())
target = 1
while (N > target * 2):
    target *= 2
remove_card = N - target
if N == 1:
    answer = 1
else:
    answer = 2 * remove_card
print(answer)

# 150 3*5*5*2 -> 128 + 32 32번 제거 후 맨 뒤자리 즉 32 *2 번째 자리 64가 맨뒤 -> 64
# 6 = 4 + 2
# 123456
# 34562
# 5624
# 4

# 12345
# 3452
# 524
# 42
# 2

# 12345678
# 3456782
# 567824
# 78246
# 2468
# 684
# 48
# 8
# 2의 제곱일때 맨 마지막 자리 수