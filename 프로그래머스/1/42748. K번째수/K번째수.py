def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        print(i)
        new = []
        print(commands[i][0], commands[i][1])
        for j in range(commands[i][0], commands[i][1]+1):
            new.append(array[j-1])
        new.sort()
        answer.append(new[(commands[i][2]-1)])
            
    return answer