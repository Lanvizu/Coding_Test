import sys
sys.setrecursionlimit(10**6)

def solution(nodeinfo):
    answer = [[],[]]
    nodeinfo=[[i+1]+node for i,node in enumerate(nodeinfo)]
    nodeinfo.sort(key=lambda x:(-x[2],x[1]))
    
    calc(nodeinfo[0], nodeinfo, answer[0], answer[1])
    return answer

def calc(node, subtree, ans1, ans2):
    ans1.append(node[0])
    
    L_subtree = []
    R_subtree = []
    for s in subtree:
        if node[1] > s[1] and node[2] > s[2]:
            L_subtree.append(s)
        if node[1] < s[1] and node[2] > s[2]:
            R_subtree.append(s)
    if L_subtree != []:
        calc(L_subtree[0], L_subtree, ans1, ans2)
    if R_subtree != []:
        calc(R_subtree[0], R_subtree, ans1, ans2)
        
    ans2.append(node[0])
