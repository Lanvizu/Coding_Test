import sys
input_string = input().split()
N = int(input_string[0])
type = input_string[1]

save_set = set()
for i in range(N):
    save_set.add(input())

len(save_set)
if type == 'Y':
    print(len(save_set))
elif type == 'F':
    print(int(len(save_set)/2))
else:
    print(int(len(save_set)/3))
