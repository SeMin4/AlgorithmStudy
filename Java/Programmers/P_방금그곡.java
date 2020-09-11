import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
class Music implements Comparable<Music>{
    int idx;
    int start;
    int end;
    int length;
    String name;
    String melody;
    String fullMelody;
    public Music(int idx, int start, int end, String name, String melody){
        this.idx = idx;
        this.start = start;
        this.end = end;
        this.length = this.end - this.start;
        this.name = name;
        this.melody = melody;
        int q = this.length / this.melody.length() ; //반복되는 횟수
        int mod = this.length % this.melody.length(); //남은거
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(this.melody);
        }
        sb.append(this.melody, 0, mod);
        this.fullMelody = sb.toString();
    }

    @Override
    public int compareTo(Music o) {
        if(this.length > o.length)
            return -1;
        else if(this.length == o.length){
            if(this.idx < o.idx)
                return -1;
            else if(this.idx == o.idx)
                return 0;
            else 
                return 1;
        }
        else 
            return 1;
    }
}
public class P_방금그곡 {
    static final String[] arr = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    static final String[] arr2 = {"C", "H", "D", "I", "E", "F", "J", "G", "K", "A", "L", "B"};
    public static void main(String[] args) {
	// write your code here
        String m = "ABCDEFG";
        String[] musicinofs = {"12:00,12:15,HELLO,CDEFGAB","13:00,13:05,WORLD,ABCDEF"};
        String answer = solution(m, musicinofs);
        System.out.println(answer);

    }
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        ArrayList<Music> list = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
            int hours = Integer.parseInt(st2.nextToken()) * 60;
            int minutes = Integer.parseInt(st2.nextToken());
            int start_time = hours + minutes;
            st2 = new StringTokenizer(st.nextToken(), ":");
            hours = Integer.parseInt(st2.nextToken()) * 60;
            minutes = Integer.parseInt(st2.nextToken());
            int end_time = hours + minutes;
            String name = st.nextToken();
            String melody = changeMelody(st.nextToken());
            list.add(new Music(i, start_time, end_time, name, melody));
        }
        Collections.sort(list);
        m = changeMelody(m);
        for (int i = 0; i < list.size(); i++) {
            Music music = list.get(i);
            int pos = music.fullMelody.indexOf(m);
            if(pos != -1)
                return music.name;
        }
        return answer;
    }
    public static String changeMelody(String melody){
        StringBuilder sb = new StringBuilder(melody);
        for (int j = 0; j < sb.length(); j++) {
            if(sb.charAt(j) == '#'){
                if(sb.charAt(j - 1) == 'C'){
                    sb.replace(j - 1, j + 1, "H");
                }
                else if(sb.charAt(j - 1) == 'D'){
                    sb.replace(j - 1, j + 1, "I");
                }else if(sb.charAt(j - 1) == 'F'){
                    sb.replace(j - 1, j + 1, "J");
                }else if(sb.charAt(j - 1) == 'G'){
                    sb.replace(j - 1, j + 1, "K");
                }else if(sb.charAt(j - 1) == 'A'){
                    sb.replace(j - 1, j + 1, "L");
                }

            }
        }
        return sb.toString();
    }
}
