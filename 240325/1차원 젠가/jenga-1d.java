import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100;

    public static int n;
    public static int[] numbers = new int[MAX_N];

    public static int endOfArray;

    public static void cutArray(int startIdx, int endIdx) {

        int[] tempArr = new int[MAX_N];
        int endOfTempArray = 0;

        for(int i = 0; i < endOfArray; i++) {
            if(i < startIdx || i > endIdx)
                tempArr[endOfTempArray++] = numbers[i];
        }

        for(int i = 0; i < endOfTempArray; i++) 
            numbers[i] = tempArr[i];
        endOfArray = endOfTempArray; 
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(stringTokenizer.nextToken());

       for(int i = 0; i < n; i++) {
        numbers[i] = Integer.parseInt(br.readLine());
       }
       endOfArray = n;

       for (int k = 0; k < 2; k++) {
        stringTokenizer = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(stringTokenizer.nextToken());
        int e = Integer.parseInt(stringTokenizer.nextToken());
        s--;
        e--;
        cutArray(s, e);
       }

       System.out.println(endOfArray);
       for(int i =0; i < endOfArray; i++) {
        System.out.println(numbers[i]);
       }


    
    }
}