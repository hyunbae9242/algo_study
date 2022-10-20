import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Weekfive {
    public static void main(String[] args) {
        //1. 학급회장(해쉬)
        //classPresident();
        //2. 아나그램(해쉬)
        //anagram();
        //3. 매출액의 종류
        //kindOfSales();
        //4. 모든 아나그램 찾기
        //findAllAnagram();
        //5. K번째 큰 수
        nRankNumber();
    }

    //1. 학급 회장(해쉬)
    public static void classPresident(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            s.nextLine();
            String ss = s.nextLine();
            String[] strArray = ss.split("");
            Map<String, Integer> m = new HashMap<>();
            m.put("A", 0);
            m.put("B", 0);
            m.put("C", 0);
            m.put("D", 0);
            m.put("E", 0);
            for(String str : strArray){
                m.put(str , m.get(str)+1);
            }
            Iterator<String> i = m.keySet().iterator();
            String classPresident = "";
            int max = 0;
            while(i.hasNext()){
                String key = i.next();
                int value = m.get(key);
                if(value > max){
                    classPresident = key;
                    max = value;
                }
            }
            System.out.println(classPresident);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //2. 아나그램 (해쉬)
    public static void anagram(){
        try(Scanner s = new Scanner(System.in)){
            String[] nArray = s.nextLine().split("");
            String[] mArray = s.nextLine().split("");
            Map<String,Integer> nMap = new HashMap<>();
            Map<String,Integer> mMap = new HashMap<>();
            for(String str : nArray){
                nMap.put(str, (nMap.get(str) == null ? 0 : nMap.get(str))  + 1);
            }
            for(String str : mArray){
                mMap.put(str, (mMap.get(str) == null ? 0 : mMap.get(str)) + 1);
            }
            boolean isContinue = true;
            Iterator<String> ni = nMap.keySet().iterator();
            while(ni.hasNext()){
                String key = ni.next();
                if(nMap.get(key) != mMap.get(key)){
                    isContinue = false;
                    System.out.println("NO");
                    break;
                }
            }
            if(isContinue){
                Iterator<String> mi = mMap.keySet().iterator();
                while(mi.hasNext()){
                    String key = mi.next();
                    if(nMap.get(key) != mMap.get(key)){
                        isContinue = false;
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if(isContinue){
                System.out.println("YES");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //3. 매출액의 종류
    public static void kindOfSales(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int k = s.nextInt();
            int[] rArray = new int[n];
            
            for(int i=0 ; i<n ; i++){
                rArray[i] = s.nextInt();
            }
            Map<Integer, Integer> nMap = new HashMap<>();
            for(int i=0 ; i<n ; i++){
                nMap.put(rArray[i], (nMap.get(rArray[i]) != null ?  nMap.get(rArray[i]) : 0 ) + 1 );
                if(i >= k ){
                    if(nMap.get(rArray[i-k]) - 1 == 0){
                        nMap.remove(rArray[i-k]);
                    }else{
                        nMap.put(rArray[i-k] , nMap.get(rArray[i-k]) - 1 );
                    }
                }
                if(i >= k -1){
                    System.out.print(nMap.size() + " ");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //4. 모든 아나그램 찾기
    public static void findAllAnagram(){
        try(Scanner s = new Scanner(System.in)){
            String[] sArray = s.nextLine().split("");
            String[] tArray = s.nextLine().split("");
            Map<String,Integer> sMap = new HashMap<>();
            Map<String,Integer> tMap = new HashMap<>();
            
            for(String str : tArray){
                tMap.put(str , (tMap.get(str) != null ? tMap.get(str) : 0) + 1 );
            }
            int count = 0;
            for(int i=0 ; i<sArray.length ; i++){
                sMap.put(sArray[i], (sMap.get(sArray[i]) != null ? sMap.get(sArray[i]) : 0) + 1 );
                if(i>=tArray.length){
                    if(sMap.get(sArray[i-tArray.length]) - 1 != 0){
                        sMap.put(sArray[i-tArray.length], sMap.get(sArray[i-tArray.length])  - 1 );
                    }else {
                        sMap.remove(sArray[i-tArray.length]);
                    }
                }

                if(i >= tArray.length-1){
                    Iterator<String> it = sMap.keySet().iterator();
                    boolean isAnagram = true;
                    while(it.hasNext()){
                        String key = it.next();
                        if(sMap.get(key) != tMap.get(key)){
                            isAnagram = false;
                            break;
                        }
                    }
                    if(isAnagram) count++;
                }
            }
            System.out.println(count);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //5. k번째 큰 수
    public static void nRankNumber(){
        try(Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int k = s.nextInt();
            int[] nArray = new int[n];
            for(int i=0; i<n ; i++){
                nArray[i] = s.nextInt();
            }
            List<Integer> nList = new ArrayList<>();
            for(int i=0 ; i<n-2 ; i++){
                for(int j=i+1 ; j<n-1 ; j++){
                    for(int h= j+1 ; h<n ; h++){
                        nList.add(nArray[i]+nArray[j]+nArray[h]);
                    }
                }
            }
            nList.sort(null);
            nList = nList.stream().distinct().collect(Collectors.toList());
            if(nList.size() >= k) System.out.println(nList.get(nList.size()-k));
            else System.out.println("-1");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
