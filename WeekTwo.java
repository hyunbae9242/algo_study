
import java.util.Scanner;

public class WeekTwo {
    public static void main(String[] args) {
        //1. 큰 수 출력하기
        //printGreatThan();

        //3. 가위바위보
        //printWinner();

        //5. 소수 (에라토스테네스 체)
        countPrimeNumber();

        //7. 점수계산
        //calculatePoint();
        
        //9. 격자판 최대합
        //maxSum();

        //11. 임시반장 정하기
        //findInsider();
    }

    public static void printGreatThan(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int[] iArray = new int[n];
            for(int i=0 ; i < n ; i++ ){
                iArray[i] = s.nextInt();
            }
            for(int i=0 ; i < n ; i++ ){
                if(i == 0) System.out.print(iArray[i]);
                else if(iArray[i-1] < iArray[i]) System.out.print(iArray[i]);
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

    public static void printWinner(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i=0 ; i < n; i++){
                a[i] = s.nextInt();
            }
            for(int i=0 ; i < n; i++){
                b[i] = s.nextInt();
            }

            for(int i=0 ; i<n ; i++){
                if(a[i]==b[i]) System.out.println("D");
                else if( (a[i]==1 && b[i]==3) || (a[i]==2 && b[i]==1) || (a[i]==3 && b[i]==2) ) System.out.println("A");
                else System.out.println("B");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void countPrimeNumber(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            long st =  System.currentTimeMillis();
            int count = 0;
            for(int i=2 ; i<=n ; i++){
                if(i==2 || i==3 || i==5 || i==7) count++;
                else if(i%2==0 || i%3==0 || i%5==0 || i%7 ==0) continue;
                else count++;
            }
            long et = System.currentTimeMillis();
            System.out.println("time : "+(et -st));
            System.out.println(count);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void calculatePoint(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int total = 0;
            int point = 1;
            for(int i=0 ; i<n; i++){
                int p = s.nextInt();
                if(p == 1){
                    total += point;
                    point++;
                }else{
                    point = 1;
                }
            }
            System.out.println(total);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void maxSum(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int[][] a = new int[n][n];
            int max = 0;
            for(int i=0; i<n ; i++){
                for(int j=0; j<n ; j++){
                    a[i][j] = s.nextInt();
                }
            }
            int f = 0;
            int b = 0;
            for(int i=0 ; i<n ; i++){
                int r = 0;
                int c = 0;
                for(int j=0 ; j<n ; j++){
                    r += a[j][i];
                    c += a[i][j];
                    if(i==j) f += a[i][j];
                    if(i+j == n-1) b += a[i][j];
                }
                if(max < r) max = r;
                if(max < c) max = c;
            }
            if(max < f) max = f;
            if(max < b) max = b;

            System.out.println(max);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void findInsider(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int[][] a = new int[5][n];
            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<5 ; j++){
                    a[j][i] = s.nextInt();
                }
            }
            int max = 0;
            int stNum = 0;
            //i => 학생넘버
            for(int i=0; i<n ; i++){
                int p = 0;
                //j => 학년
                for(int j=0 ; j<5 ; j++){
                    for(int k=0 ; k<n ; k++){
                        if(a[j][i] == a[j][k]){
                            p++;
                            
                        }
                    }
                }
                if(max < p){
                    max = p;
                    stNum = i+1;
                }
            }
            System.out.println(stNum);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
