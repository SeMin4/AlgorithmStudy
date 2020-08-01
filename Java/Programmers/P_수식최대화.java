import java.sql.PreparedStatement;
import java.util.ArrayList;

public class P_수식최대화 {

    public static void main(String[] args) {
	// write your code here
        String expression = "100-200*300-500+20";
        long result = solution(expression);
        System.out.println(result);
    }
    public static long solution(String expression) {
        long answer = 0;
        String[][] list = {{"-","+","*"},{"-","*","+"},{"+","-","*"},{"+","*","-"},{"*","+","-"},{"*","-","+"}};
        ArrayList<String> arrayList = new ArrayList<>();
        int start_idx = 0;
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                arrayList.add(expression.substring(start_idx,i));
                arrayList.add(Character.toString(expression.charAt(i)));
                start_idx = i + 1;
            }
        }
        arrayList.add(expression.substring(start_idx));

        for (int i = 0; i < 6; i++) {
            answer = Math.max(answer, Math.abs(Calculate(arrayList, list[i])));
        }
        return answer;
    }
    public static long Calculate(ArrayList<String> arrayList, String[] priority){
        ArrayList<String> tmpList = new ArrayList<>();
        tmpList.addAll(arrayList);
        for (int i = 0; i < tmpList.size(); i++) {
            String string = tmpList.get(i);
            if(string.equals(priority[0])){
                long tmp1 = Long.parseLong(tmpList.get(i - 1));
                long tmp2 = Long.parseLong(tmpList.get(i + 1));
                long result = 0;
                if(priority[0].equals("+")){
                    result = tmp1 + tmp2;
                }else if(priority[0].equals("*")){
                    result = tmp1 * tmp2;
                }else{
                    result = tmp1 - tmp2;
                }
                tmpList.set(i - 1, Long.toString(result));
                tmpList.remove(i);
                tmpList.remove(i);
                i--;
            }
        }
        for (int i = 0; i < tmpList.size(); i++) {
            String string = tmpList.get(i);
            if(string.equals(priority[1])){
                long tmp1 = Long.parseLong(tmpList.get(i - 1));
                long tmp2 = Long.parseLong(tmpList.get(i + 1));
                long result = 0;
                if(priority[1].equals("+")){
                    result = tmp1 + tmp2;
                }else if(priority[1].equals("*")){
                    result = tmp1 * tmp2;
                }else{
                    result = tmp1 - tmp2;
                }
                tmpList.set(i - 1, Long.toString(result));
                tmpList.remove(i);
                tmpList.remove(i);
                i--;
            }
        }
        for (int i = 0; i < tmpList.size(); i++) {
            String string = tmpList.get(i);
            if(string.equals(priority[2])){
                long tmp1 = Long.parseLong(tmpList.get(i - 1));
                long tmp2 = Long.parseLong(tmpList.get(i + 1));
                long result = 0;
                if(priority[2].equals("+")){
                    result = tmp1 + tmp2;
                }else if(priority[2].equals("*")){
                    result = tmp1 * tmp2;
                }else{
                    result = tmp1 - tmp2;
                }
                tmpList.set(i - 1, Long.toString(result));
                tmpList.remove(i);
                tmpList.remove(i);
                i--;
            }
        }
        return Long.parseLong(tmpList.get(0));
    }

}
