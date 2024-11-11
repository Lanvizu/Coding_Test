import sys
input = sys.stdin.readline

input_str = input().rstrip()
target = input().rstrip()

def remove_target(input_str, target):
    stack = []
    target_length = len(target)

    for char in input_str:
        stack.append(char)
        if len(stack) >= target_length and ''.join(stack[-target_length:]) == target:
            del stack[-target_length:]
    return ''.join(stack) if stack else 'FRULA'

result = remove_target(input_str, target)
print(result)