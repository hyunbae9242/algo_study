
import java.util.Arrays;
import java.util.Scanner;

public class WeekOne {


    public static void main(String[] args) {
        //1.string(문자 찾기)
        countChar();

        //2.string(대소문자 변환)
        //changeCase();

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
        //isPalindromeIgnoreNotEn();

        //9.string(숫자만 추출)
        //findDigit();

        //10.string (가장 짧은 문자거리)
        //shortestDistance();

        //11.string(문자열 압축)
        //compressString();

        //12.string(암호)
        //decryptionStr();
    }

    public static void countChar(){
        try (Scanner s = new Scanner(System.in)) {
            String str = s.nextLine();
            String findChar = s.next();
            long count = str.chars()
                            .map(Character::toLowerCase)
                            .filter(val ->  val == findChar.charAt(0))
                            .count();
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
            System.out.println(String.valueOf(result));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deduplication(){
        try(Scanner s = new Scanner(System.in)){
            String str = s.nextLine();
            // List<String> result = Arrays.asList(str.split(""));
            // result.stream().distinct().forEach(val -> System.out.println(val));
            String res = str.chars().distinct()
                        .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                        .toString();
            System.out.println(res);
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
            String str = s.nextLine();
            // String strEn = str.chars().filter(ch -> !Character.isDigit(ch))
            //             .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            //             .toString();
            String[] strArray = str.chars()
                                        .filter(ch -> Character.isAlphabetic(ch))
                                        .mapToObj(c -> (char)c+"")
                                        .toArray(String[]::new);
            for(int i=0 ; i < strArray.length/2 ; i ++){
                System.out.println(strArray[i]);
                if(!strArray[i].equalsIgnoreCase(strArray[strArray.length -i -1])){
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void findDigit(){
        try(Scanner s = new Scanner(System.in)){
            String str = s.nextLine();
            String result = str.chars()
                                .filter(c -> Character.isDigit(c))
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString();
            System.out.println(result);
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

    public static void shortestDistance(){
        try(Scanner s = new Scanner(System.in)){
            String[] strArray = s.next().split("");
            String t = s.next();

            for(int i=0; i < strArray.length; i++){
                int leftDist = 100;
                int rightDist = 100;
                if(strArray[i].equals(t)){
                    System.out.print("0 ");
                }else{
                    for(int j=1; j<=i ; j++){
                        if(strArray[i-j].equals(t)){
                            leftDist = j;
                            break;
                        }
                    }
                    for(int j=1; j < strArray.length - i ; j++){
                        if(strArray[i+j].equals(t)){
                            rightDist = j;
                            break;
                        }
                    }
                    if(leftDist <= rightDist ) System.out.print(leftDist + " ");
                    else System.out.print(rightDist + " ");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void compressString(){
        try(Scanner s = new Scanner(System.in)){
            String[] strArray = s.nextLine().split("");
            String result = "";
            String tmpStr = "";
            int count = 1;
            for(String str : strArray){
                if("".equals(result)){
                    result = str;
                    tmpStr = str;
                }else{
                    if(tmpStr.equals(str)){
                        count++;
                    }else{
                        if(count > 1){
                            result += count+"";
                        }
                        result += str;
                        tmpStr = str;
                        count = 1;
                    }
                }
            }
            if(count > 1){
                result += count+"";
            }
            System.out.println(result);
        }
    }

    public static void decryptionStr(){
        try(Scanner s = new Scanner(System.in)){
            int count = s.nextInt();
            String str = s.next();
            String[] strArray = new String[count];
            for(int i=0; i < count ; i++){
                strArray[i] = str.substring(i*7,(i+1)*7);
            }
            Arrays.stream(strArray)
                        .forEach(ss -> {
                            ss = ss.replaceAll("\\#", "1").replaceAll("\\*", "0");
                            System.out.print(Character.valueOf((char)Integer.parseInt(ss,2)) );
                        });
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
