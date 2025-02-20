def solution(sequence, k):
    lenS = len(sequence)
    result = 0
    for i in range(lenS-1, -1, -1):
        result += sequence[i]
        if result > k :
            result -= sequence.pop()
        if result == k:
            while sequence[i-1] == sequence[-1] and i>0:
                i-=1
                sequence.pop()
            
            return [i,len(sequence)-1]