import java.util.Scanner;
import java.util.Random;

public class PacManGame {

    public static void main(String[] args) {
        //game's condition to run
        boolean winningCond = false;

        //Board Dimension
        int m = 4;
        int n = 4;
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }

        //Player's coordination
        int px = 1;
        int py = 1;
        boolean hasPlayer = false;

        //Food's coordination
        int fx1 = 0;
        int fy1 = 0;
        int fx2 = 0;
        int fy2 = 1;
        int fx3 = 1;
        int fy3 = 0;
        boolean hasFood1 = false;
        boolean hasFood2 = false;
        boolean hasFood3 = false;

        Random randomGen = new Random();

        //Ghost
        Ghost ghost1 = new Ghost(0,0);
        Ghost ghost2 = new Ghost(0,0);


        Scanner keyboardScanner = new Scanner(System.in);
        while (!winningCond) {

            //out of bound sentinel
            if (px < 0) px = 0;
            else if (px == m) px = m - 1;
            else if (py == n) py = n - 1;
            else if (py < 0) py = 0;
            System.out.println("Player's position: " + "x:" + px + " y:" + py);

            //check to see if food has been eaten yet
            if(!hasFood1) board[fx1][fy1] = 'F';
            if(!hasFood2) board[fx2][fy2] = 'F';
            if(!hasFood3) board[fx3][fy3] = 'F';

            //assigning ghost with random values
            ghost1.x = randomGen.nextInt(m);
            ghost1.y = randomGen.nextInt(n);
            ghost2.x = randomGen.nextInt(m);
            ghost2.y = randomGen.nextInt(n);
            boolean ghostDifferent = false;

            //spawn 2 ghosts
            while(!ghostDifferent){
                if(!ghost1.match(ghost2.x,ghost2.y) && !ghost2.match(ghost1.x,ghost1.y)){
                    if(!ghost1.match(px,py)){
                        board[ghost1.x][ghost1.y] = 'G';
                    }
                    if(!ghost2.match(px,py)){
                        board[ghost2.x][ghost2.y] = 'G';
                    }
                    ghostDifferent = true;
                }
                else{
                    ghost1.x = randomGen.nextInt(m);
                    ghost1.y = randomGen.nextInt(n);
                    ghost2.x = randomGen.nextInt(m);
                    ghost2.y = randomGen.nextInt(n);
                }
            }

            //check food eating condition
            if (px == fx1 && py == fy1) {
                hasFood1 = true;
            }if (px == fx2 && py == fy2) {
                hasFood2 = true;
            }if (px == fx3 && py == fy3) {
                hasFood3 = true;
            }

            board[px][py] = 'P';

            //check winning condition
            System.out.println("Ghost1's position: " + "x:" + ghost1.x + " y:" + ghost1.y + "\n"+
                    "Ghost2's position: " + "x:" + ghost2.x + " y:" + ghost2.y);
            if (ghost1.x == px && ghost1.y == py){
                System.out.println("YOU LOST!!!");
                board[px][py] = 'G';
                System.out.println(px + " " + py);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(board[j][i] + " ");
                    }
                    System.out.print("\n");
                }
                break;
            }
            else if (ghost2.x == px && ghost2.y == py){
                System.out.println("YOU LOST!!!");
                board[px][py] = 'G';
                System.out.println(px + " " + py);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(board[j][i] + " ");
                    }
                    System.out.print("\n");
                }
                break;
            }
            else if (hasFood1 && hasFood2 && hasFood3) {
                board[px][py] = 'P';
                System.out.println("YOU WON!!!");
                winningCond = true;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(board[j][i] + " ");
                    }
                    System.out.print("\n");
                }
                break;
            }

            //print the map
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[j][i] + " ");
                }
                System.out.print("\n");
            }

            //movement
            System.out.println("Press W to move up; S to move down, A to move left, D to move right, 1 to stop");
            String move = keyboardScanner.next();
            if (move.equalsIgnoreCase("w")) {
                board[px][py] = '-';
                py--;
            } else if (move.equalsIgnoreCase("s")) {
                board[px][py] = '-';
                py++;
            } else if (move.equalsIgnoreCase("a")) {
                board[px][py] = '-';
                px--;
            } else if (move.equalsIgnoreCase("d")) {
                board[px][py] = '-';
                px++;
            } else if (move.equalsIgnoreCase("1")) {
                break;
            } else {
                System.out.println("You have typed an invalid move!");
            }

            board[ghost1.x][ghost1.y]='-';
            board[ghost2.x][ghost2.y]='-';
        }
    }
}










