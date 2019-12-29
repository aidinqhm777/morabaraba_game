package control;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {


    private static final int BLUE = 1;
    private static final int RED = 0;
    private static final int EMPTY = -1;
    private int[][] gameBord;
    private Game Parent;
    public ArrayList<Game> next = new ArrayList<>();
    private boolean blueTurn = true;
    private int blueStonePackCount;
    private int blueStoneCount;
    private int redStonePackCount;
    private int redStoneCount;


    //constructor
    public Game() {
        gameBord = emptyGameBoard(new int[8][3]);
        blueTurn = true;
        blueStonePackCount = 12;
        blueStoneCount = 12;
        redStonePackCount = 12;
        redStoneCount = 12;
    }

    public Game(int[][] gameBord, Game parent) {
        for (int i = 0; i < 8; i++) for (int j = 0; j < 3; j++) this.gameBord[i][j] = gameBord[i][j];
        this.Parent = parent;
        blueTurn = !parent.blueTurn;
        this.blueStonePackCount = parent.blueStonePackCount;
        this.redStonePackCount = parent.redStonePackCount;
    }

    class Pair {
        int i, j;

        Pair(int p1, int p2) {
            this.i = p1;
            this.j = p2;
        }

        void pair(int p1, int p2) {
            this.i = p1;
            this.j = p2;
        }
    }

    //methods
    public LinkedList emptySpot(int Position) {
        LinkedList<Integer> empty = new LinkedList<>();
        LinkedList<Integer> connected = Connected(Position);

        for (int i = 0; i < connected.size(); i++) {
            if (isGameBordEmpty(connected.get(i))) {
                empty.add(connected.get(i));
            }
        }

        return empty;
    }

    public LinkedList Connected(int Position) {
        LinkedList<Integer> empty = new LinkedList<>();

        if (Position == 1) {
            return returnLinkedList(2, 4, 10);
        }
        if (Position == 2) {
            return returnLinkedList(1, 3, 5);
        }
        if (Position == 3) {
            return returnLinkedList(2, 6, 15);
        }
        if (Position == 4) {
            return returnLinkedList(1, 7, 11, 5);
        }
        if (Position == 5) {
            return returnLinkedList(2, 8, 4, 6);
        }
        if (Position == 6) {
            return returnLinkedList(3, 9, 5, 14);
        }
        if (Position == 7) {
            return returnLinkedList(4, 8, 12);
        }
        if (Position == 8) {
            return returnLinkedList(5, 7, 9);
        }
        if (Position == 9) {
            return returnLinkedList(8, 6, 18);
        }
        if (Position == 10) {
            return returnLinkedList(1, 22, 11);
        }
        if (Position == 11) {
            return returnLinkedList(10, 12, 4, 19);
        }
        if (Position == 12) {
            return returnLinkedList(7, 16, 11);
        }
        if (Position == 13) {
            return returnLinkedList(9, 18, 14);
        }
        if (Position == 14) {
            return returnLinkedList(6, 21, 13, 15);
        }
        if (Position == 15) {
            return returnLinkedList(3, 24, 14);
        }
        if (Position == 16) {
            return returnLinkedList(12, 17, 19);
        }
        if (Position == 17) {
            return returnLinkedList(20, 16, 18);
        }
        if (Position == 18) {
            return returnLinkedList(13, 17, 21);
        }
        if (Position == 19) {
            return returnLinkedList(11, 20, 22, 16);
        }
        if (Position == 20) {
            return returnLinkedList(17, 23, 21, 19);
        }
        if (Position == 21) {
            return returnLinkedList(18, 24, 20, 14);
        }
        if (Position == 22) {
            return returnLinkedList(19, 10, 23);
        }
        if (Position == 23) {
            return returnLinkedList(20, 22, 24);
        }
        if (Position == 24) {
            return returnLinkedList(21, 15, 23);
        }
        return empty;
    }

    public boolean isDraw() {
        return redStoneCount == 12 && blueStoneCount == 12 && redStonePackCount == 0 && blueStonePackCount == 0;
    }

    public boolean canAddStone(int state) {
        if (blueStonePackCount == 0 && state == BLUE) return false;
        if (redStonePackCount == 0 && state == RED) return false;
        return true;
    }

    public boolean isBlueWin() {
        return redStoneCount <= 2;
    }

    public boolean isRedWin() {
        return blueStoneCount <= 2;
    }

    public boolean isBlueCanMove() {
        return blueStonePackCount == 0;
    }

    public boolean isRedCanMove() {
        return redStonePackCount == 0;
    }

    public boolean isBlueTurn() {
        return blueTurn;
    }

    public void setBlueTurn(boolean isBlueTurn) {
        this.blueTurn = isBlueTurn;
    }

    public void addBluePiece(int Position) {
        int i = positionToij(Position).i;
        int j = positionToij(Position).j;
        gameBord[i][j] = BLUE;
        blueTurn = false;
        blueStonePackCount--;
    }

    public void addRedPiece(int Position) {
        int i = positionToij(Position).i;
        int j = positionToij(Position).j;
        gameBord[i][j] = RED;
        blueTurn = true;
        redStonePackCount--;
    }

    private void removePiece(int Position) {
        int i = positionToij(Position).i;
        int j = positionToij(Position).j;
        gameBord[i][j] = EMPTY;
        System.out.println(i + " " + j + "cleand ");
    }

    public void removeRedPiece(int position) {
        removePiece(position);
        redStoneCount--;
    }

    public void removeBluePiece(int position) {
        removePiece(position);
        blueStoneCount--;
    }

    public void moveBluePiece(int BluePosition, int emptyPosition) {
        gameBord[positionToij(emptyPosition).i][positionToij(emptyPosition).j] = 1;
        gameBord[positionToij(BluePosition).i][positionToij(BluePosition).j] = -1;
        blueTurn = !blueTurn;
    }

    public void moveRedPiece(int RedPosition, int emptyPosition) {
        gameBord[positionToij(emptyPosition).i][positionToij(emptyPosition).j] = 1;
        gameBord[positionToij(RedPosition).i][positionToij(RedPosition).j] = -1;
        blueTurn = !blueTurn;
    }

    public static void findNextMode(Game game) {
        Game temp = new Game(game.gameBord, game);
        if (game.blueTurn) {
            for (int i = 1; i <= 24; i++) {
                if (game.isGameBordEmpty(i)) {
                    temp.addBluePiece(i);
                    game.next.add(temp);
                    temp = new Game(game.gameBord, game);
                }
            }
        } else {
            for (int i = 1; i <= 24; i++) {
                if (game.isGameBordEmpty(i)) {
                    temp.addRedPiece(i);
                    game.next.add(temp);
                    temp = new Game(game.gameBord, game);
                }
            }
        }
    }

    public void toOut() {
        for (int i = 1; i <= 24; i++) {
            if (isGameBordBlue(i)) System.out.println(i + " = Blue\n");
            else if (isGameBordRed(i)) System.out.println(i + " = Red\n");
            else System.out.println(i + " = empty\n");
        }
    }

    public boolean isBlueWinInNextMove(int next) {
        Pair pair = positionToij(next);

        if (next == 1) {
            return isRowCompleteForBlue(2, 3, 10, 22, 4, 7);
        }
        if (next == 2) {
            return isRowCompleteForBlue(1, 3, 5, 8);
        }
        if (next == 3) {
            return isRowCompleteForBlue(1, 2, 6, 9, 15, 24);
        }
        if (next == 4) {
            return isRowCompleteForBlue(5, 6, 11, 19, 1, 7);
        }
        if (next == 5) {
            return isRowCompleteForBlue(2, 8, 4, 6);
        }
        if (next == 6) {
            return isRowCompleteForBlue(5, 4, 9, 3, 14, 21);
        }
        if (next == 7) {
            return isRowCompleteForBlue(1, 4, 12, 16, 8, 9);
        }
        if (next == 8) {
            return isRowCompleteForBlue(2, 5, 7, 9);
        }
        if (next == 9) {
            return isRowCompleteForBlue(3, 6, 7, 8, 13, 18);
        }
        if (next == 10) {
            return isRowCompleteForBlue(1, 22, 11, 12);
        }
        if (next == 11) {
            return isRowCompleteForBlue(4, 19, 10, 12);
        }
        if (next == 12) {
            return isRowCompleteForBlue(7, 16, 11, 10);
        }
        if (next == 13) {
            return isRowCompleteForBlue(9, 18, 14, 15);
        }
        if (next == 14) {
            return isRowCompleteForBlue(6, 21, 13, 15);
        }
        if (next == 15) {
            return isRowCompleteForBlue(3, 24, 13, 14);
        }
        if (next == 16) {
            return isRowCompleteForBlue(7, 12, 17, 18, 19, 22);
        }
        if (next == 17) {
            return isRowCompleteForBlue(16, 18, 20, 23);
        }
        if (next == 18) {
            return isRowCompleteForBlue(9, 13, 17, 16, 21, 24);
        }
        if (next == 19) {
            return isRowCompleteForBlue(11, 4, 20, 21, 16, 22);
        }
        if (next == 20) {
            return isRowCompleteForBlue(17, 23, 19, 21);
        }
        if (next == 21) {
            return isRowCompleteForBlue(14, 6, 18, 24, 19, 20);
        }
        if (next == 22) {
            return isRowCompleteForBlue(1, 10, 23, 24, 19, 16);
        }
        if (next == 23) {
            return isRowCompleteForBlue(20, 17, 22, 24);
        }
        if (next == 24) {
            return isRowCompleteForBlue(21, 18, 15, 3, 23, 22);
        } else return false;
    }

    private LinkedList returnLinkedList(int n1, int n2, int n3) {
        LinkedList<Integer> Ll = new LinkedList<>();
        Ll.add(n1);
        Ll.add(n2);
        Ll.add(n3);
        return Ll;
    }

    private LinkedList returnLinkedList(int n1, int n2, int n3, int n4) {
        LinkedList<Integer> Ll = new LinkedList<>();
        Ll.add(n1);
        Ll.add(n2);
        Ll.add(n3);
        Ll.add(n4);
        return Ll;
    }

    public boolean isRedWinInNextMove(int next) {
        Pair pair = positionToij(next);
        if (next == 1) {
            return isRowCompleteForRed(2, 3, 10, 22, 4, 7);
        }
        if (next == 2) {
            return isRowCompleteForRed(1, 3, 5, 8);
        }
        if (next == 3) {
            return isRowCompleteForRed(1, 2, 6, 9, 15, 24);
        }
        if (next == 4) {
            return isRowCompleteForRed(5, 6, 11, 19, 1, 7);
        }
        if (next == 5) {
            return isRowCompleteForRed(2, 8, 4, 6);
        }
        if (next == 6) {
            return isRowCompleteForRed(5, 4, 9, 3, 14, 21);
        }
        if (next == 7) {
            return isRowCompleteForRed(1, 4, 8, 9, 12, 16);
        }
        if (next == 8) {
            return isRowCompleteForRed(2, 5, 7, 9);
        }
        if (next == 9) {
            return isRowCompleteForRed(3, 6, 7, 8, 13, 18);
        }
        if (next == 10) {
            return isRowCompleteForRed(1, 22, 11, 12);
        }
        if (next == 11) {
            return isRowCompleteForRed(4, 19, 10, 12);
        }
        if (next == 12) {
            return isRowCompleteForRed(7, 16, 11, 10);
        }
        if (next == 13) {
            return isRowCompleteForRed(9, 18, 14, 15);
        }
        if (next == 14) {
            return isRowCompleteForRed(6, 21, 13, 15);
        }
        if (next == 15) {
            return isRowCompleteForRed(3, 24, 13, 14);
        }
        if (next == 16) {
            return isRowCompleteForRed(7, 12, 17, 18, 19, 22);
        }
        if (next == 17) {
            return isRowCompleteForRed(16, 18, 20, 23);
        }
        if (next == 18) {
            return isRowCompleteForRed(9, 13, 17, 16, 21, 24);
        }
        if (next == 19) {
            return isRowCompleteForRed(11, 4, 20, 21, 16, 22);
        }
        if (next == 20) {
            return isRowCompleteForRed(17, 23, 19, 21);
        }
        if (next == 21) {
            return isRowCompleteForRed(14, 6, 18, 24, 19, 20);
        }
        if (next == 22) {
            return isRowCompleteForRed(1, 10, 23, 24, 19, 16);
        }
        if (next == 23) {
            return isRowCompleteForRed(20, 17, 22, 24);
        }
        if (next == 24) {
            return isRowCompleteForRed(21, 18, 15, 3, 23, 22);
        } else return false;
    }

    private boolean isRowCompleteForBlue(int a1, int a2, int b1, int b2, int c1, int c2) {
        return (isGameBordBlue(a1) && isGameBordBlue(a2)) || (isGameBordBlue(b1) && isGameBordBlue(b2)) || (isGameBordBlue(c1) && isGameBordBlue(c2));
    }

    private boolean isRowCompleteForBlue(int a1, int a2, int b1, int b2) {
        return (isGameBordBlue(a1) && isGameBordBlue(a2)) || (isGameBordBlue(b1) && isGameBordBlue(b2));
    }

    private boolean isRowCompleteForRed(int a1, int a2, int b1, int b2, int c1, int c2) {
        return (isGameBordRed(a1) && isGameBordRed(a2)) || (isGameBordRed(b1) && isGameBordRed(b2)) || (isGameBordRed(c1) && isGameBordRed(c2));
    }

    private boolean isRowCompleteForRed(int a1, int a2, int b1, int b2) {
        return (isGameBordRed(a1) && isGameBordRed(a2)) || (isGameBordRed(b1) && isGameBordRed(b2));
    }

    private boolean isGameBordBlue(int position) {
        int i = positionToij(position).i;
        int j = positionToij(position).j;
        return gameBord[i][j] == BLUE;
    }

    private boolean isGameBordRed(int position) {
        int i = positionToij(position).i;
        int j = positionToij(position).j;
        return gameBord[i][j] == RED;
    }

    public boolean isGameBordEmpty(int position) {
        int i = positionToij(position).i;
        int j = positionToij(position).j;
        return gameBord[i][j] == EMPTY;
    }

    private Pair positionToij(int position) {
        Pair pair = new Pair(0, 0);
        if (position == 1) {
            pair.pair(0, 0);
            return pair;
        }
        if (position == 2) {
            pair.pair(0, 1);
            return pair;
        }
        if (position == 3) {
            pair.pair(0, 2);
            return pair;
        }
        if (position == 4) {
            pair.pair(1, 0);
            return pair;
        }
        if (position == 5) {
            pair.pair(1, 1);
            return pair;
        }
        if (position == 6) {
            pair.pair(1, 2);
            return pair;
        }
        if (position == 7) {
            pair.pair(2, 0);
            return pair;
        }
        if (position == 8) {
            pair.pair(2, 1);
            return pair;
        }
        if (position == 9) {
            pair.pair(2, 2);
            return pair;
        }
        if (position == 10) {
            pair.pair(3, 0);
            return pair;
        }
        if (position == 11) {
            pair.pair(3, 1);
            return pair;
        }
        if (position == 12) {
            pair.pair(3, 2);
            return pair;
        }
        if (position == 13) {
            pair.pair(4, 0);
            return pair;
        }
        if (position == 14) {
            pair.pair(4, 1);
            return pair;
        }
        if (position == 15) {
            pair.pair(4, 2);
            return pair;
        }
        if (position == 16) {
            pair.pair(5, 0);
            return pair;
        }
        if (position == 17) {
            pair.pair(5, 1);
            return pair;
        }
        if (position == 18) {
            pair.pair(5, 2);
            return pair;
        }
        if (position == 19) {
            pair.pair(6, 0);
            return pair;
        }
        if (position == 20) {
            pair.pair(6, 1);
            return pair;
        }
        if (position == 21) {
            pair.pair(6, 2);
            return pair;
        }
        if (position == 22) {
            pair.pair(7, 0);
            return pair;
        }
        if (position == 23) {
            pair.pair(7, 1);
            return pair;
        }
        if (position == 24) {
            pair.pair(7, 2);
            return pair;
        } else return pair;
    }

    private int ijToPosition(int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i == 0 && j == 1) {
            return 2;
        }
        if (i == 0 && j == 2) {
            return 3;
        }
        if (i == 1 && j == 0) {
            return 4;
        }
        if (i == 1 && j == 1) {
            return 5;
        }
        if (i == 1 && j == 2) {
            return 6;
        }
        if (i == 2 && j == 0) {
            return 7;
        }
        if (i == 2 && j == 1) {
            return 8;
        }
        if (i == 2 && j == 2) {
            return 9;
        }
        if (i == 3 && j == 0) {
            return 10;
        }
        if (i == 3 && j == 1) {
            return 11;
        }
        if (i == 3 && j == 2) {
            return 12;
        }
        if (i == 4 && j == 0) {
            return 13;
        }
        if (i == 4 && j == 1) {
            return 14;
        }
        if (i == 4 && j == 2) {
            return 15;
        }
        if (i == 5 && j == 0) {
            return 16;
        }
        if (i == 5 && j == 1) {
            return 17;
        }
        if (i == 5 && j == 2) {
            return 18;
        }
        if (i == 6 && j == 0) {
            return 19;
        }
        if (i == 6 && j == 1) {
            return 20;
        }
        if (i == 6 && j == 2) {
            return 21;
        }
        if (i == 7 && j == 0) {
            return 22;
        }
        if (i == 7 && j == 1) {
            return 23;
        }
        if (i == 7 && j == 2) {
            return 24;
        }
        return 0;
    }

    private int[][] emptyGameBoard(int[][] gameBord) {
        for (int i = 0; i < gameBord.length; i++)
            for (int j = 0; j < gameBord[0].length; j++)
                gameBord[i][j] = EMPTY;
        return gameBord;
    }
}




