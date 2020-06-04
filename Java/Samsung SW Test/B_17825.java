
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Token{
    int i;
    int j;
    int depth;
    public Token(int i, int j){
        this.i = i;
        this.j = j;
    }
//
//    @Override
//    public String toString() {
//        String tmp;
//        tmp = "Token i : " + this.i + " Token j : " + this.j  + " depth : " + this.depth;
//        return tmp;
//    }
}
public class B_17825 {
    public static int[] dice = new int[10];
    static int maxScore = Integer.MIN_VALUE;
//    static ArrayList<Token> tokenArrayList1 = new ArrayList<>();
//    static ArrayList<Token> tokenArrayList2 = new ArrayList<>();
//    static ArrayList<Token> tokenArrayList3 = new ArrayList<>();
//    static ArrayList<Token> tokenArrayList4 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; ++i){
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int[][] map = {
                {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0},
                {10, 13, 16, 19},
                {20, 22, 24, 25, 30, 35},
                {30, 28, 27, 26}

        };

        Token[] tokens = new Token[4];
        int[] score = new int[4];
        for (int i = 0; i < 4; i++) {
            tokens[i] = new Token(0, 0);
            score[i] = 0;
        }
        DFS(tokens, map, score, 0);
        System.out.println(maxScore);
    }

    public static void DFS(Token[] tokens, int[][] map, int[] score, int depth){
        if(depth == 10){
            int sum = 0;
            for (int i = 0; i < 4; ++i){
                sum += score[i];
            }
            if(maxScore < sum){
                maxScore = sum;
//                System.out.println("-------------------------------------------------");
//                System.out.println("token[0] : " + tokens[0].i +" token[0] : " +tokens[0].j +" score[0] : " +score[0]);
//                System.out.println("token[1] : " + tokens[1].i +" token[1] : " +tokens[1].j +" score[1] : " +score[1]);
//                System.out.println("token[2] : " + tokens[2].i +" token[2] : " +tokens[2].j +" score[2] : " +score[2]);
//                System.out.println("token[3] : " + tokens[3].i +" token[3] : " +tokens[3].j +" score[3] : " +score[3]);
//                System.out.println("-------------------------------------------------");
//                for(int i = 0; i < tokenArrayList1.size(); ++i){
//                    System.out.println(tokenArrayList1.get(i));
//                }
//                System.out.println("-------------------------------------------------");
//                for(int i = 0; i < tokenArrayList2.size(); ++i){
//                    System.out.println(tokenArrayList2.get(i));
//                }
//                System.out.println("-------------------------------------------------");
//                for(int i = 0; i < tokenArrayList3.size(); ++i){
//                    System.out.println(tokenArrayList3.get(i));
//                }
//                System.out.println("-------------------------------------------------");
//                for(int i = 0; i < tokenArrayList4.size(); ++i){
//                    System.out.println(tokenArrayList4.get(i));
//                }
            }

            return;
        }

        int tmpI, tmpJ, prevI, prevJ;
        for(int idx = 0; idx < 4; ++idx){
            Token token = tokens[idx];// 한개씩 말을 선택...........
            tmpI = prevI = token.i;
            tmpJ = prevJ = token.j;
            if(tmpI == 0 && tmpJ == 21)//이미 도착지점에 있는거는 거르자......
                continue;
            tmpJ += dice[depth];
            while(tmpJ >= map[tmpI].length){
                int diff= tmpJ - (map[tmpI].length);
                if(tmpI == 0){
                    tmpJ = 21;
                    break;
                }
                else if(tmpI == 1){
                    tmpI = 2;
                    tmpJ = 3;
                    tmpJ += diff;
                }
                else if(tmpI == 2){
                    tmpI = 0;
                    tmpJ = 20;
                    tmpJ += diff;
                }else if(tmpI == 3){
                    tmpI = 2;
                    tmpJ = 3;
                    tmpJ += diff;
                }
            }
            if(tmpI == 0 && tmpJ == 5){
                tmpI = 1;
                tmpJ = 0;
            }else if(tmpI == 0 && tmpJ == 10){
                tmpI = 2;
                tmpJ = 0;
            }else if(tmpI == 0 && tmpJ == 15){
                tmpI = 3;
                tmpJ = 0;
            }
            boolean flag = false;
            for(int check_idx = 0; check_idx < 4; ++check_idx){
                if(check_idx != idx){
                    if(tmpI == tokens[check_idx].i && tmpJ == tokens[check_idx].j){
                        if(tmpI == 0 && tmpJ == 21){
                            continue;
                        }else{
                            flag = true;
                            break;
                        }

                    }
                }

            }
            if(flag){
                continue;
            }
            token.i = tmpI;
            token.j = tmpJ;
            score[idx] += map[token.i][token.j];
//            if(idx == 0){
//                Token token1 = new Token(tmpI, tmpJ);
//                token1.depth = depth;
//                tokenArrayList1.add(token1);
//            }
//            else if(idx == 1){
//                Token token1 = new Token(tmpI, tmpJ);
//                token1.depth = depth;
//                tokenArrayList2.add(token1);
//            }
//            else if(idx == 2){
//                Token token1 = new Token(tmpI, tmpJ);
//                token1.depth = depth;
//                tokenArrayList3.add(token1);
//            }else if(idx == 3){
//                Token token1 = new Token(tmpI, tmpJ);
//                token1.depth = depth;
//                tokenArrayList4.add(token1);
//            }
            DFS(tokens, map, score, depth + 1);
//            if(idx == 0){
//                tokenArrayList1.remove(tokenArrayList1.size() - 1);
//            }
//            else if(idx == 1){
//                tokenArrayList2.remove(tokenArrayList2.size() - 1);
//            }
//            else if(idx == 2){
//                tokenArrayList3.remove(tokenArrayList3.size() - 1);
//            }else if(idx == 3){
//                tokenArrayList4.remove(tokenArrayList4.size() - 1);
//            }
            score[idx] -= map[token.i][token.j];
            token.i = prevI;
            token.j = prevJ;
        }


    }
}
