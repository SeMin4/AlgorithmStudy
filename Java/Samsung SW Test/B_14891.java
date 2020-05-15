import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SawTooth{
   int a;
   int b;
   int c;
   int d;
   int e;
   int f;
   int g;
   int h;
   //N극 = 0 S극 = 1
   public SawTooth(String str){
       this.c = str.charAt(0) - '0';
       this.d = str.charAt(1) - '0';
       this.e = str.charAt(2) - '0';
       this.f = str.charAt(3) - '0';
       this.g = str.charAt(4) - '0';
       this.h = str.charAt(5) - '0';
       this.a = str.charAt(6) - '0';
       this.b = str.charAt(7) - '0';
    }
    public boolean clockWise(){
        int tmp;
        tmp = this.a;
        this.a = this.h;
        this.h = this.g;
        this.g = this.f;
        this.f = this.e;
        this.e = this.d;
        this.d = this.c;
        this.c = this.b;
        this.b = tmp;
        return true;
    }
    public boolean counterClockWise(){
       int tmp;
       tmp = this.a;
       this.a = this.b;
       this.b = this.c;
       this.c = this.d;
       this.d = this.e;
       this.e = this.f;
       this.f = this.g;
       this.g = this.h;
       this.h = tmp;
       return false;
    }
}
public class B_14891 {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        SawTooth[] sawTooths = new SawTooth[4];
        for(int i = 0; i < 4; ++i){
            str = br.readLine();
            sawTooths[i] = new SawTooth(str);
        }
        int command = Integer.parseInt(br.readLine());
        int[] index = new int[command];
        int[] commands = new int[command];
        for(int i = 0; i < command; ++i){
            String[] strTmp = br.readLine().split(" ");
            index[i] = Integer.parseInt(strTmp[0]) - 1;
            commands[i] = Integer.parseInt(strTmp[1]);
        }
        boolean[] relation = new boolean[3];
        makeRelation(relation, sawTooths);
        for(int i = 0; i < commands.length; ++i){
            boolean flag;
            if(commands[i] == 1){
                flag = sawTooths[index[i]].clockWise();
            }else{
                flag = sawTooths[index[i]].counterClockWise();
            }
            restTry(sawTooths, index[i], flag, relation);//flag true 면 시계방향 false 면 반시계방향
        }
        int score= 0;
        for(int i = 1, j = 1; i <= 4; ++i, j *= 2){
            if(sawTooths[i - 1].c == 1){
                score = score + j;
            }
        }
        System.out.println(score);
    }
    public static void makeRelation(boolean[] relation, SawTooth[] sawTooths){
        for(int i = 0; i < 3; ++i){
            if(sawTooths[i].e == sawTooths[i + 1].a){
                relation[i] = true;
            }
            else{
                relation[i] = false;
            }
        }
    }
    public static void restTry(SawTooth[] sawTooths, int pos, boolean prevRotate, boolean[] relation){
        int left = pos - 1;
        int right = pos;
        boolean originalRotate = prevRotate;
        for(int i = left; i >=0; --i){
            if(!relation[i]){//서로 다르면
                if(!prevRotate){
                    prevRotate = sawTooths[i].clockWise();
                }else{
                    prevRotate = sawTooths[i].counterClockWise();
                }
            }else{
                break;
            }
        }
        prevRotate = originalRotate;
        for(int i = right; i < 3; ++i){
            if(!relation[i]){
                if(!prevRotate){
                    prevRotate = sawTooths[i + 1].clockWise();
                }else{
                    prevRotate = sawTooths[i + 1].counterClockWise();
                }
            }else{
                break;
            }
        }
        makeRelation(relation, sawTooths);

    }
}
