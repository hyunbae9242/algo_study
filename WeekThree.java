import java.util.Scanner;

public class WeekThree {
    public static void main(String[] args) {
        //1. 보이는 학생
        //canSeeCount();

        //3. 피보나치 수열
        //fibonacciNumbers();

        //5. 뒤집은 소수
        //reversePrimeNumber();

        //7. 등수구하기
        ranking();
        
    }

    //1. 보이는 학생
    public static void canSeeCount(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int count = 0;
            int tmpHeigth = 0;
            for(int i=0 ; i<n ; i++){
                int h = s.nextInt();
                if(tmpHeigth < h) {
                    count++;
                    tmpHeigth = h;
                }
            }
            System.out.println(count);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //2.피보나치 수열
    public static void fibonacciNumbers(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int tmp1Int = 1;
            int tmp2Int = 0;
            String result = "";
            for(int i=0 ; i<n ; i++){
                result += tmp1Int+" ";
                int tmp3Int = tmp1Int + tmp2Int;
                tmp2Int = tmp1Int;
                tmp1Int = tmp3Int;
            }
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    //3. 뒤집은 소수
    public static void reversePrimeNumber(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            String result = "";
            for(int i=0 ; i<n ; i++){
                int k = s.nextInt();
                char[] cArray = (k+"").toCharArray();
                String str = "";
                for(int j=cArray.length-1 ; j>=0 ; j--){
                    str += cArray[j];
                }
                k = Integer.parseInt(str);
                boolean isPrime = true;
                if(k == 1) isPrime = false;
                for(int j=2 ; j < k/2 +1; j++){
                    if(k%j == 0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime){
                    result += k + " ";
                }
            }
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //7. 등수구하기
    public static void ranking(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int[] pArray = new int[n];
            for(int i=0 ; i<n ; i++){
                pArray[i] = s.nextInt();
            }
            int rank = 1;
            int[] result = new int[n];
            for(int i=0 ; i<n ; i++){
                int top = 0;
                int[] tmpArray = new int[n];
                for(int j=0;j<n;j++){
                    if(top<= pArray[j]){
                        if(top != pArray[j]){
                            tmpArray = new int[n];
                        }
                        top = pArray[j];
                        tmpArray[j] = pArray[j];
                    }
                }
                int rankCount = 0;
                for(int j=0;j<n;j++){
                    if(tmpArray[j] != 0){
                        pArray[j] = 0;
                        result[j] = rank;
                        rankCount++;
                    }
                }
                rank += rankCount;
            }
            for(int i : result){
                System.out.print(i+" ");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
