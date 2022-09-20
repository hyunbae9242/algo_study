import java.util.Scanner;

public class WeekOne {


    public static void main(String[] args) {
        //1.string(문자 찾기)
        //countChar();

        //2.string(대소문자 변환)
        //changeCase();

        //3.string(문장 속 단어)
        //findLongestWord();

        //4.string(단어 뒤집기)
        //reverseWord();
    }

    public static void countChar(){
        try (Scanner s = new Scanner(System.in)) {
            String str = s.nextLine();
            String findChar = s.next();
            int count = 0;
            for(String strChar : str.split("")){
                if(strChar.equalsIgnoreCase(findChar)){
                    count++;
                }
            }
            System.out.println("count : " + count);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void changeCase(){
        try (Scanner s = new Scanner(System.in)) {
            String str = s.nextLine();
            String returnStr = "";
            for(char c : str.toCharArray()){
                if(c >= 65 && c <= 90){
                    returnStr += String.valueOf(Character.toLowerCase(c));
                } else if (c >= 97 && c <= 122) {
                    returnStr += String.valueOf(Character.toUpperCase(c));
                } else {
                    returnStr += String.valueOf(c);
                }
            }
            System.out.println("result : " + returnStr);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void findLongestWord(){
        try(Scanner s = new Scanner(System.in)){
            String str = s.nextLine();
            String longestWord = "";
            for(String word : str.split(" ")){
                if(longestWord.length() < word.length()){
                    longestWord = word;
                }
            }
            System.out.println("longest word : " + longestWord);
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

    public static void reverseWord(){
        try(Scanner s = new Scanner(System.in)){
            int length = s.nextInt();
            String[] strArray = new String[length];
            for(int i = 0 ; i < length ; i++){
                strArray[i] = "";
                String inStr = s.next();
                String[] str = inStr.split("");
                if(inStr.length() > 0){
                    for(int j = 0 ; j < str.length ; j++){
                        strArray[i] += str[str.length-1-j];
                    }
                }
            }
            for(String str : strArray){
                System.out.println(str);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
