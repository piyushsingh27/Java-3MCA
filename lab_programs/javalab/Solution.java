
import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int i = 0,flag = 0;
        
        for(; i < game.length;i += leap)
        {//System.out.println(game.length+".."+i);
        if(game[i] == 0)
        {
            flag = 1;
            continue;
        }
        if(i >= game.length - 1)
        {
            flag = 1;
            continue;
        }
        if(game[i] != 0)
        {
            flag = 0;
            break;
            
        }
        
        }
        if( 0 == flag)
        {
            return false;
            
        }
        else
        {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}