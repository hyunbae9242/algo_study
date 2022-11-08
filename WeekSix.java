import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class WeekSix {
    public static void main(String[] args) {
        //1. 올바른괄호
        //correctP();
        //3. 크레인 인형뽑기(카카오)
        //crane();
        //5. 쇠막대기
        steelBar();
    }

    //1. 올바른괄호
    public static void correctP(){
        try(Scanner s = new Scanner(System.in)){
            char[] cArray = s.nextLine().toCharArray();
            Stack<Character> st = new Stack<>();
            boolean flag = true;
            for(char c : cArray){
                if(c == '('){
                    st.add('(');
                }else{
                    if(st.size() <= 0){
                        System.out.println("NO");
                        flag = false;
                        break;
                    }else{
                        st.pop();
                    }
                }
            }
            if(flag){
                if(st.size() == 0){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //3. 크레인 인형뽑기(카카오)
    public static void crane(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            List<Stack<Integer>> sList = new ArrayList<>();
            int[][] iArray = new int[n][n];
            for(int i=0 ; i<n ; i++){
                for(int j=0; j<n ; j++){
                    iArray[j][i] = s.nextInt();
                }
            }
            for(int j=0; j<n ; j++){
                Stack<Integer> tmp = new Stack<>();
                for(int i=n-1 ; i>=0 ; i--){
                    tmp.add(iArray[j][i]);
                }
                sList.add(tmp);
            }
            int[] mArray = new int[s.nextInt()];
            for(int i=0; i<mArray.length ; i++){
                mArray[i] = s.nextInt();
            }
            int result = 0;
            Stack<Integer> basket = new Stack<>();
            for(int i : mArray){
                Stack<Integer> iStack = sList.get(i-1);
                while(iStack.size() >0){
                    Integer nowInt = iStack.pop();
                    if(nowInt != 0){
                        if(!basket.isEmpty()){
                            if(basket.peek() == nowInt){
                                basket.pop();
                                result += 2;
                            }else{
                                basket.add(nowInt);
                            }
                        }else{
                            basket.add(nowInt);
                        }
                        break;
                    }
                }
                while(iStack.size() < n){
                    iStack.add(0);
                }
            }
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //5. 쇠막대기
    public static void steelBar(){
        try(Scanner s = new Scanner(System.in)){
            char[] cArray = s.nextLine().toCharArray();
            Stack<Character> st = new Stack<>();
            int result = 0;
            for(int i=0; i<cArray.length ; i++){
                char tmp = cArray[i];
                if(tmp == '('){
                    st.add('(');
                }else{
                    if(i>0){
                        if(cArray[i-1] == '('){
                            st.pop();
                            result += st.size();
                        }else{
                            st.pop();
                            result += 1;
                        }
                    }
                }
            }
            System.out.println(result);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //7. 수업계획
    public static void studyPlan(){
        try(Scanner s = new Scanner(System.in)){
            char[] nArray = s.nextLine().toCharArray();
            char[] mArray = s.nextLine().toCharArray();
            Queue<Character> q = new LinkedList<>();
            for(char n : nArray){
                q.add(n);
            }
            for(char m : mArray){
                if(!q.isEmpty() && q.peek() == m) q.poll();
            }
            String result = "NO";
            if(q.size() == 0) result = "YES";
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
