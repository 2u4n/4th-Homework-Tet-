//import java.util.ArrayList;
//
//public class GameMap {
//    private char[][] board;
//    private char currentPlayerMark;
//    int m = 5;
//    int n = 5;
//
//    public GameMap() {
//        ArrayList<Wall> walls = new ArrayList<>();
//        walls.add(new Wall(3,2));
//        walls.add(new Wall(0, 3));
//        walls.add(new Wall(2,3));
//        walls.add(new Wall(3, 3));
//        walls.add(new Wall(0, 2));
//        walls.add(new Wall(0, 1));
//        board = new char[m][n];
//        currentPlayerMark = 'P';
//        drawMap();
//    }
//
//    //walls construction
//
//
//   // Set/Reset the board back to all empty values.
//    public void drawMap() {
//        // Loop through rows
//        for (int i = 0; i < 5; i++) {
//            // Loop through columns
//            for (int j = 0; j < 5; j++) {
//                board[i][j] = '-';
//            }
//        }
//    }
//
//    // Print the current board (may be replaced by GUI implementation later)
//    public void drawMap() {
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print("- ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < walls.size(); i++) {
//
//        }
//    }
//
//
//    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
//    // Otherwise the board is full.
//    public boolean isBoardFull() {
//        boolean isFull = true;
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (board[i][j] == '-') {
//                    isFull = false;
//                }
//            }
//        }
//
//        return isFull;
//    }
//
//
//    // Returns true if there is a win, false otherwise.
//    // This calls our other win check functions to check the entire board.
//    public boolean checkForWin() {
//        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
//    }
//
//
//    // Loop through rows and see if any are winners.
//    private boolean checkRowsForWin() {
//        for (int i = 0; i < 5; i++) {
//            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
//                return true;
//            }
//        }
//        return false;
//    }
//
////
////    // Loop through columns and see if any are winners.
////    private boolean checkColumnsForWin() {
////        for (int i = 0; i < 5; i++) {
////            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
////                return true;
////            }
////        }
////        return false;
////    }
////
////
////    // Check the two diagonals to see if either is a win. Return true if either wins.
////    private boolean checkDiagonalsForWin() {
////        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
////    }
//
//
//    // Check to see if all three values are the same (and not empty) indicating a win.
//    private boolean checkRowCol(char c1, char c2, char c3) {
//        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
//    }
//
//
////    // Change player marks back and forth.
////    public void changePlayer() {
////        if (currentPlayerMark == 'x') {
////            currentPlayerMark = 'o';
////        }
////        else {
////            currentPlayerMark = 'x';
////        }
////    }
//
//
//    // Places a mark at the cell specified by row and col with the mark of the current player.
//    public boolean placeMark(int row, int col) {
//
//        // Make sure that row and column are in bounds of the board.
//        if ((row >= 0) && (row < 5)) {
//            if ((col >= 0) && (col < 5)) {
//                if (board[row][col] == '-') {
//                    board[row][col] = currentPlayerMark;
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//}
