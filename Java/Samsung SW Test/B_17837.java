
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
class Horse{
    int i;
    int j;
    int direction;//1 right 2 left 3 up 4 down
    public Horse(int i, int j, int direction){
        this.i = i;
        this.j = j;
        this.direction = direction;
    }
}
class Map{
    int type;
    ArrayList<Horse> horses;
    public Map(int type){
        this.type = type;
        horses = new ArrayList<>();
    }
}
public class B_17837 {
    static int N, K;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map[][] maps = new Map[N + 2][N + 2];
        for(int i = 0; i < N + 2; ++i){
            for(int j = 0; j < N + 2; ++j){
                maps[i][j] = new Map(2);
            }
        }
        for(int i = 1; i <= N; ++i){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N ; j++) {
                maps[i][j].type = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Horse> horseArrayList = new ArrayList<>();
        for(int i = 0; i < K; ++i){
            st = new StringTokenizer(br.readLine());
            Horse horse = new Horse(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            horseArrayList.add(horse);
            maps[horse.i][horse.j].horses.add(horse);
        }
        boolean flag = false;

        int i;
        for(i = 1; i <= 1000; ++i){
            for(int j = 0; j < horseArrayList.size(); ++j){
                Horse horse = horseArrayList.get(j);
                int tmpI = horse.i;
                int tmpJ = horse.j;
                if(horse.direction == 1){
                    tmpJ += 1;
                }else if(horse.direction == 2){
                    tmpJ -= 1;
                }else if(horse.direction == 3){
                    tmpI -= 1;
                }else if(horse.direction == 4){
                    tmpI += 1;
                }
                if(maps[tmpI][tmpJ].type == 2){
                    if(horse.direction == 1){
                        if(!flag)
                            horse.direction = 2;
                    }else if(horse.direction == 2){
                        if(!flag)
                            horse.direction = 1;
                    }else if(horse.direction == 3){
                        if(!flag)
                            horse.direction = 4;
                    }else if(horse.direction == 4){
                        if(!flag)
                            horse.direction = 3;
                    }
                    if(!flag){
                        flag = true;
                        --j;
                    }else{
                        flag = false;
                    }
                }
                else if(maps[tmpI][tmpJ].type == 1){
                    flag = false;
                    ArrayList<Horse> addHorseList = new ArrayList<>();
                    for(int k = 0; k < maps[horse.i][horse.j].horses.size(); ++k){
                        Horse checkHorse = maps[horse.i][horse.j].horses.get(k);
                        if(checkHorse.equals(horse)){
                            int tI = horse.i;
                            int tJ = horse.j;
                            for(;k < maps[tI][tJ].horses.size(); ++k){
                                Horse addHorse = maps[tI][tJ].horses.get(k);
                                addHorse.i = tmpI;
                                addHorse.j = tmpJ;
                                addHorseList.add(addHorse);
                                maps[tI][tJ].horses.remove(k);
                                --k;
                            }
                            break;
                        }
                    }
                    Collections.reverse(addHorseList);
                    maps[tmpI][tmpJ].horses.addAll(addHorseList);
                    if(maps[tmpI][tmpJ].horses.size() >= 4){
                        System.out.println(i);
                        return;
                    }
                }else if(maps[tmpI][tmpJ].type == 0){
                    flag = false;
                    ArrayList<Horse> addHorseList = new ArrayList<>();
                    for(int k = 0; k < maps[horse.i][horse.j].horses.size(); ++k){
                        Horse checkHorse = maps[horse.i][horse.j].horses.get(k);
                        if(checkHorse.equals(horse)){
                            int tI = horse.i;
                            int tJ = horse.j;
                            for(;k < maps[tI][tJ].horses.size(); ++k){
                                Horse addHorse = maps[tI][tJ].horses.get(k);
                                addHorse.i = tmpI;
                                addHorse.j = tmpJ;
                                addHorseList.add(addHorse);
                                maps[tI][tJ].horses.remove(k);
                                --k;
                            }
                            break;
                        }
                    }
                    maps[tmpI][tmpJ].horses.addAll(addHorseList);
                    if(maps[tmpI][tmpJ].horses.size() >= 4){
                        System.out.println(i);
                        return;
                    }
                }

            }

        }
        if(i == 1001){
            System.out.println(-1);
        }
    }
}
