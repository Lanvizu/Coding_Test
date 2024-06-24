def solution(numbers):
    
    numbers = [str(num) for num in numbers]
    numbers.sort(key=lambda x:x*9, reverse =True)
    if numbers[0] == "0":
        answer = "0"
    else:
        answer = (''.join(numbers))
    
    return answer