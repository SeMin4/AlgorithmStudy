from collections import deque
from copy import deepcopy
maxValue = -1
dI = [0, -1, -1, 0, 1, 1, 1, 0, -1]
dJ = [0, 0, -1, -1, -1, 0, 1, 1, 1]
# fish.append([line[j * 2], line[j * 2 + 1], i, j])
def moveFish(fish, arr):
    newarr = deepcopy(arr)
    print(newarr)
    for i in range(len(fish)):
        flag = False
        for _ in range(fish[i][1], 9):
            tmpI = fish[i][2] + dI[fish[i][1]]
            tmpJ = fish[i][3] + dJ[fish[i][1]]
            if(0 <= tmpI < 4 and 0 <= tmpJ < 4):
                print(newarr[tmpI][tmpJ][0])
                if(newarr[tmpI][tmpJ][0] == 100): 
                    continue
                else:
                    newarr[tmpI][tmpJ][0], newarr[fish[i][2]][fish[i][3]][0] = newarr[fish[i][2]][fish[i][3]][0],  newarr[tmpI][tmpJ][0]
                    newarr[tmpI][tmpJ][1], newarr[fish[i][2]][fish[i][3]][1] = newarr[fish[i][2]][fish[i][3]][1],  newarr[tmpI][tmpJ][1]
                    flag = True
                    break

        if not flag:
            for _ in range(fish[i][1]):
                tmpI = fish[i][2] + dI[fish[i][1]]
                tmpJ = fish[i][3] + dJ[fish[i][1]]
                if(0 <= tmpI < 4 and 0 <= tmpJ < 4):
                    if(newarr[tmpI][tmpJ][0] == 100): 
                        continue
                    else:
                        newarr[tmpI][tmpJ][0], newarr[fish[i][2]][fish[i][3]][0] = newarr[fish[i][2]][fish[i][3]][0],  newarr[tmpI][tmpJ][0]
                        newarr[tmpI][tmpJ][1], newarr[fish[i][2]][fish[i][3]][1] = newarr[fish[i][2]][fish[i][3]][1],  newarr[tmpI][tmpJ][1]
                        flag = True
                        break
    return newarr




def moveShark(fish, arr, shark):
    global maxValue
    global dI
    global dJ
    maxValue = max(maxValue, shark[2])
    arr = moveFish(fish, arr)
    tmpI = shark[0]
    tmpJ = shark[1]
    while True:
        tmpI += dI[shark[3]]
        tmpJ += dJ[shark[3]]
        if(0 <= tmpI < 4 and 0 <= tmpJ < 4):
            if (arr[tmpI][tmpJ][0] == 0): continue
            num = arr[tmpI][tmpJ][0]
            direction = arr[tmpI][tmpJ][1]
            newShark = [tmpI, tmpJ, shark[2] + num, direction]
            idx = 0
            popfish = []
            for i in range (len(fish)):
                if fish[i][0] == arr[0][0][0] :
                    popfish = fish.pop(i)
                    idx = i
                    break
            arr[tmpI][tmpJ][0] = 100
            arr[tmpI][tmpJ][1] = 0
            arr[shark[0]][shark[1]] = 0
            moveShark(fish, arr, newShark)
            fish.append(idx, popfish)
            arr[tmpI][tmpJ][0] = num
            arr[tmpI][tmpJ][1] = direction
            arr[shark[0]][shark[1]] = 100
        else:
            break


arr = [[None] * 4 for _ in range(4)]
fish = []

for i in range(4):
    line = list(map(int, input().split(" ")))
    for j in range(4):
        arr[i][j] = [line[j * 2], line[j * 2 + 1]]
        fish.append([line[j * 2], line[j * 2 + 1], i, j])

fish.sort(key=lambda x:(x[0]))
shark = [0, 0, arr[0][0][0], arr[0][0][1]]
for i in range (len(fish)):
    if fish[i][0] == arr[0][0][0] :
        fish.pop(i)
        break

arr[0][0][0] = 100
arr[0][0][1] = 0
moveShark(fish, arr, shark)
print(maxValue)
# print(fish)
