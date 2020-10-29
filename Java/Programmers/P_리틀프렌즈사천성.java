import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Position implements Comparable<Position>{
    int i;
    int j;
    public Position(int i, int j){
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Position o) {
        if(this.i < o.i) return -1;
        else if(this.i == o.i){
            if(this.j < o.j) return -1;
            else if(this.j == o.j) return 0;
            else return 1;
        }
        else return 1;
    }
}
class Solution {

    public static String solution(int m, int n, String[] board) {
        StringBuilder sb  = new StringBuilder();
        ArrayList<Position>[] pos = new ArrayList[26];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = new ArrayList<>();
        }
        char[][] boards = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boards[i][j] = board[i].charAt(j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(boards[i][j] >= 'A' && boards[i][j] <= 'Z'){
                    pos[boards[i][j] - 'A'].add(new Position(i, j));
                }
            }
        }
        while (true) {
            boolean flag = false;
            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                if (pos[i].size() == 0) {
                    cnt += 1;
                    continue;
                }
                char result = deleteChar(boards, m, n, pos[i]);
                if (result != 'a') {
                    sb.append(result);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (cnt == 26) {
                    break;
                }
                sb = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }
        return sb.toString();
    }
    public static char deleteChar(char[][] board, int m, int n, ArrayList<Position> list){
        int tmpI1 = list.get(0).i;
        int tmpJ1 = list.get(0).j;
        int tmpI2 = list.get(1).i;
        int tmpJ2 = list.get(1).j;
        if(board[tmpI1][tmpJ2] == '.' || board[tmpI2][tmpJ1] =='.') {//둘다 비어 있다! 그럼 가는 길을 검사 하자.
            Collections.sort(list, new Comparator<Position>() {
                @Override
                public int compare(Position o1, Position o2) {
                    if(o1.j < o2.j) return -1;
                    else if(o1.j == o2.j) return 0;
                    else return 1;
                }
            });
            boolean flag = false;
            for (int j = list.get(0).j + 1; j <= list.get(1).j; j++) {
                if(board[list.get(0).i][j] != '.'){//애초부터 이길로는 못지움..
                    flag = true;
                    break;
                }
            }
            if(!flag){
                if(list.get(0).i > list.get(1).i){
                    for (int i = list.get(1).i + 1; i <= list.get(0).i ; i++) {
                        if(board[i][list.get(1).j] != '.'){
                            flag = true;
                            break;
                        }
                    }
                }
                else{
                    for (int i = list.get(1).i - 1; i >= list.get(0).i ; i--) {
                        if(board[i][list.get(1).j] != '.'){
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag){
                    char ret = board[tmpI1][tmpJ1];
                    board[tmpI1][tmpJ1] = '.';
                    board[tmpI2][tmpJ2] = '.';
                    list.clear();
                    return ret;
                }
            }
            flag = false;
            for (int j = list.get(1).j - 1; j >= list.get(0).j; j--) {
                if(board[list.get(1).i][j] != '.'){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                if(list.get(0).i < list.get(1).i){
                    for (int i = list.get(0).i + 1; i <= list.get(1).i ; i++) {
                        if(board[i][list.get(0).j] != '.'){
                            return 'a';
                        }
                    }
                }
                else{
                    for (int i = list.get(0).i - 1; i >= list.get(1).i ; i--) {
                        if(board[i][list.get(0).j] != '.'){
                            return 'a';
                        }
                    }
                }
                char ret = board[tmpI1][tmpJ1];
                board[tmpI1][tmpJ1] = '.';
                board[tmpI2][tmpJ2] = '.';
                list.clear();
                return ret;
            }
        }
        else{
            if(board[tmpI1][tmpJ2] == board[tmpI2][tmpJ1]){//애초부터 1자..
                if(tmpI1 == tmpI2){
                    Collections.sort(list, new Comparator<Position>() {
                        @Override
                        public int compare(Position o1, Position o2) {
                            if(o1.j < o2.j) return -1;
                            else if(o1.j == o2.j) return 0;
                            else return 1;
                        }
                    });
                    for (int j = list.get(0).j + 1; j < list.get(1).j; j++) {
                        if(board[tmpI1][j] != '.'){
                            return 'a';
                        }
                    }
                    char ret = board[tmpI1][tmpJ1];
                    board[tmpI1][tmpJ1] = '.';
                    board[tmpI2][tmpJ2] = '.';
                    list.clear();
                    return ret;
                }else if(tmpJ1 == tmpJ2){
                    Collections.sort(list, new Comparator<Position>() {
                        @Override
                        public int compare(Position o1, Position o2) {
                            if(o1.i < o2.i) return -1;
                            else if(o1.i == o2.i) return 0;
                            else return 1;
                        }
                    });
                    for (int i = list.get(0).i + 1; i < list.get(1).i; i++) {
                        if(board[i][tmpJ1] != '.'){
                            return 'a';
                        }
                    }
                    char ret = board[tmpI1][tmpJ1];
                    board[tmpI1][tmpJ1] = '.';
                    board[tmpI2][tmpJ2] = '.';
                    list.clear();
                    return ret;
                }
                else{
                    return 'a';
                }
            }
            else{
                return 'a';
            }
        }
        return 'a';
    }
}
