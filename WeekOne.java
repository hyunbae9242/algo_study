
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeekOne {


    public static void main(String[] args) {
        //1.string(문자 찾기)
        //countChar();

        //2.string(대소문자 변환)
        changeCase();

        //3.string(문장 속 단어)
        //findLongestWord();

        //4.string(단어 뒤집기)
        //reverseWord();

        //5.string(특정 문자 뒤집기)
        //reverseOnlyEn();

        //6.string(중복문자제거)
        //deduplication();

        //7.string(회문 문자열)
        //isPalindrome();

        //8.string(유효한 팰린드롬)
        
    }

    public static void countChar(){
        try (Scanner s = new Scanner(System.in)) {
            String str = s.nextLine();
            String findChar = s.next();
            long count = str.chars().filter(val ->  val == findChar.charAt(0)).count();
            // for(String strChar : str.split("")){
            //     if(strChar.equalsIgnoreCase(findChar)){
            //         count++;
            //     }
            // }
            System.out.println("count : " + count);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void changeCase(){
        try (Scanner s = new Scanner(System.in)) {
            String str = s.nextLine();
            String returnStr = "";
            // str.chars()
            //         .map(WeekOne::change)
            //         .mapToObj(i -> Character.toString((char)i))
            //         .toArray(String[]::new);
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
    // private static int change(int c){
    //     if(c >= 65 && c <= 90){
    //         return Character.toLowerCase(c);
    //     } else if (c >= 97 && c <= 122) {
    //         return Character.toUpperCase(c);
    //     } else {
    //         return c;
    //     }
    // }

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

    public static void reverseOnlyEn(){
        try(Scanner s = new Scanner(System.in)){
            String str = s.nextLine();
            System.out.println("input : " + str);
            char[] cArray = str.toCharArray();
            char[] result = new char[cArray.length];
            for(int i = 0 ; i < cArray.length ; i++){
                if( !(cArray[i] >= 65 && cArray[i] <= 90) && !(cArray[i] >= 97 && cArray[i] <= 122)){
                    result[i] = cArray[i];
                }
            }
            for(int i = 0 ; i < cArray.length ; i++){
                if( (cArray[i] >= 65 && cArray[i] <= 90) || (cArray[i] >= 97 && cArray[i] <= 122)){
                    for(int j = cArray.length-1 ; 0 <= j ; j-- ){
                        if(result[j] == 0){
                            result[j] = cArray[i];
                            break;
                        }
                    }
                }
            }
            System.out.println("result : " + String.valueOf(result));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deduplication(){
        try(Scanner s = new Scanner(System.in)){
            String str = s.nextLine();
            List<String> result = Arrays.asList(str.split(""));
            result.stream().distinct().forEach(val -> System.out.println(val));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void isPalindrome(){
        try(Scanner s = new Scanner(System.in)){
            String[] str = s.nextLine().split("");
            for(int i=0 ; i < str.length/2 ; i ++){
                if(!str[i].equalsIgnoreCase(str[str.length -i -1])){
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void isPalindromeIgnoreNotEn(){
        try(Scanner s = new Scanner(System.in)){

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
