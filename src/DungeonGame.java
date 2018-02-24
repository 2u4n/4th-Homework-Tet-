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

        //Redbull's info
        RedBull redbull = new RedBull(1,1);
        boolean hasRedbull = false;

        //player's info
        Protagonist player1 = new Protagonist(2,2,60,50,200, 2);

        //monster's info
        Monster monster1 = new Monster(1,3,60,30,120,3);
        boolean hasMonster = false;

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
            System.out.println("Your player: " + "ATK: " + player1.atk + " DEF: " + player1.def + " HP: " + player1.hp + " DEXT: " + player1.dex);
            System.out.println("The enemy: " + "ATK: " + monster1.atk + " DEF: " + monster1.def + " HP: " + monster1.hp + " DEXT: " + monster1.dex);
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
                        else if (redbull.match(x,y) && !hasRedbull){
                            System.out.print("R ");
                        }
                        else {
                            System.out.print("- ");
                        }
                    }
                }
                System.out.print("\n");
            }

            //movement
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
            for (Wall wall : walls) {
                if (player1.match(wall.x,wall.y)) {
                    System.out.println("You cannot go through the wall!");

                }
            }

            if (move.equals("1")) {
                loop = false;
                System.out.println("You have successfully stopped");
            }
            else if (!move.equalsIgnoreCase("w") && !move.equalsIgnoreCase("s") && !move.equalsIgnoreCase("a") && !move.equalsIgnoreCase("d") && !move.equalsIgnoreCase("1")) {
                System.out.println("You have entered an invalid input");
            }

            //check to see if player gets redbull yet
            if(player1.x == redbull.x && player1.y == redbull.y){
                player1.atk = player1.atk*2;
                System.out.println("You have collected a redbull. Your attack point is doubled!");
                hasRedbull = true;
            }

            //grab key
            if (player1.x == key1.x && player1.y == key1.y){
                hasKey = true;
                System.out.println("You have found the key");
            }

            //check to see if win
            if (player1.x == exit1.x && player1.y == exit1.y){
                if (hasKey){
                    loop = false;
                    System.out.println("You have won!");
                    System.out.println("You have completed in " + (40 - turn) + " steps.");
                }
                else if(!hasKey){
                    System.out.println("You need to find the key first");
                }
            }
            if (player1.x == monster1.x && player1.y == monster1.y) {
                System.out.println("You have encountered a monster! Fight or Flight???");
                String choice = keyboardScanner.next();
                if (choice.equalsIgnoreCase("Fight")) {
                    int dieAtk = (int) (Math.random() * 5 + 1);
                    int dieDex = (int) (Math.random() * 5 + 1);
                    if (dieAtk > 3) {
                        if (dieDex >= player1.dex) {
                            monster1.hp = monster1.hp - (player1.atk - monster1.def);
                            player1.hp = player1.hp - (monster1.atk - player1.def);
                            System.out.println("Dexterity is: " + dieDex + " which is your accepted dexterity.");
                            System.out.println("You have rolled: " + dieAtk + ". You have inflicted : " + (player1.atk - monster1.def) + " damage to the enemy.");
                            System.out.println("It also deals " + (monster1.atk - player1.def) + " damage to you");
                            System.out.println("You now have " + player1.hp + " HP left.");
                            System.out.println("It now has " + monster1.hp + " HP left.");
                            player1.y = player1.y - 1;
                        } else if (dieDex < player1.dex) {
                            System.out.println("Dexterity is: " + dieDex + " which is lower than your accepted dexterity." + "Unfortunately, you have missed.");
                            player1.hp = player1.hp - (monster1.atk - player1.def);
                            System.out.println("The enemy has inflicted " + (monster1.atk - player1.def) + " damage to you");
                            System.out.println("You now have " + player1.hp + " HP left.");
                            player1.y = player1.y - 1;
                        }
                        if (monster1.hp <= 0) {
                            hasMonster = true;
                            System.out.println("You have slayed the enemy");
                        }
                        if (player1.hp <= 0) {
                            System.out.println("The enemy slayed you. You died!");
                            loop = false;
                        }

                    } else if (dieAtk <= 3) {
                        player1.hp = player1.hp - (monster1.atk - player1.def);
                        player1.y = player1.y - 1;
                        System.out.println("You have rolled: " + dieAtk + ". The enemy defeated you. You lost " + (monster1.atk - player1.def) + " HP");
                        System.out.println("You have: " + player1.hp + " HP left.");
                        if (player1.hp <= 0) {
                            System.out.println("The enemy slayed you. You died!");
                            loop = false;
                        }
                    }

                } else if (choice.equalsIgnoreCase("Flight")) {
                    player1.y = player1.y - 2;
                } else if (!choice.equalsIgnoreCase("fight") && !choice.equalsIgnoreCase("flight") && !choice.equalsIgnoreCase("1")) {
                    System.out.println("You have entered a wrong move. You stay at the same place.");
                    player1.y = player1.y - 1;
                }
            }
            if (turn <= 0) {
                System.out.println("You have exceeded the allowed steps. You have lost");
                loop = false;
            }
        }
    }
}

