import sys
from itertools import permutations
input = sys.stdin.readline

N, M, K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
rcs = [list(map(int, input().split())) for _ in range(K)]

def rotate_once(r, c, s, matrix):
    result = [row[:] for row in matrix]
    r -= 1
    c -= 1
    for layer in range(1, s + 1):
        top_left = (r - layer, c - layer)
        top_right = (r - layer, c + layer)
        bottom_left = (r + layer, c - layer)
        bottom_right = (r + layer, c + layer)

        # Top row
        for i in range(top_left[1], top_right[1]):
            result[top_left[0]][i + 1] = matrix[top_left[0]][i]
        
        # Right column
        for i in range(top_right[0], bottom_right[0]):
            result[i + 1][top_right[1]] = matrix[i][top_right[1]]
        
        # Bottom row
        for i in range(bottom_right[1], bottom_left[1], -1):
            result[bottom_right[0]][i - 1] = matrix[bottom_right[0]][i]
        
        # Left column
        for i in range(bottom_left[0], top_left[0], -1):
            result[i - 1][bottom_left[1]] = matrix[i][bottom_left[1]]

    return result

def calculate_min_value(matrix):
    return min(sum(row) for row in matrix)

min_result = float('inf')
for perm in permutations(rcs):
    current_matrix = [row[:] for row in graph]
    for rcs_item in perm:
        current_matrix = rotate_once(*rcs_item, current_matrix)
    min_result = min(min_result, calculate_min_value(current_matrix))

print(min_result)