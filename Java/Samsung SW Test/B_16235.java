package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tree {
    int i;
    int j;
    int years;
    public Tree(int i, int j, int years){
        this.i = i;
        this.j = j;
        this.years = years;
    }
}
public class B_16235{
    static int N, M, K;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {0 , -1 , 1, -1 , 1, -1 ,0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 2][N + 2];
        for(int i = 0; i < N + 2; ++i){
            Arrays.fill(map[i], -1);
        }
        for(int i = 1; i <= N; ++i){
            for(int j = 1; j <=N; ++j){
                map[i][j] = 5;
            }
        }
        int[][] add_arc = new int[N + 1][N + 1];
        for(int i = 1; i <= N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; ++j){
                add_arc[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Deque<Tree> treeArrayList = new LinkedList<>();
        for(int i = 0; i < M; ++i){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            Tree tree = new Tree(r,c,year);
            treeArrayList.add(tree);
        }
//        Collections.sort(treeArrayList);
        for(int cnt = 0; cnt < K; ++cnt){
            Queue<Tree> deleteList = new LinkedList<>();
            Queue<Tree> addList = new LinkedList<>();
            for(Iterator<Tree> iterator = treeArrayList.iterator(); iterator.hasNext();){//봄
                Tree tree = iterator.next();
                if(map[tree.i][tree.j] - tree.years >= 0){
                    map[tree.i][tree.j] -= tree.years;
                    tree.years += 1;
                    if(tree.years % 5 == 0){
                        addList.add(tree);
                    }
                }else{
                    deleteList.add(tree);//지우기
                    iterator.remove();
                }
            }
            while(!deleteList.isEmpty()){//여름
                Tree  tree = deleteList.poll();
                map[tree.i][tree.j] += (tree.years / 2);
            }


            while(!addList.isEmpty()){//가을
                Tree tree = addList.poll();
                for(int eight = 0; eight < 8; ++eight){
                    int xtmp = tree.i + dx[eight];
                    int ytmp = tree.j + dy[eight];
                    if(map[xtmp][ytmp] != -1){
                        treeArrayList.addFirst(new Tree(xtmp, ytmp, 1));
//                        treeArrayList.add(new Tree(xtmp, ytmp, 1));
                    }
                }
            }
            for(int i = 1; i <= N; ++i){//겨울
                for(int j = 1; j <= N; ++j){
                    map[i][j] += add_arc[i][j];
                }
            }
        }
        System.out.println(treeArrayList.size());
    }

//    public static void addTree(Tree tree, ArrayList<Tree> treeArrayList){
//        if(tree.i - 1 > 0){
//            treeArrayList.add(new Tree(tree.i - 1, tree.j , 1));
//        }
//        if(tree.i - 1 > 0 && tree.j - 1 > 0){
//            treeArrayList.add(new Tree(tree.i - 1, tree.j - 1 , 1));
//        }
//        if(tree.i - 1 > 0 && tree.j + 1 < N + 1){
//            treeArrayList.add( new Tree(tree.i - 1, tree.j + 1 , 1));
//        }
//        if(tree.j - 1 > 0){
//            treeArrayList.add(new Tree(tree.i, tree.j - 1, 1));
//        }
//        if(tree.j + 1 < N + 1){
//            treeArrayList.add( new Tree(tree.i, tree.j + 1, 1));
//        }
//        if(tree.i + 1 < N + 1 && tree.j -1 > 0){
//            treeArrayList.add( new Tree(tree.i + 1, tree.j - 1 , 1));
//        }
//        if(tree.i + 1 < N + 1){
//            treeArrayList.add(new Tree(tree.i + 1, tree.j , 1));
//        }
//        if(tree.i + 1 < N + 1 && tree.j + 1 < N + 1){
//            treeArrayList.add( new Tree(tree.i + 1, tree.j + 1, 1));
//        }
//    }
}
