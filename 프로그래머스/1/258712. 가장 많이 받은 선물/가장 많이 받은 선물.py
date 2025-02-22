def solution(friends, gifts):
    length = len(friends)
    graph = [[0]*length for _ in range(length)]
    for now in gifts:
        A,B = map(str, now.split())
        a = friends.index(A)
        b = friends.index(B)
        graph[a][b] += 1
        
    indices = [0] * length
    for i in range(length):
        a = 0
        b = 0
        for j in range(length):
            a += graph[i][j]
            b += graph[j][i]
        indices[i] = a - b
        
    bag = [0] * length
    for i in range(length):
        for j in range(i+1, length):
            a = graph[i][j]
            b = graph[j][i]
            if a < b:
                bag[j] += 1
            elif a > b:
                bag[i] += 1
            else:
                if indices[i] < indices[j]:
                    bag[j] += 1
                elif indices[i] > indices[j]:
                    bag[i] += 1
    answer = max(bag)
    return answer