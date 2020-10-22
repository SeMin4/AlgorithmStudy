#include <stdio.h>
#include <stdlib.h>

int N, Q;
int SIZE;
int dI[] = {-1, 0, 1, 0};
int dJ[] = {0, -1, 0, 1};
int max = 0;
typedef struct Node* NodePtr;
typedef struct Node{
    int i;
    int j;
    NodePtr next;
}Node;
NodePtr head = NULL;
NodePtr tail = NULL;
void rotate(int subSize, int** map);
void insertNode(NodePtr insert);
NodePtr makeNode(int i, int j);
int main() {
    scanf("%d %d", &N, &Q);

    SIZE = 1 << N;
    int **map = malloc(sizeof(int*)*SIZE);
    for(int i = 0; i < SIZE; ++i){
        map[i] = malloc(sizeof(int)*SIZE);
    }
    for(int i = 0; i < SIZE; ++i){
        for (int j = 0; j < SIZE; ++j) {
            scanf("%d", &map[i][j]);
        }
    }
    for(int i = 0; i < Q; ++i){
        int level;
        scanf("%d", &level);
        int subSize = 1 << level;
        rotate(subSize, map);
        for(int j = 0; j < SIZE; ++j){
            for(int k = 0; k < SIZE; ++k){
                int iceCnt = 0;
                for(int l = 0; l < 4; ++l){
                    int tmpI = j + dI[l];
                    int tmpJ = k + dJ[l];
                    if(tmpI >= 0 && tmpI < SIZE && tmpJ >= 0 && tmpJ < SIZE){
                        if(map[tmpI][tmpJ] > 0)
                            iceCnt += 1;
                    }
                }
                if(iceCnt < 3){
                    if(map[j][k] > 0){
                        NodePtr insert = makeNode(j, k);
                        insertNode(insert);
                    }
                }
            }
        }
        while (head != NULL){
            map[head->i][head->j] -= 1;
            NodePtr prev = head;
            head = head->next;
            free(prev);
        }

    }
    int sum = 0;
    int **visit = malloc(sizeof(int*)*SIZE);
    for(int i = 0; i < SIZE; ++i){
        visit[i] = malloc(sizeof(int)*SIZE);
    }
    for(int i = 0; i < SIZE; ++i){
        for(int j = 0; j < SIZE; ++j){
            visit[i][j] = 0;
        }
    }
    for(int i = 0; i < SIZE; ++i){
        for(int j = 0; j < SIZE; ++j){
            if(visit[i][j] == 0 && map[i][j] > 0){
                visit[i][j] = 1;
                sum += map[i][j];
                NodePtr insert = makeNode(i, j);
                insertNode(insert);
                int iceCnt = 1;
                while (head != NULL){
                    for(int k = 0; k < 4; ++k){
                        int tmpI = head->i + dI[k];
                        int tmpJ = head->j + dJ[k];
                        if(tmpI >= 0 && tmpI < SIZE && tmpJ >= 0 && tmpJ < SIZE){
                            if(visit[tmpI][tmpJ] == 0 && map[tmpI][tmpJ] > 0){
                                visit[tmpI][tmpJ] = 1;
                                sum += map[tmpI][tmpJ];
                                NodePtr another = makeNode(tmpI, tmpJ);
                                insertNode(another);
                                iceCnt += 1;
                            }
                        }
                    }
                    NodePtr prev = head;
                    head = head->next;
                    free(prev);
                }
                if(max < iceCnt)
                    max = iceCnt;
            }

        }
    }
    for(int i = 0; i < SIZE; ++i){
        free(visit[i]);
    }
    free(visit);
//    for(int i = 0; i < SIZE; ++i){
//        for(int j = 0; j < SIZE; ++j){
//            printf("%d ", map[i][j]);
//        }
//        printf("\n");
//    }
    printf("%d\n%d", sum, max);
    return 0;
}
void insertNode(NodePtr insert){
    if(head == NULL){
        head = insert;
        tail = insert;
    }
    else{
        tail->next = insert;
        tail = tail->next;
    }
}
NodePtr makeNode(int i, int j){
    NodePtr node = malloc(sizeof(Node));
    node->i = i;
    node->j = j;
    node->next = NULL;
    return node;
}
void rotate(int subSize, int** map){
    for(int i = 0; i < SIZE; i += subSize){
        for(int j = 0; j < SIZE; j += subSize){
            int **newSubMap = malloc(sizeof(int*)*subSize);
            for(int k = 0; k < subSize; ++k){
                newSubMap[k] = malloc(sizeof(int)*subSize);
            }
            int tmpJ = j;
            for (int l = 0; l < subSize; ++l, tmpJ++) {
                int tmpI = i + subSize - 1;
                for (int h = 0; h < subSize; ++h, tmpI--) {
                    newSubMap[l][h] = map[tmpI][tmpJ];
                }
            }
            for (int l = 0; l < subSize; ++l) {
                for (int h = 0; h < subSize; ++h) {
                    map[i + l][j + h] = newSubMap[l][h];
                }
            }
            for(int k = 0; k < subSize; ++k){
                free(newSubMap[k]);
            }
            free(newSubMap);
        }
    }
}
