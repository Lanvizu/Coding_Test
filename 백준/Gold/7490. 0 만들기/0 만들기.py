T = int(input())

type = ['+','-',' ']

def count(str_t):
    global answer
    cal_str = ''.join(str(a) for a in str_t if a != ' ')
    new_str = ''.join(str(a) for a in str_t)
    
    result = eval(cal_str)
    if result == 0:
        answer.append(new_str)

def make_t(str_t,index):
    if index > N:
        count(str_t)
        return
    for i in range(3):
        now_str = str_t[:]
        now_str.append(type[i])
        now_str.append(index)
        make_t(now_str, index+1)

for _ in range(T):
    N = int(input())
    answer = []
    str_t = [1]
    make_t(str_t,2)
    answer.sort()
    for a in answer:
        print(a)
    print()