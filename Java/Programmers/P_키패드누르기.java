import java.io.BufferedReader;
import java.io.InputStreamReader;

class Position{
    int i;
    int j;
    public Position(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class P_키패드누르기 {

    public static void main(String[] args) {
	// write your code here
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = solution(numbers, hand);
        System.out.println(result);
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] phone = {{1, 2, 3},{4,5,6},{7,8,9},{10, 0, 12}};
        Position leftPos = new Position(3,0);
        Position rightPos = new Position(3, 2);
        for (int tmp = 0; tmp < numbers.length; tmp++) {
            int number = numbers[tmp];
            if(number == 1 || number == 4 || number == 7){
                leftPos.i = number / 3;
                leftPos.j = 0;
                answer += "L";
            }else if(number == 3 || number == 6 || number == 9){
                rightPos.i = number / 3 - 1;
                rightPos.j = 2;
                answer += "R";
            }
            else{
                for (int i = 0; i < phone.length; i++) {
                    boolean flag = false;
                    for (int j = 0; j < phone[i].length; j++) {
                        if(number == phone[i][j]){
                            int leftLength = Math.abs(leftPos.i - i) + Math.abs(leftPos.j - j);
                            int rightLength = Math.abs(rightPos.i - i) + Math.abs(rightPos.j - j);
                            if(leftLength < rightLength){
                                leftPos.i = i;
                                leftPos.j = j;
                                answer += "L";

                            }else if(leftLength == rightLength){
                                if(hand.equals("left")){
                                    leftPos.i = i;
                                    leftPos.j = j;
                                    answer += "L";
                                }else{
                                    rightPos.i = i;
                                    rightPos.j = j;
                                    answer += "R";
                                }
                            }else{
                                rightPos.i = i;
                                rightPos.j = j;
                                answer += "R";
                            }
                            flag = true;
                            break;
                        }
                    }
                    if(flag)
                        break;
                }
            }
        }
        return answer;
    }
}
