package day1017;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by kgh on 2018. 10. 16.
 * Blog : http://kgh940525.tistory.com
 * Github : http://github.com/kgh940525
 *
 * 아 맞는데 자꾸 스트레스받게 틀렸다고 나오네,,, 도대체 난 뭘잘못한건가요
 * 주석넣으면 틀렸다고 나오고 ,주석 풀면 컴파일에러라고 나오는건 난 어떻게하죠??
 *
 */
public class ex {
    // comment: 인접행렬 map , check array
    static int map[][] = new int[1001][1001];
    static int check[]= new int[1001];
    static int n,m,v = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // comment: 정점
        m = Integer.parseInt(st.nextToken()); // comment: 간선
        v = Integer.parseInt(st.nextToken()); // comment: 시작정점번호


        for(int i=0; i<m; i++){
            int x,y;    // comment: 정점
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        check[v] = 1;
        DFS(v);
        System.out.println();
        BFS(v);

    }

    public static void DFS(int v){
        System.out.print(v+" ");
        for(int i=1; i<=n; i++){
            if(map[v][i] == 1&& check[i] == 0){
                check[i] = 1;
                DFS(i);
            }
        }

    }

    public static void BFS(int v) {


        Queue<Integer> queue= new LinkedList<>();

        // comment: check된곳 초기화 시키기
        for(int i=0; i<=n; i++){
            check[i] = 0;
        }

        // comment: queue에다가 처음 시작 점 넣어주기
        queue.offer(v);
        check[v] = 1;

        while(!queue.isEmpty()){
            int num = queue.poll();
            System.out.print(num +" ");

            for(int i=1; i<=n; i++){
                if(map[num][i] == 1 && check[i] == 0){
                    check[i] = 1;
                    queue.offer(i);

                }
            }

        }
        System.out.println();
    }
}