import java.util.Scanner;
import java.util.Stack;

public class WeekSix {
    public static void main(String[] args) {
        //1. 올바른괄호
        correctP();
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
}
