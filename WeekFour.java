import java.util.Arrays;
import java.util.Scanner;

public class WeekFour {
    public static void main(String[] args) {
        //1. 두 배열 합치기
        //sumArray();
        //2. 공통원소 구하기
        //printCommonGround();
        //3. 최대 매출

        //4. 
        //sumCase();

        longistDist();
    }

    //1.두 배열 합치기
    public static void sumArray(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int[] nArray = new int[n];
            for(int i=0 ; i<n ; i++){
                nArray[i] = s.nextInt();
            }
            int m = s.nextInt();
            int[] mArray = new int[m];
            for(int i=0 ; i<m ; i++){
                mArray[i] = s.nextInt();
            }

            int nCount = 0;
            int mCount = 0;
            while(nCount < n || mCount < m){
                if(nCount < n &&  mCount < m){
                    if(nArray[nCount] <= mArray[mCount]){
                        System.out.print(nArray[nCount] + " ");
                        nCount++;
                    }else{
                        System.out.print(mArray[mCount] + " ");
                        mCount++;
                    }
                }else if(nCount < n){
                    System.out.print(nArray[nCount] + " ");
                    nCount++;
                }else{
                    System.out.print(mArray[mCount] + " ");
                    mCount++;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //2. 공통원소 구하기
    public static void printCommonGround(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int[] nArray = new int[n];
            for(int i=0 ; i<n ; i++){
                nArray[i] = s.nextInt();
            }
            int m = s.nextInt();
            int[] mArray = new int[m];
            for(int i=0 ; i<m ; i++){
                mArray[i] = s.nextInt();
            }
            Arrays.sort(nArray);
            Arrays.sort(mArray);
            int c1 = 0;
            int c2 = 0;
            while(c1 < n && c2 < m){
                if(nArray[c1] == mArray[c2]){
                    System.out.print(nArray[c1] + " ");
                    c1++;
                    c2++;
                }else if(nArray[c1] > mArray[c2]){
                    c2++;
                }else{
                    c1++;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //3. 쵀대매출
    public static void bestSale(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int k = s.nextInt();
            int[] nArray = new int[n];
            for(int i=0 ; i<n ; i++){
                nArray[i] = s.nextInt();
            }
            int sum = 0;
            int best = 0;
            for(int j=0 ; j<k ; j++){
                sum += nArray[j];
            }
            best = sum;
            for(int i=0 ; i<n-k ; i++){
                sum = sum - nArray[i] + nArray[i+k];
                if(best < sum) best = sum;
            }
            System.out.println(best);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    // int count = 0;
    // for(int i=0 ; i<n ; i++){
    //     int sum = 0;
    //     for(int j=i; j<n ; j++){
    //         sum += nArray[j];
    //         if(sum == m){
    //             count++;
    //             break;
    //         }
    //     }
    // }
    // System.out.println(count);
    //4. 연속 부분수열
    public static void countSumCase(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int m = s.nextInt();
            int[] nArray = new int[n];
            for(int i=0 ; i<n ; i++){
                nArray[i] = s.nextInt();
            }
            int count = 0;
            int fIdx = 0;
            int lIdx = 0;
            int sum = 0;
            
            while(lIdx<n){
                if(sum < m){
                    sum += nArray[lIdx];
                    lIdx++;
                }else if(sum > m){
                    sum -= nArray[fIdx];
                    fIdx++;
                }

                if(sum == m){
                    count++;
                    sum -= nArray[fIdx];
                    fIdx++;
                }
            }
            System.out.println(count);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //5. 연속된 자연수의 합
    public static void sumCase(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();

            int fNum = 1;
            int lNum = 1;
            int sum = 0;
            int count = 0;
            while(lNum <= n/2 + 2){
                if(sum < n){
                    sum += lNum;
                    lNum++;
                }else if(sum > n){
                    sum -= fNum;
                    fNum++;
                }

                if(sum == n){
                    count++;
                    sum -= fNum;
                    fNum++;
                }
            }
            System.out.println(count);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //6. 최대 길이 연속부분수열
    public static void longistDist(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int k = s.nextInt();
            int[] nArray = new int[n];
            for(int i=0; i<n ; i++){
                nArray[i] = s.nextInt();
            }

            int max = 0;
            for(int i=0; i<n ; i++){
                int cCount = 0;
                int length = 0;
                if(max < n-i){
                    for(int j=i ; j<n ; j++){
                        if(nArray[j] == 1) {
                            length++;
                        }else if(nArray[j] == 0){
                            if(cCount == k) break;
                            cCount++;
                            length++;
                        }
                    }
                }
                if(max < length) max = length;
                if(max > n-i) break;
            }
            System.out.println(max);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
