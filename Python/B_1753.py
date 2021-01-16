import heapq
import sys

V, E = map(int, sys.stdin.readline().split(" "))
S = int(input())
INF = 30000000
graph = [[] for _ in range(V + 1)]
for _ in range(E):
    V1, V2, cost = map(int, sys.stdin.readline().split(" "))
    graph[V1].append((V2,cost))


distance = [INF] * (V + 1)
visit = [False] * (V + 1)
distance[S] = 0
# visit[S] = True
pq = []
heapq.heappush(pq, (distance[S], S))

while pq:
    dist, v = heapq.heappop(pq)
    if(visit[v] == True):
        continue
    visit[v] = True
    for vertex, cost in graph[v]:
        if(not visit[vertex] and distance[vertex] > dist + cost):
            distance[vertex] = dist + cost
            heapq.heappush(pq, (distance[vertex], vertex))


for i in range(1, V + 1):
    if(distance[i] == INF) :
        print('INF')
    else :
        print(distance[i])