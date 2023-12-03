import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.IOException;

// https://www.codetree.ai/missions/2/problems/n-permutation/introduction 
// N! 순열 만들기
public class Main {

    public static final int MAX_N = 8;
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static int n = 8;

    public static void printAnswer() { 
        for(int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

        System.out.println();
    }

    // 1~n 까지 중아직 선택되지 않은 수를 골라주는 함수 
    public static void choose(int currNum) {
        if(currNum == n + 1) { 
            printAnswer();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i])
                continue;

            visited[i] = true;
            answer.add(i);

            choose(currNum + 1);

            answer.remove(answer.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());

        // 1. 재귀함수를 이용해서 구하는 방법 
        choose(1);

    }
}