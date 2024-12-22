import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        int[] sortPath = new int[N];
        int[] path = new int[N];

        String[] noStr = bf.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(noStr[i]);
            sortPath[i] = 1;
            path[i] = -1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                if(sortPath[j] < sortPath[i] + 1 && arr[j] > arr[i]) {
                    sortPath[j] = sortPath[i] + 1;
                    path[j] = i;
                }
            }
        }

        int max = -Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        int current = 0;
        for(int i = 0; i < N; i++) {
            if(sortPath[i] > max) {
                max = sortPath[i];
                current = i;
            }
        }

        while(current > -1) {
            list.add(arr[current]);
            current = path[current];
        }

        Collections.sort(list);

        System.out.println(max);
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}