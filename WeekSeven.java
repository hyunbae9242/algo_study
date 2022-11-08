import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Map.Entry;

public class WeekSeven {
    public static void main(String[] args) {
        //2. 괄호문자 제거
        //clearString();
        //4. 후위식 연산
        //postfix();
        //6. 공주구하기
        //savePrincess();
        //8. 응급실
        emergencyRoom();
    }

    //2. 괄호문자 제거
    public static void clearString(){
        try(Scanner s = new Scanner(System.in)){
            char[] cArray = s.nextLine().toCharArray();

            Queue<Character> q = new LinkedList<>();
            String result = "";
            for(Character c : cArray){
                if(c == '(') q.add(c);
                else if (c == ')') q.poll();
                else{
                    if(q.isEmpty()) result += c;
                }
            }
            System.out.print(result);
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

    //4. 후위식 연산
    public static void postfix(){
        try(Scanner s = new Scanner(System.in)){
            char[] cArray = s.nextLine().toCharArray();
            Stack<Integer> result = new Stack<>();
            for(char c : cArray){
                switch(c){
                    case '+' : result.add(result.pop() + result.pop());
                    break;
                    case '-' : result.add(-result.pop() + result.pop());
                    break;
                    case '*' : result.add(result.pop() * result.pop());
                    break;
                    case '/' : result.add(1/result.pop() * result.pop());
                    break;
                    default : result.add(Character.getNumericValue(c));
                    break;
                }
            }
            if(!result.isEmpty() && result.size() == 1){
                System.out.print(result.pop());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //6. 공주구하기
    public static void savePrincess(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int k = s.nextInt();

            Queue<Integer> q = new LinkedList<>();
            for(int i=1 ; i<=n ; i++){
                q.add(i);
            }
            int cnt = 1;
            while(q.size() > 1){
                if(k != cnt){
                    q.add(q.poll());
                    cnt++;
                }else if(k == cnt){
                    q.poll();
                    cnt = 1;
                }
            }
            System.out.println(q.poll());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //8. 응급실
    public static void emergencyRoom(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int m = s.nextInt();
            Queue<Integer[]> q = new LinkedList<>();
            int result = 0;
            for(int i=0 ; i<n ; i++){
                Integer[] iArray = {i,s.nextInt()};
                q.add(iArray);
            }
            while(true){
                Integer[] p = q.poll();
                boolean flag = true;
                int qSize = q.size();
                for(int i=0; i < qSize ; i++){
                    Integer[] tmp = q.poll();
                    if(tmp[1] > p[1]){
                        flag = false;
                    }
                    q.add(tmp);
                }
                if(flag){
                    result++;
                    if(p[0] == m){
                        System.out.println(result);
                        break;
                    }
                }else{
                    q.add(p);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
