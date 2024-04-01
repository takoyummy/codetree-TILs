import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {

    public static final int MAX_N = 200;
    
    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] nextGrid = new int[MAX_N][MAX_N];

    public static boolean inBombRange(int x, int y, int centerX, int centerY, int bombRange) {
        // 1. x가 centerX 좌표에 위치해있거나 / y에 붙어있어야 함 
        // 2. 맨하탄 거리가 bombRange의 거리보다 작아야 함
        return (x == centerX || y == centerY) && Math.abs(x - centerX) + Math.abs(y - centerY) < bombRange;
    }

    public static void bomb(int centerX, int centerY) {
        int bombRange = grid[centerX][centerY];

        // 1. 폭탄이 터질 위치는 0으로 셋팅
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (inBombRange(i, j, centerX, centerY, bombRange))
                    grid[i][j] = 0;
        
        // 2. 폭탄이 터진 이후의 결과를 nextGrid에 저장
        for (int j = 0; j < n; j++) {
            int nextRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if(grid[i][j] > 0) {
                    // 0일때 nextRow를 대기 시키기.
                    nextGrid[nextRow--][j] = grid[i][j];
                }
            }
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = nextGrid[i][j];
            }
        }
        

    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        
        for (int i = 0; i < n; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        bomb(r - 1, c - 1);

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        

    }
}