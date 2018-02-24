import java.util.Scanner;
import java.util.ArrayList;
public class DungeonGame {
    public static void main(String[] args) {
        //walls construction
        ArrayList<Wall> walls = new ArrayList<>();
        walls.add(new Wall(3, 2));
        walls.add(new Wall(0, 3));
        walls.add(new Wall(2, 3));
        walls.add(new Wall(3, 3));
        walls.add(new Wall(0, 2));
        walls.add(new Wall(0, 1));
        walls.add(new Wall(4, 3));

        //vector
        int vx = 0;
        int vy = 0;

        //player's info
        Protagonist player1 = new Protagonist(2,2,60,50,200, 2);

        //monster's info
        Monster monster1 = new Monster(1,3,60,30,120,3);

        //board's dimension
        int m = 5;
        int n = 5;

        //turn
        int turn = 40;

        //To make key and monster disappear
        boolean hasKey = false;

        //key's location
        Key key1 = new Key (1, 4);

        //exit's location
        Exit exit1 = new Exit (4,4);

        boolean loop = true;

        Scanner keyboardScanner = new Scanner(System.in);
        while (loop) {
            turn--;
            //print game play
//            System.out.println("Your player: " + "ATK: " + patk + " DEF: " + pdef + " HP: " + php + " DEXT: " + pdex);
//            System.out.println("The enemy: " + "ATK: " + matk + " DEF: " + mdef + " HP: " + mhp + " DEXT: " + mdex);
            System.out.println("Don't exceed 40 turns!");
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    boolean hasWall = false;
                    for (Wall wall : walls) {
                        if (wall.match(x,y)) {
                            hasWall = true;
                            System.out.print("W ");
                        }
                    }
                    if (!hasWall){
                        if (player1.match(x,y)) {
                            System.out.print("P ");
                        }
                        else if (monster1.match(x,y) && monster1.hasMonster()) {
                            System.out.print("M ");
                        }
                        else if (key1.match(x,y) && !hasKey) {
                            System.out.print("K ");
                        }
                        else if (exit1.match(x,y)){
                            System.out.print("E ");
                        }
                        else {
                            System.out.print("- ");
                        }
                    }

                    //check if player hits walls
                    for (Wall wall : walls) {
                        if (wall.match(x,y)) {
                            if(player1.match(x,y)){

                            }
                        }
                    }
                }
                System.out.print("\n");
            }
            System.out.println("Press W to move up; S to move down, A to move left, D to move right, 1 to stop");
            String move = keyboardScanner.next();
            vx = 0;
            vy = 0;
            if (move.equalsIgnoreCase("w")) {
                player1.goUp();
            } else if (move.equalsIgnoreCase("s")) {
                player1.goDown();
            } else if (move.equalsIgnoreCase("a")) {
                player1.goLeft();
            } else if (move.equalsIgnoreCase("d")) {
                player1.goRight();
            }

            //check to make sure it does not go out of bound
            player1.checkWallX();
            player1.checkWallY();


            //check for hitting walls situations
//            for (Wall wall : walls) {
//                if (wall.match(x,y)) {
//                    System.out.print("W ");
//                    x++;
//                }
//            }

            if (move.equals("1")) {
                loop = false;
                System.out.println("You have successfully stopped");
            } else if (!move.equalsIgnoreCase("w") && !move.equalsIgnoreCase("s") && !move.equalsIgnoreCase("a") && !move.equalsIgnoreCase("d") && !move.equalsIgnoreCase("1")) {
                System.out.println("You have entered an invalid input");
            }
//            if (player1. {
//                hasKey = true;
//                System.out.println("You have found the key");

//            }
//            if (px == ex && py == ey) {
//                if (hasKey) {
//                    loop = false;
//                    System.out.println("You have won!");
//                    System.out.println("You have completed in " + (40 - turn) + " steps.");
//                } else {
//                    System.out.println("You need to find the key first");
//                }
//            }
//            if (px == mx && py == my) {
//                System.out.println("You have encountered a monster! Fight or Flight???");
//                String choice = keyboardScanner.next();
//                if (choice.equalsIgnoreCase("Fight")) {
//                    int dieAtk = (int) (Math.random() * 5 + 1);
//                    int dieDex = (int) (Math.random() * 5 + 1);
//                    if (dieAtk > 3) {
//                        if (dieDex >= pdex) {
//                            mhp = mhp - (patk - mdef);
//                            php = php - (matk - pdef);
//                            System.out.println("Dexterity is: " + dieDex + " which is your accepted dexterity.");
//                            System.out.println("You have rolled: " + dieAtk + ". You have inflicted : " + (patk - mdef) + " damage to the enemy.");
//                            System.out.println("It also deals " + (matk - pdef) + " damage to you");
//                            System.out.println("You now have " + php + " HP left.");
//                            System.out.println("It now has " + mhp + " HP left.");
//                            py = py - 1;
//                        } else if (dieDex < pdex) {
//                            System.out.println("Dexterity is: " + dieDex + " which is lower than your accepted dexterity." + "Unfortunately, you have missed.");
//                            php = php - (matk - pdef);
//                            System.out.println("The enemy has inflicted " + (matk - pdef) + " damage to you");
//                            System.out.println("You now have " + php + " HP left.");
//                            py = py - 1;
//                        }
//                        if (mhp <= 0) {
//                            hasMonster = true;
//                            System.out.println("You have slayed the enemy");
//                        }
//                        if (php <= 0) {
//                            System.out.println("The enemy slayed you. You died!");
//                            loop = false;
//                        }
//
//                    } else if (dieAtk <= 3) {
//                        php = php - (matk - pdef);
//                        py = py - 1;
//                        System.out.println("You have rolled: " + dieAtk + ". The enemy defeated you. You lost " + (matk - pdef) + " HP");
//                        System.out.println("You have: " + php + " HP left.");
//                        if (php <= 0) {
//                            System.out.println("The enemy slayed you. You died!");
//                            loop = false;
//                        }
//                    }
//
//                } else if (choice.equalsIgnoreCase("Flight")) {
//                    py = py - 2;
//                } else if (!choice.equalsIgnoreCase("fight") && !choice.equalsIgnoreCase("flight") && !choice.equalsIgnoreCase("1")) {
//                    System.out.println("You have entered a wrong move. You stay at the same place.");
//                    py = py - 1;
//                }
//            }
//            if (turn <= 0) {
//                System.out.println("You have exceeded the allowed steps. You have lost");
//                loop = false;
//            }
        }
    }
}

