import heapq
def solution(scoville, K):
    heap = []
    for i in range(len(scoville)):
        heapq.heappush(heap, scoville[i])
    
    answer = 0
    while heap[0] < K:
        if len(heap) == 1:
            answer = -1
            break
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        heapq.heappush(heap, a+b*2)
        answer += 1
        
    return answer