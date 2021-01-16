from collections import deque


def dfs (visit, V, graph):
    print(V, end = " ")
    for v in graph[V]:
        if not visit[v]:
            visit[v] = True
            dfs(visit, v, graph)

def bfs(visit, V, graph):
    queue = deque()
    queue.append(V)
    visit[V] = True
    while queue:
        v = queue.popleft()
        print(v, end = " ")
        for i in graph[v]:
            if not visit[i] : 
                visit[i] = True
                queue.append(i)


N, M, V = map(int,input().split(" "))
graph = [ [] for _ in range(N + 1)]
visit = [False] * (N + 1)
for _ in range(M):
    V1, V2 = map(int, input().split(" "))
    graph[V1].append(V2)
    graph[V2].append(V1)


for i in range(1, N + 1):
    graph[i].sort()

visit[V] = True
dfs(visit, V, graph)
print()
visit = [False] * (N + 1)

bfs(visit, V, graph)
