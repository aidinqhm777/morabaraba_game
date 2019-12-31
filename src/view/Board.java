package view;

import control.Game;
import control.MoveSound;

import java.util.LinkedList;


public class Board extends javax.swing.JFrame {

    private boolean isMoveWaitColorBlue;
    private boolean blueCanRemove = false;
    private boolean redCanRemove = false;
    private boolean aiActive = false;
    private static final int BLUE = 1;
    private static final int RED = 0;

    //state variables
    private int movePosition = -1;
    private boolean isWaitForMove = false;
    private boolean isWaitForAdd = true;
    private boolean isWaitForRemove = false;
    private boolean isProcessWasSuccessful = false;
    private boolean isWaitForMoveSave;
    private boolean isWaitForAddSave;


    private Game game;
    private MoveSound play;

    private Board() {
        game = new Game();
        play = new MoveSound();
        initComponents();
        RedText.setVisible(false);
        BlueText.setText("Blue Can Add Stone");
        cleanDots();
    }


    private void ai_Action() {

        if (aiActive) {
            String nextState = game.nextState(blueCanRemove);

            switch (nextState) {
                case "add": {
                    int nextPosition = game.nextPositionAddRemove();
                    mouseClicked(nextPosition);
                    break;
                }
                case "move": {
                    int[] nextPosition = game.nextPositionMove();
                    break;
                }
                case "remove": {
                    int nextPosition = game.nextPositionAddRemove();
                    break;
                }
                default:
                    System.err.println("error in ai");
                    break;
            }
        }

    }

    private void ShowText(String txt, boolean isBlue) {
        if (isBlue) {
            RedText.setVisible(false);
            BlueText.setVisible(true);
            BlueText.setText(txt);
        } else {
            BlueText.setVisible(false);
            RedText.setVisible(true);
            RedText.setText(txt);
        }
    }

    private void cleanDots() {
        for (int i = 1; i <= 24; i++) {
            setDotVisible(i, true, false);
            setDotVisible(i, false, false);
        }
    }

    private void playMusic() {
        play = null;
        play = new MoveSound();
        play.start();
    }


    /**
     * clean a stone from stone pack
     */
    private void blueStonePackClean() {

        if (blueStonePack12.isVisible()) blueStonePack12.setVisible(false);
        else if (blueStonePack11.isVisible()) blueStonePack11.setVisible(false);
        else if (blueStonePack10.isVisible()) blueStonePack10.setVisible(false);
        else if (blueStonePack9.isVisible()) blueStonePack9.setVisible(false);
        else if (blueStonePack8.isVisible()) blueStonePack8.setVisible(false);
        else if (blueStonePack7.isVisible()) blueStonePack7.setVisible(false);
        else if (blueStonePack6.isVisible()) blueStonePack6.setVisible(false);
        else if (blueStonePack5.isVisible()) blueStonePack5.setVisible(false);
        else if (blueStonePack4.isVisible()) blueStonePack4.setVisible(false);
        else if (blueStonePack3.isVisible()) blueStonePack3.setVisible(false);
        else if (blueStonePack2.isVisible()) blueStonePack2.setVisible(false);
        else if (blueStonePack1.isVisible()) blueStonePack1.setVisible(false);
    }

    /**
     * clean a stone from stone pack
     */
    private void redStonePackClean() {
        if (redStonePack12.isVisible()) redStonePack12.setVisible(false);
        else if (redStonePack11.isVisible()) redStonePack11.setVisible(false);
        else if (redStonePack10.isVisible()) redStonePack10.setVisible(false);
        else if (redStonePack9.isVisible()) redStonePack9.setVisible(false);
        else if (redStonePack8.isVisible()) redStonePack8.setVisible(false);
        else if (redStonePack7.isVisible()) redStonePack7.setVisible(false);
        else if (redStonePack6.isVisible()) redStonePack6.setVisible(false);
        else if (redStonePack5.isVisible()) redStonePack5.setVisible(false);
        else if (redStonePack4.isVisible()) redStonePack4.setVisible(false);
        else if (redStonePack3.isVisible()) redStonePack3.setVisible(false);
        else if (redStonePack2.isVisible()) redStonePack2.setVisible(false);
        else if (redStonePack1.isVisible()) redStonePack1.setVisible(false);
    }

    /**
     * @param position position of the stone
     * @param isBlue   is it a blue stone or red one
     * @return a JLabel object of the stone on that position
     */
    private javax.swing.JLabel returnStone(int position, boolean isBlue) {
        if (isBlue) {
            if (position == 1) return blueStone1;
            if (position == 2) return blueStone2;
            if (position == 3) return blueStone3;
            if (position == 4) return blueStone4;
            if (position == 5) return blueStone5;
            if (position == 6) return blueStone6;
            if (position == 7) return blueStone7;
            if (position == 8) return blueStone8;
            if (position == 9) return blueStone9;
            if (position == 10) return blueStone10;
            if (position == 11) return blueStone11;
            if (position == 12) return blueStone12;
            if (position == 13) return blueStone13;
            if (position == 14) return blueStone14;
            if (position == 15) return blueStone15;
            if (position == 16) return blueStone16;
            if (position == 17) return blueStone17;
            if (position == 18) return blueStone18;
            if (position == 19) return blueStone19;
            if (position == 20) return blueStone20;
            if (position == 21) return blueStone21;
            if (position == 22) return blueStone22;
            if (position == 23) return blueStone23;
            if (position == 24) return blueStone24;
            return redStone1;
        } else {
            if (position == 1) return redStone1;
            if (position == 2) return redStone2;
            if (position == 3) return redStone3;
            if (position == 4) return redStone4;
            if (position == 5) return redStone5;
            if (position == 6) return redStone6;
            if (position == 7) return redStone7;
            if (position == 8) return redStone8;
            if (position == 9) return redStone9;
            if (position == 10) return redStone10;
            if (position == 11) return redStone11;
            if (position == 12) return redStone12;
            if (position == 13) return redStone13;
            if (position == 14) return redStone14;
            if (position == 15) return redStone15;
            if (position == 16) return redStone16;
            if (position == 17) return redStone17;
            if (position == 18) return redStone18;
            if (position == 19) return redStone19;
            if (position == 20) return redStone20;
            if (position == 21) return redStone21;
            if (position == 22) return redStone22;
            if (position == 23) return redStone23;
            if (position == 24) return redStone24;
            return redStone1;
        }
    }

    private void setStoneVisible(int position, boolean isBlue, boolean flag) {
        returnStone(position, isBlue).setVisible(flag);
    }

    private boolean isStoneVisible(int position, boolean isBlue) {
        return returnStone(position, isBlue).isVisible();
    }

    private javax.swing.JLabel returnDot(int position, boolean isWhite) {
        if (isWhite) {
            if (position == 1) return highlighter1;
            if (position == 2) return highlighter2;
            if (position == 3) return highlighter3;
            if (position == 4) return highlighter4;
            if (position == 5) return highlighter5;
            if (position == 6) return highlighter6;
            if (position == 7) return highlighter7;
            if (position == 8) return highlighter8;
            if (position == 9) return highlighter9;
            if (position == 10) return highlighter10;
            if (position == 11) return highlighter11;
            if (position == 12) return highlighter12;
            if (position == 13) return highlighter13;
            if (position == 14) return highlighter14;
            if (position == 15) return highlighter15;
            if (position == 16) return highlighter16;
            if (position == 17) return highlighter17;
            if (position == 18) return highlighter18;
            if (position == 19) return highlighter19;
            if (position == 20) return highlighter20;
            if (position == 21) return highlighter21;
            if (position == 22) return highlighter22;
            if (position == 23) return highlighter23;
            if (position == 24) return highlighter24;
            return highlighter23;
        } else {
            if (position == 1) return highlighter25;
            if (position == 2) return highlighter26;
            if (position == 3) return highlighter27;
            if (position == 4) return highlighter28;
            if (position == 5) return highlighter29;
            if (position == 6) return highlighter30;
            if (position == 7) return highlighter31;
            if (position == 8) return highlighter32;
            if (position == 9) return highlighter33;
            if (position == 10) return highlighter34;
            if (position == 11) return highlighter35;
            if (position == 12) return highlighter36;
            if (position == 13) return highlighter37;
            if (position == 14) return highlighter38;
            if (position == 15) return highlighter39;
            if (position == 16) return highlighter40;
            if (position == 17) return highlighter41;
            if (position == 18) return highlighter42;
            if (position == 19) return highlighter43;
            if (position == 20) return highlighter44;
            if (position == 21) return highlighter45;
            if (position == 22) return highlighter46;
            if (position == 23) return highlighter47;
            if (position == 24) return highlighter48;
            return highlighter1;
        }
    }

    private void setDotVisible(int position, boolean isWhite, boolean flag) {
        returnDot(position, isWhite).setVisible(flag);
    }

    private void move(int position) {
        LinkedList<Integer> connectedSpot = game.returnConnectedSpot(position);
        boolean moved = false;
        for (int i = 0; i < connectedSpot.size(); i++) {
            if (isMoveWaitColorBlue && game.isBlueTurn()) {
                if (movePosition == connectedSpot.get(i) && game.isGameBordEmpty(position)) {
                    game.moveBluePiece(connectedSpot.get(i), position);
                    setStoneVisible(connectedSpot.get(i), true, false);
                    setStoneVisible(position, true, true);
                    playMusic();
                    cleanDots();
                    if (game.isBlueWinInNextMove(position)) {
                        ShowText("blue can take a red stone", true);
                        blueCanRemove = true;
                        ai_Action();
                    } else {
                        ShowText("Wait for Red to move", false);
                    }
                    moved = true;
                    break;
                }
            } else if (!isMoveWaitColorBlue && !game.isBlueTurn()) {
                if (movePosition == connectedSpot.get(i) && game.isGameBordEmpty(position)) {
                    game.moveRedPiece(connectedSpot.get(i), position);
                    setStoneVisible(connectedSpot.get(i), false, false);
                    setStoneVisible(position, false, true);
                    playMusic();
                    cleanDots();
                    System.out.println(position);
                    if (game.isRedWinInNextMove(position)) {
                        ShowText("Red can take a blue stone", false);
                        redCanRemove = true;
                    } else {
                        ShowText("wait for blue to move", true);
                    }

                    ai_Action();
                    moved = true;
                    break;
                }
            }

        }
        if (!moved) System.out.println("Wrong entry");
        isWaitForMove = false;
    }

    private void waitForMove(int position) {
        if (game.isBlueCanMove() && isStoneVisible(position, true) && game.isBlueTurn()) {
            cleanDots();
            setDotVisible(position, false, true);
            for (int i = 0; i < game.returnEmptySpots(position).size(); i++) {
                setDotVisible((int) game.returnEmptySpots(position).get(i), true, true);
            }

            isWaitForMove = true;
            movePosition = position;
            isMoveWaitColorBlue = true;
        } else if (game.isRedCanMove() && isStoneVisible(position, false) && !game.isBlueTurn()) {

            cleanDots();
            setDotVisible(position, false, true);
            for (int i = 0; i < game.returnEmptySpots(position).size(); i++) {
                setDotVisible((int) game.returnEmptySpots(position).get(i), true, true);
            }

            isWaitForMove = true;
            movePosition = position;
            isMoveWaitColorBlue = false;
//            ShowText("wait for red for move", false);
//            System.out.println("wait for red for move " + movePosition);
        }
    }

    private void addStone_old(int position) {
        if (game.isBlueTurn() && !game.isBlueCanMove() && game.canAddStone(BLUE)) {

            game.addBluePiece(position);
            setStoneVisible(position, true, true);
            blueStonePackClean();
            playMusic();

            if (game.isBlueWinInNextMove(position)) {
                blueCanRemove = true;
                ShowText("blue can take a red stone", true);
                ai_Action();
            } else {
                if (game.isBlueCanMove()) {
                    ShowText("Red can move", false);
                } else {
                    ShowText("Red Can Add Stone", false);
                }
            }

        } else if (!game.isBlueTurn() && !game.isRedCanMove() && game.canAddStone(RED)) {

            game.addRedPiece(position);
            setStoneVisible(position, false, true);
            redStonePackClean();
            if (game.isRedWinInNextMove(position)) {
                redCanRemove = true;
                ShowText("red can take a blue stone", false);
            } else {
                if (game.isRedCanMove()) {
                    ShowText("blue can move", true);
                } else {
                    ShowText("Blue Can Add Stone", true);
                }
            }
            playMusic();
            ai_Action();
        }
    }


    private void DrawText() {
        RedText.setVisible(true);
        BlueText.setVisible(true);
        RedText.setText("Draw");
        BlueText.setText("Draw");
    }

//    private void _mouseClicked(int position) {
//
//        if (blueCanRemove) {
//            blueRemoveRedStone(position);
//        } else if (redCanRemove) {
//            redRemoveBlueStone(position);
//        } else if (game.isGameBordEmpty(position)) {
//            addStone(position);
//            if (game.isDraw()) {
//                DrawText();
//            }
//        } else if (!game.isGameBordEmpty(position)) {
//            waitForMove(position);
//        }
//        if (game.isBlueWin()) {
//            System.out.println("Blue wins");
//            ShowText("Blue wins", true);
//            return;
//        }
//        if (game.isRedWin()) {
//            System.out.println("Red wins");
//            ShowText("Red wins", false);
//        }
//
//    }
//
//    private void mouseClicked_old(int position) {
//        if (isFinished()) return;
//
//        if (isWaitForMove) {
//            move(position);
//        } else _mouseClicked(position);
//    }

    private boolean isFinished() {
        if (game.isBlueWin()) {
            System.out.println("Blue wins");
            ShowText("Blue wins", true);
            return true;
        }
        if (game.isRedWin()) {
            System.out.println("Red wins");
            ShowText("Red wins", false);
            return true;
        }
        if (game.isDraw()) {
            DrawText();
            return true;
        } else return false;
    }


    // ----------------------------------- this part of is going to rewrite ----------------------------------------- //


    private void mouseClicked(int position) {
        if (game.isGameBordEmpty(position)) {
            emptyClickedAction(position);
        } else {
            nonEmptyClickedAction(position);
        }
    }

    private void emptyClickedAction(int position) {
        if (isWaitForAdd) {
            addState(position);
        } else if (isWaitForMove) {
            //take the move second position
            moveState(position);
        } else {
            System.err.println("error in 'empty' state part: ");
            System.err.println("    >>>isWaitForAdd: " + isWaitForAdd);
            System.err.println("    >>>isWaitForMove: " + isWaitForMove);
            System.err.println("    >>>isWaitForRemove: " + isWaitForRemove);
        }
    }

    private void nonEmptyClickedAction(int position) {
        if (isWaitForRemove) {
            removeState(position);
        } else if (isWaitForMove) {
            //take the move first position
            moveState(position);
        } else {
            System.err.println("error in 'non empty' state part");
            System.err.println("    >>>isWaitForAdd: " + isWaitForAdd);
            System.err.println("    >>>isWaitForMove: " + isWaitForMove);
            System.err.println("    >>>isWaitForRemove: " + isWaitForRemove);
        }
    }

    private void addState(int position) {
        addStone(position);
        checkNextState();
    }

    private void moveState(int position) {
        if (movePosition == -1) {
            takeMovePosition(position);
        } else {
            moveTheStone(position);
            if (!isProcessWasSuccessful) resetTheMoveState();
        }
    }

    private void removeState(int position) {
        removeTheStone(position);
        if (isProcessWasSuccessful) resetTheRemoveState();
    }

    /**
     * reset the last state of game after successfully remove a stone
     */
    private void resetTheRemoveState() {
        isWaitForMove = isWaitForMoveSave;
        isWaitForAdd = isWaitForAddSave;
        isWaitForRemove = false;
        game.changeTheTurns();
    }

    /**
     * save the current state of the game and move to remove state
     */
    private void goToRemoveState() {
        //save the state
        if (isWaitForMove) isWaitForMoveSave = true;
        if (isWaitForAdd) isWaitForAddSave = true;
        isWaitForAdd = false;
        isWaitForMove = false;
        isWaitForRemove = true;
        isProcessWasSuccessful = false;

        //check the cleaning situation
        if (isDeletiableFromPack()) deleteFromPack();
    }

    private boolean isDeletiableFromPack() {
        if (game.isBlueTurn()) {
            if (game.isRedCanAdd()) return true;
        } else {
            if (game.isBlueCanAdd()) return true;
        }
        return false;
    }

    private void deleteFromPack() {
        if (game.isBlueTurn()) {
            game.removeRedPack();
            redStonePackClean();
            resetTheRemoveState();
        } else {
            game.removeBluePack();
            blueStonePackClean();
            resetTheRemoveState();
        }
    }

    private void resetTheMoveState() {
        movePosition = -1;
        cleanDots();
    }

    private void checkNextState() {
        // check if add state is finished and we enter the move state?
        if (!game.isRedCanAdd()) {
            isWaitForAdd = false;
            isWaitForMove = true;
            System.out.println("Move state now active");
        }
    }

    private void takeMovePosition(int position) {
        if (game.isBlueTurn() && game.isGameBordBlue(position)) {
            movePosition = position;
        } else if (!game.isBlueTurn() && game.isGameBordRed(position)) {
            movePosition = position;
        } else {
            System.err.println(">>> move first position");
            resetTheMoveState();
            return;
        }
        System.out.println("take the move first position :" + position);
        moveVisualDots(position);
    }

    private void moveTheStone(int position) {
        if (game.isBlueTurn() && game.isGameBordEmpty(position) && isConnected(movePosition, position)){

            game.moveBluePiece(movePosition, position);
            setStoneVisible(movePosition, true, false);
            setStoneVisible(position, true, true);

        } else if (!game.isBlueTurn() && game.isGameBordEmpty(position) && isConnected(movePosition, position)) {

            game.moveRedPiece(movePosition, position);
            setStoneVisible(movePosition, false, false);
            setStoneVisible(position, false, true);

        } else {
            System.err.println(">>> move second position");
            resetTheMoveState();
            return;
        }
        System.out.println("move the stone from " + movePosition + " to " + position);
        isProcessWasSuccessful = true;
        resetTheMoveState();
    }

    public boolean isConnected(int firstPosition, int secondPosition){
        int searchResult = game.returnConnectedSpot(firstPosition).indexOf(secondPosition);
        if (searchResult != -1){
            return true;
        }else return false;
    }

    private void moveVisualDots(int position){
        setDotVisible(position, false, true);
        for (int i = 0; i < game.returnEmptySpots(position).size(); i++) {
            setDotVisible((int) game.returnEmptySpots(position).get(i), true, true);
        }
    }

    private void removeTheStone(int position) {
        if (game.isBlueTurn()) {
            blueRemoveRedStone(position);
        } else {
            redRemoveBlueStone(position);
        }
    }

    private void addStone(int position) {
        if (game.isBlueTurn()) {
            addBlueStone(position);
        } else {
            addRedStone(position);
        }
    }

    private void addRedStone(int position) {
        game.addRedPiece(position);
        setStoneVisible(position, false, true);
        redStonePackClean();
        playMusic();

        if (game.isRedWinInNextMove(position)) {
            goToRemoveState();
            System.out.println("red Win: remove state");
        } else {
            game.changeTheTurns();
        }
    }

    private void addBlueStone(int position) {
        game.addBluePiece(position);
        setStoneVisible(position, true, true);
        blueStonePackClean();
        playMusic();

        if (game.isBlueWinInNextMove(position)) {
            System.out.println("blue win: remove state");
            goToRemoveState();
        } else {
            game.changeTheTurns();
        }
    }

    private void redRemoveBlueStone(int position) {
        if (game.isGameBordBlue(position)) {
            game.removeBluePiece(position);
            setStoneVisible(position, true, false);
            isProcessWasSuccessful = true;

            System.out.println("blue stone removed");
        } else {
            System.err.println("click on blue stone!");
        }
    }

    private void blueRemoveRedStone(int position) {
        if (game.isGameBordRed(position)) {
            game.removeRedPiece(position);
            setStoneVisible(position, false, false);
            isProcessWasSuccessful = true;

            System.out.println("red stone removed");
        } else {
            System.err.println("click on red stone");
        }

    }

    // ----------------------------------------------- end of part  ------------------------------------------------- //

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BlueText = new javax.swing.JLabel();
        RedText = new javax.swing.JLabel();
        position1 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position2 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position3 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position4 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position5 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position6 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position7 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position8 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position9 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position10 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position11 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position12 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position13 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position14 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position15 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position16 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position17 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position18 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position19 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position20 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position21 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position22 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position23 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        position24 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50), new java.awt.Dimension(50, 50));
        highlighter1 = new javax.swing.JLabel();
        highlighter2 = new javax.swing.JLabel();
        highlighter3 = new javax.swing.JLabel();
        highlighter4 = new javax.swing.JLabel();
        highlighter5 = new javax.swing.JLabel();
        highlighter6 = new javax.swing.JLabel();
        highlighter7 = new javax.swing.JLabel();
        highlighter8 = new javax.swing.JLabel();
        highlighter9 = new javax.swing.JLabel();
        highlighter11 = new javax.swing.JLabel();
        highlighter10 = new javax.swing.JLabel();
        highlighter12 = new javax.swing.JLabel();
        highlighter13 = new javax.swing.JLabel();
        highlighter14 = new javax.swing.JLabel();
        highlighter15 = new javax.swing.JLabel();
        highlighter16 = new javax.swing.JLabel();
        highlighter17 = new javax.swing.JLabel();
        highlighter18 = new javax.swing.JLabel();
        highlighter19 = new javax.swing.JLabel();
        highlighter20 = new javax.swing.JLabel();
        highlighter21 = new javax.swing.JLabel();
        highlighter22 = new javax.swing.JLabel();
        highlighter23 = new javax.swing.JLabel();
        highlighter24 = new javax.swing.JLabel();
        highlighter25 = new javax.swing.JLabel();
        highlighter26 = new javax.swing.JLabel();
        highlighter27 = new javax.swing.JLabel();
        highlighter28 = new javax.swing.JLabel();
        highlighter29 = new javax.swing.JLabel();
        highlighter30 = new javax.swing.JLabel();
        highlighter31 = new javax.swing.JLabel();
        highlighter32 = new javax.swing.JLabel();
        highlighter33 = new javax.swing.JLabel();
        highlighter34 = new javax.swing.JLabel();
        highlighter35 = new javax.swing.JLabel();
        highlighter36 = new javax.swing.JLabel();
        highlighter37 = new javax.swing.JLabel();
        highlighter38 = new javax.swing.JLabel();
        highlighter39 = new javax.swing.JLabel();
        highlighter40 = new javax.swing.JLabel();
        highlighter41 = new javax.swing.JLabel();
        highlighter42 = new javax.swing.JLabel();
        highlighter43 = new javax.swing.JLabel();
        highlighter44 = new javax.swing.JLabel();
        highlighter45 = new javax.swing.JLabel();
        highlighter46 = new javax.swing.JLabel();
        highlighter47 = new javax.swing.JLabel();
        highlighter48 = new javax.swing.JLabel();
        redStone1 = new javax.swing.JLabel();
        redStone2 = new javax.swing.JLabel();
        redStone3 = new javax.swing.JLabel();
        redStone4 = new javax.swing.JLabel();
        redStone5 = new javax.swing.JLabel();
        redStone6 = new javax.swing.JLabel();
        redStone7 = new javax.swing.JLabel();
        redStone8 = new javax.swing.JLabel();
        redStone9 = new javax.swing.JLabel();
        redStone10 = new javax.swing.JLabel();
        redStone11 = new javax.swing.JLabel();
        redStone12 = new javax.swing.JLabel();
        redStone13 = new javax.swing.JLabel();
        redStone14 = new javax.swing.JLabel();
        redStone15 = new javax.swing.JLabel();
        redStone16 = new javax.swing.JLabel();
        redStone17 = new javax.swing.JLabel();
        redStone18 = new javax.swing.JLabel();
        redStone19 = new javax.swing.JLabel();
        redStone20 = new javax.swing.JLabel();
        redStone21 = new javax.swing.JLabel();
        redStone22 = new javax.swing.JLabel();
        redStone23 = new javax.swing.JLabel();
        redStone24 = new javax.swing.JLabel();
        redStonePack1 = new javax.swing.JLabel();
        redStonePack2 = new javax.swing.JLabel();
        redStonePack3 = new javax.swing.JLabel();
        redStonePack4 = new javax.swing.JLabel();
        redStonePack5 = new javax.swing.JLabel();
        redStonePack6 = new javax.swing.JLabel();
        redStonePack7 = new javax.swing.JLabel();
        redStonePack8 = new javax.swing.JLabel();
        redStonePack9 = new javax.swing.JLabel();
        redStonePack10 = new javax.swing.JLabel();
        redStonePack11 = new javax.swing.JLabel();
        redStonePack12 = new javax.swing.JLabel();
        blueStone1 = new javax.swing.JLabel();
        blueStone2 = new javax.swing.JLabel();
        blueStone3 = new javax.swing.JLabel();
        blueStone4 = new javax.swing.JLabel();
        blueStone5 = new javax.swing.JLabel();
        blueStone6 = new javax.swing.JLabel();
        blueStone7 = new javax.swing.JLabel();
        blueStone8 = new javax.swing.JLabel();
        blueStone9 = new javax.swing.JLabel();
        blueStone10 = new javax.swing.JLabel();
        blueStone11 = new javax.swing.JLabel();
        blueStone12 = new javax.swing.JLabel();
        blueStone13 = new javax.swing.JLabel();
        blueStone14 = new javax.swing.JLabel();
        blueStone15 = new javax.swing.JLabel();
        blueStone16 = new javax.swing.JLabel();
        blueStone17 = new javax.swing.JLabel();
        blueStone18 = new javax.swing.JLabel();
        blueStone19 = new javax.swing.JLabel();
        blueStone20 = new javax.swing.JLabel();
        blueStone21 = new javax.swing.JLabel();
        blueStone22 = new javax.swing.JLabel();
        blueStone23 = new javax.swing.JLabel();
        blueStone24 = new javax.swing.JLabel();
        blueStonePack1 = new javax.swing.JLabel();
        blueStonePack2 = new javax.swing.JLabel();
        blueStonePack3 = new javax.swing.JLabel();
        blueStonePack4 = new javax.swing.JLabel();
        blueStonePack5 = new javax.swing.JLabel();
        blueStonePack6 = new javax.swing.JLabel();
        blueStonePack7 = new javax.swing.JLabel();
        blueStonePack8 = new javax.swing.JLabel();
        blueStonePack9 = new javax.swing.JLabel();
        blueStonePack10 = new javax.swing.JLabel();
        blueStonePack11 = new javax.swing.JLabel();
        blueStonePack12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game");
        setMinimumSize(new java.awt.Dimension(1400, 968));
        setResizable(false);
        getContentPane().setLayout(null);

        BlueText.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        BlueText.setForeground(new java.awt.Color(0, 0, 252));
        BlueText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BlueText.setText("Blue Can move");
        getContentPane().add(BlueText);
        BlueText.setBounds(30, 880, 450, 30);

        RedText.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        RedText.setForeground(new java.awt.Color(255, 0, 51));
        RedText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RedText.setText("Red Can move");
        getContentPane().add(RedText);
        RedText.setBounds(930, 880, 450, 30);

        position1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position1MouseClicked(evt);
            }
        });
        getContentPane().add(position1);
        position1.setBounds(420, 60, 50, 50);

        position2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position2MouseClicked(evt);
            }
        });
        getContentPane().add(position2);
        position2.setBounds(670, 60, 50, 50);

        position3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position3MouseClicked(evt);
            }
        });
        getContentPane().add(position3);
        position3.setBounds(925, 60, 50, 50);

        position4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position4MouseClicked(evt);
            }
        });
        getContentPane().add(position4);
        position4.setBounds(495, 130, 50, 50);

        position5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position5MouseClicked(evt);
            }
        });
        getContentPane().add(position5);
        position5.setBounds(670, 130, 50, 50);

        position6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position6MouseClicked(evt);
            }
        });
        getContentPane().add(position6);
        position6.setBounds(855, 130, 50, 50);

        position7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position7MouseClicked(evt);
            }
        });
        getContentPane().add(position7);
        position7.setBounds(565, 205, 50, 50);

        position8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position8MouseClicked(evt);
            }
        });
        getContentPane().add(position8);
        position8.setBounds(670, 205, 50, 50);

        position9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position9MouseClicked(evt);
            }
        });
        getContentPane().add(position9);
        position9.setBounds(782, 205, 50, 50);

        position10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position10MouseClicked(evt);
            }
        });
        getContentPane().add(position10);
        position10.setBounds(420, 445, 50, 50);

        position11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position11MouseClicked(evt);
            }
        });
        getContentPane().add(position11);
        position11.setBounds(490, 445, 50, 50);

        position12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position12MouseClicked(evt);
            }
        });
        getContentPane().add(position12);
        position12.setBounds(570, 445, 50, 50);

        position13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position13MouseClicked(evt);
            }
        });
        getContentPane().add(position13);
        position13.setBounds(780, 450, 50, 50);

        position14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position14MouseClicked(evt);
            }
        });
        getContentPane().add(position14);
        position14.setBounds(855, 450, 50, 50);

        position15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position15MouseClicked(evt);
            }
        });
        getContentPane().add(position15);
        position15.setBounds(930, 450, 50, 50);

        position16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position16MouseClicked(evt);
            }
        });
        getContentPane().add(position16);
        position16.setBounds(565, 670, 50, 50);

        position17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position17MouseClicked(evt);
            }
        });
        getContentPane().add(position17);
        position17.setBounds(670, 670, 50, 50);

        position18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position18MouseClicked(evt);
            }
        });
        getContentPane().add(position18);
        position18.setBounds(780, 670, 50, 50);

        position19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position19MouseClicked(evt);
            }
        });
        getContentPane().add(position19);
        position19.setBounds(495, 750, 50, 50);

        position20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position20MouseClicked(evt);
            }
        });
        getContentPane().add(position20);
        position20.setBounds(672, 750, 50, 50);

        position21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position21MouseClicked(evt);
            }
        });
        getContentPane().add(position21);
        position21.setBounds(855, 750, 50, 50);

        position22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position22MouseClicked(evt);
            }
        });
        getContentPane().add(position22);
        position22.setBounds(420, 825, 50, 50);

        position23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position23MouseClicked(evt);
            }
        });
        getContentPane().add(position23);
        position23.setBounds(670, 825, 50, 50);

        position24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                position24MouseClicked(evt);
            }
        });
        getContentPane().add(position24);
        position24.setBounds(920, 825, 50, 50);

        highlighter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter1);
        highlighter1.setBounds(438, 73, 20, 20);

        highlighter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter2);
        highlighter2.setBounds(690, 73, 20, 20);

        highlighter3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter3);
        highlighter3.setBounds(942, 73, 20, 20);

        highlighter4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter4);
        highlighter4.setBounds(511, 145, 20, 20);

        highlighter5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter5);
        highlighter5.setBounds(690, 145, 20, 20);

        highlighter6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter6);
        highlighter6.setBounds(873, 145, 20, 20);

        highlighter7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter7);
        highlighter7.setBounds(584, 218, 20, 20);

        highlighter8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter8);
        highlighter8.setBounds(690, 218, 20, 20);

        highlighter9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter9);
        highlighter9.setBounds(800, 218, 20, 20);

        highlighter11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter11);
        highlighter11.setBounds(511, 460, 20, 20);

        highlighter10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter10);
        highlighter10.setBounds(438, 460, 20, 20);

        highlighter12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter12);
        highlighter12.setBounds(584, 460, 20, 20);

        highlighter13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter13);
        highlighter13.setBounds(800, 464, 20, 20);

        highlighter14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter14);
        highlighter14.setBounds(873, 464, 20, 20);

        highlighter15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter15);
        highlighter15.setBounds(945, 464, 20, 20);

        highlighter16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter16);
        highlighter16.setBounds(584, 685, 20, 20);

        highlighter17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter17);
        highlighter17.setBounds(690, 685, 20, 20);

        highlighter18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter18);
        highlighter18.setBounds(800, 685, 20, 20);

        highlighter19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter19);
        highlighter19.setBounds(511, 763, 20, 20);

        highlighter20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter20);
        highlighter20.setBounds(690, 763, 20, 20);

        highlighter21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter21);
        highlighter21.setBounds(873, 763, 20, 20);

        highlighter22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter22);
        highlighter22.setBounds(438, 840, 20, 20);

        highlighter23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter23);
        highlighter23.setBounds(690, 840, 20, 20);

        highlighter24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter.png"))); // NOI18N
        getContentPane().add(highlighter24);
        highlighter24.setBounds(942, 840, 20, 20);

        highlighter25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter25);
        highlighter25.setBounds(438, 73, 20, 20);

        highlighter26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter26);
        highlighter26.setBounds(690, 73, 20, 20);

        highlighter27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter27);
        highlighter27.setBounds(942, 73, 20, 20);

        highlighter28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter28);
        highlighter28.setBounds(511, 145, 20, 20);

        highlighter29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter29);
        highlighter29.setBounds(690, 145, 20, 20);

        highlighter30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter30);
        highlighter30.setBounds(873, 145, 20, 20);

        highlighter31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter31);
        highlighter31.setBounds(584, 218, 20, 20);

        highlighter32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter32);
        highlighter32.setBounds(690, 218, 20, 20);

        highlighter33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter33);
        highlighter33.setBounds(800, 218, 20, 20);

        highlighter34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter34);
        highlighter34.setBounds(511, 460, 20, 20);

        highlighter35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter35);
        highlighter35.setBounds(438, 460, 20, 20);

        highlighter36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter36);
        highlighter36.setBounds(584, 460, 20, 20);

        highlighter37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter37);
        highlighter37.setBounds(800, 464, 20, 20);

        highlighter38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter38);
        highlighter38.setBounds(873, 464, 20, 20);

        highlighter39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter39);
        highlighter39.setBounds(945, 464, 20, 20);

        highlighter40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter40);
        highlighter40.setBounds(584, 685, 20, 20);

        highlighter41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter41);
        highlighter41.setBounds(690, 685, 20, 20);

        highlighter42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter42);
        highlighter42.setBounds(800, 685, 20, 20);

        highlighter43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter43);
        highlighter43.setBounds(511, 763, 20, 20);

        highlighter44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter44);
        highlighter44.setBounds(690, 763, 20, 20);

        highlighter45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter45);
        highlighter45.setBounds(873, 763, 20, 20);

        highlighter46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter46);
        highlighter46.setBounds(438, 840, 20, 20);

        highlighter47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter47);
        highlighter47.setBounds(690, 840, 20, 20);

        highlighter48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/highlighter2.png"))); // NOI18N
        getContentPane().add(highlighter48);
        highlighter48.setBounds(942, 840, 20, 20);

        redStone1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone1.setText("jLabel2");
        getContentPane().add(redStone1);
        redStone1.setBounds(422, 58, 50, 50);
        redStone1.setVisible(false);

        redStone2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone2.setText("jLabel2");
        getContentPane().add(redStone2);
        redStone2.setBounds(674, 58, 50, 50);
        redStone2.setVisible(false);

        redStone3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone3.setText("jLabel2");
        getContentPane().add(redStone3);
        redStone3.setBounds(926, 58, 50, 50);
        redStone3.setVisible(false);

        redStone4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone4.setText("jLabel2");
        getContentPane().add(redStone4);
        redStone4.setBounds(495, 130, 50, 50);
        redStone4.setVisible(false);

        redStone5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone5.setText("jLabel2");
        getContentPane().add(redStone5);
        redStone5.setBounds(674, 131, 50, 50);
        redStone5.setVisible(false);

        redStone6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone6.setText("jLabel2");
        getContentPane().add(redStone6);
        redStone6.setBounds(858, 130, 50, 50);
        redStone6.setVisible(false);

        redStone7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone7.setText("jLabel2");
        getContentPane().add(redStone7);
        redStone7.setBounds(568, 203, 50, 50);
        redStone7.setVisible(false);

        redStone8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone8.setText("jLabel2");
        getContentPane().add(redStone8);
        redStone8.setBounds(674, 203, 50, 50);
        redStone8.setVisible(false);

        redStone9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone9.setText("jLabel2");
        getContentPane().add(redStone9);
        redStone9.setBounds(784, 203, 50, 50);
        redStone9.setVisible(false);

        redStone10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone10.setText("jLabel2");
        getContentPane().add(redStone10);
        redStone10.setBounds(422, 445, 50, 50);
        redStone10.setVisible(false);

        redStone11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone11.setText("jLabel2");
        getContentPane().add(redStone11);
        redStone11.setBounds(495, 445, 50, 50);
        redStone11.setVisible(false);

        redStone12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone12.setText("jLabel2");
        getContentPane().add(redStone12);
        redStone12.setBounds(568, 445, 50, 50);
        redStone12.setVisible(false);

        redStone13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone13.setText("jLabel2");
        getContentPane().add(redStone13);
        redStone13.setBounds(784, 448, 50, 50);
        redStone13.setVisible(false);

        redStone14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone14.setText("jLabel2");
        getContentPane().add(redStone14);
        redStone14.setBounds(858, 448, 50, 50);
        redStone14.setVisible(false);

        redStone15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone15.setText("jLabel2");
        getContentPane().add(redStone15);
        redStone15.setBounds(930, 448, 50, 50);
        redStone15.setVisible(false);

        redStone16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone16.setText("jLabel2");
        getContentPane().add(redStone16);
        redStone16.setBounds(568, 670, 50, 50);
        redStone16.setVisible(false);

        redStone17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone17.setText("jLabel2");
        getContentPane().add(redStone17);
        redStone17.setBounds(674, 670, 50, 50);
        redStone17.setVisible(false);

        redStone18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone18.setText("jLabel2");
        getContentPane().add(redStone18);
        redStone18.setBounds(784, 670, 50, 50);
        redStone18.setVisible(false);

        redStone19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone19.setText("jLabel2");
        getContentPane().add(redStone19);
        redStone19.setBounds(495, 748, 50, 50);
        redStone19.setVisible(false);

        redStone20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone20.setText("jLabel2");
        getContentPane().add(redStone20);
        redStone20.setBounds(674, 748, 50, 50);
        redStone20.setVisible(false);

        redStone21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone21.setText("jLabel2");
        getContentPane().add(redStone21);
        redStone21.setBounds(857, 748, 50, 50);
        redStone21.setVisible(false);

        redStone22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone22.setText("jLabel2");
        getContentPane().add(redStone22);
        redStone22.setBounds(422, 825, 50, 50);
        redStone22.setVisible(false);

        redStone23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone23.setText("jLabel2");
        getContentPane().add(redStone23);
        redStone23.setBounds(674, 825, 50, 50);
        redStone23.setVisible(false);

        redStone24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStone24.setText("jLabel2");
        getContentPane().add(redStone24);
        redStone24.setBounds(926, 825, 50, 50);
        redStone24.setVisible(false);

        redStonePack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack1.setText("jLabel2");
        getContentPane().add(redStonePack1);
        redStonePack1.setBounds(1100, 70, 50, 50);
        redStone6.setVisible(false);

        redStonePack2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack2.setText("jLabel2");
        getContentPane().add(redStonePack2);
        redStonePack2.setBounds(1155, 70, 50, 50);
        redStone6.setVisible(false);

        redStonePack3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack3.setText("jLabel2");
        getContentPane().add(redStonePack3);
        redStonePack3.setBounds(1210, 70, 50, 50);
        redStone6.setVisible(false);

        redStonePack4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack4.setText("jLabel2");
        getContentPane().add(redStonePack4);
        redStonePack4.setBounds(1265, 70, 50, 50);
        redStone6.setVisible(false);

        redStonePack5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack5.setText("jLabel2");
        getContentPane().add(redStonePack5);
        redStonePack5.setBounds(1100, 123, 50, 50);
        redStone6.setVisible(false);

        redStonePack6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack6.setText("jLabel2");
        getContentPane().add(redStonePack6);
        redStonePack6.setBounds(1155, 123, 50, 50);
        redStone6.setVisible(false);

        redStonePack7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack7.setText("jLabel2");
        getContentPane().add(redStonePack7);
        redStonePack7.setBounds(1210, 123, 50, 50);
        redStone6.setVisible(false);

        redStonePack8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack8.setText("jLabel2");
        getContentPane().add(redStonePack8);
        redStonePack8.setBounds(1265, 123, 50, 50);
        redStone6.setVisible(false);

        redStonePack9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack9.setText("jLabel2");
        getContentPane().add(redStonePack9);
        redStonePack9.setBounds(1100, 175, 50, 50);
        redStone6.setVisible(false);

        redStonePack10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack10.setText("jLabel2");
        getContentPane().add(redStonePack10);
        redStonePack10.setBounds(1155, 175, 50, 50);
        redStone6.setVisible(false);

        redStonePack11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack11.setText("jLabel2");
        getContentPane().add(redStonePack11);
        redStonePack11.setBounds(1210, 175, 50, 50);
        redStone6.setVisible(false);

        redStonePack12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone2.png"))); // NOI18N
        redStonePack12.setText("jLabel2");
        getContentPane().add(redStonePack12);
        redStonePack12.setBounds(1265, 175, 50, 50);
        redStone6.setVisible(false);

        blueStone1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone1.setText("jLabel3");
        getContentPane().add(blueStone1);
        blueStone1.setBounds(422, 60, 50, 47);
        blueStone1.setVisible(false);

        blueStone2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone2.setText("jLabel3");
        getContentPane().add(blueStone2);
        blueStone2.setBounds(674, 60, 50, 47);
        blueStone2.setVisible(false);

        blueStone3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone3.setText("jLabel3");
        getContentPane().add(blueStone3);
        blueStone3.setBounds(925, 60, 50, 47);
        blueStone3.setVisible(false);

        blueStone4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone4.setText("jLabel3");
        getContentPane().add(blueStone4);
        blueStone4.setBounds(495, 132, 50, 47);
        blueStone4.setVisible(false);

        blueStone5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone5.setText("jLabel3");
        getContentPane().add(blueStone5);
        blueStone5.setBounds(674, 132, 50, 47);
        blueStone5.setVisible(false);

        blueStone6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone6.setText("jLabel3");
        getContentPane().add(blueStone6);
        blueStone6.setBounds(857, 132, 50, 47);
        blueStone6.setVisible(false);

        blueStone7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone7.setText("jLabel3");
        getContentPane().add(blueStone7);
        blueStone7.setBounds(568, 205, 50, 47);
        blueStone7.setVisible(false);

        blueStone8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone8.setText("jLabel3");
        getContentPane().add(blueStone8);
        blueStone8.setBounds(673, 205, 50, 47);
        blueStone8.setVisible(false);

        blueStone9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone9.setText("jLabel3");
        getContentPane().add(blueStone9);
        blueStone9.setBounds(784, 205, 50, 47);
        blueStone9.setVisible(false);

        blueStone10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone10.setText("jLabel3");
        getContentPane().add(blueStone10);
        blueStone10.setBounds(422, 447, 50, 47);
        blueStone10.setVisible(false);

        blueStone11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone11.setText("jLabel3");
        getContentPane().add(blueStone11);
        blueStone11.setBounds(495, 447, 50, 47);
        blueStone11.setVisible(false);

        blueStone12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone12.setText("jLabel3");
        getContentPane().add(blueStone12);
        blueStone12.setBounds(568, 447, 50, 47);
        blueStone12.setVisible(false);

        blueStone13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone13.setText("jLabel3");
        getContentPane().add(blueStone13);
        blueStone13.setBounds(784, 450, 50, 47);
        blueStone13.setVisible(false);

        blueStone14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone14.setText("jLabel3");
        getContentPane().add(blueStone14);
        blueStone14.setBounds(858, 450, 50, 47);
        blueStone14.setVisible(false);

        blueStone15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone15.setText("jLabel3");
        getContentPane().add(blueStone15);
        blueStone15.setBounds(930, 450, 50, 47);
        blueStone15.setVisible(false);

        blueStone16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone16.setText("jLabel3");
        getContentPane().add(blueStone16);
        blueStone16.setBounds(568, 673, 50, 47);
        blueStone16.setVisible(false);

        blueStone17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone17.setText("jLabel3");
        getContentPane().add(blueStone17);
        blueStone17.setBounds(673, 673, 50, 47);
        blueStone17.setVisible(false);

        blueStone18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone18.setText("jLabel3");
        getContentPane().add(blueStone18);
        blueStone18.setBounds(784, 673, 50, 47);
        blueStone18.setVisible(false);

        blueStone19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone19.setText("jLabel3");
        getContentPane().add(blueStone19);
        blueStone19.setBounds(495, 750, 50, 47);
        blueStone19.setVisible(false);

        blueStone20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone20.setText("jLabel3");
        getContentPane().add(blueStone20);
        blueStone20.setBounds(673, 750, 50, 47);
        blueStone20.setVisible(false);

        blueStone21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone21.setText("jLabel3");
        getContentPane().add(blueStone21);
        blueStone21.setBounds(857, 750, 50, 47);
        blueStone21.setVisible(false);

        blueStone22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone22.setText("jLabel3");
        getContentPane().add(blueStone22);
        blueStone22.setBounds(422, 827, 50, 47);
        blueStone22.setVisible(false);

        blueStone23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone23.setText("jLabel3");
        getContentPane().add(blueStone23);
        blueStone23.setBounds(673, 827, 50, 47);
        blueStone23.setVisible(false);

        blueStone24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStone24.setText("jLabel3");
        getContentPane().add(blueStone24);
        blueStone24.setBounds(925, 827, 50, 47);
        blueStone24.setVisible(false);

        blueStonePack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack1.setText("jLabel3");
        getContentPane().add(blueStonePack1);
        blueStonePack1.setBounds(100, 66, 50, 47);

        blueStonePack2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack2.setText("jLabel3");
        getContentPane().add(blueStonePack2);
        blueStonePack2.setBounds(153, 66, 50, 47);

        blueStonePack3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack3.setText("jLabel3");
        getContentPane().add(blueStonePack3);
        blueStonePack3.setBounds(207, 66, 50, 47);

        blueStonePack4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack4.setText("jLabel3");
        getContentPane().add(blueStonePack4);
        blueStonePack4.setBounds(260, 66, 50, 47);

        blueStonePack5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack5.setText("jLabel3");
        getContentPane().add(blueStonePack5);
        blueStonePack5.setBounds(100, 120, 50, 47);

        blueStonePack6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack6.setText("jLabel3");
        getContentPane().add(blueStonePack6);
        blueStonePack6.setBounds(153, 120, 50, 47);

        blueStonePack7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack7.setText("jLabel3");
        getContentPane().add(blueStonePack7);
        blueStonePack7.setBounds(207, 120, 50, 47);

        blueStonePack8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack8.setText("jLabel3");
        getContentPane().add(blueStonePack8);
        blueStonePack8.setBounds(260, 120, 50, 47);

        blueStonePack9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack9.setText("jLabel3");
        getContentPane().add(blueStonePack9);
        blueStonePack9.setBounds(100, 174, 50, 47);

        blueStonePack10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack10.setText("jLabel3");
        getContentPane().add(blueStonePack10);
        blueStonePack10.setBounds(153, 174, 50, 47);

        blueStonePack11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack11.setText("jLabel3");
        getContentPane().add(blueStonePack11);
        blueStonePack11.setBounds(207, 174, 50, 47);

        blueStonePack12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stone1.png"))); // NOI18N
        blueStonePack12.setText("jLabel3");
        getContentPane().add(blueStonePack12);
        blueStonePack12.setBounds(260, 174, 50, 47);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/board.jpg"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1400, 933);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void position1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position1MouseClicked
        mouseClicked(1);
    }//GEN-LAST:event_position1MouseClicked

    private void position2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position2MouseClicked
        mouseClicked(2);
    }//GEN-LAST:event_position2MouseClicked

    private void position3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position3MouseClicked
        mouseClicked(3);
    }//GEN-LAST:event_position3MouseClicked

    private void position4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position4MouseClicked
        mouseClicked(4);
    }//GEN-LAST:event_position4MouseClicked

    private void position5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position5MouseClicked
        mouseClicked(5);
    }//GEN-LAST:event_position5MouseClicked

    private void position6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position6MouseClicked
        mouseClicked(6);
    }//GEN-LAST:event_position6MouseClicked

    private void position7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position7MouseClicked
        mouseClicked(7);
    }//GEN-LAST:event_position7MouseClicked

    private void position8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position8MouseClicked
        mouseClicked(8);
    }//GEN-LAST:event_position8MouseClicked

    private void position9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position9MouseClicked
        mouseClicked(9);
    }//GEN-LAST:event_position9MouseClicked

    private void position10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position10MouseClicked
        mouseClicked(10);
    }//GEN-LAST:event_position10MouseClicked

    private void position11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position11MouseClicked
        mouseClicked(11);
    }//GEN-LAST:event_position11MouseClicked

    private void position12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position12MouseClicked
        mouseClicked(12);
    }//GEN-LAST:event_position12MouseClicked

    private void position13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position13MouseClicked
        mouseClicked(13);
    }//GEN-LAST:event_position13MouseClicked

    private void position14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position14MouseClicked
        mouseClicked(14);
    }//GEN-LAST:event_position14MouseClicked

    private void position15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position15MouseClicked
        mouseClicked(15);
    }//GEN-LAST:event_position15MouseClicked

    private void position16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position16MouseClicked
        mouseClicked(16);
    }//GEN-LAST:event_position16MouseClicked

    private void position17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position17MouseClicked
        mouseClicked(17);
    }//GEN-LAST:event_position17MouseClicked

    private void position18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position18MouseClicked
        mouseClicked(18);
    }//GEN-LAST:event_position18MouseClicked

    private void position19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position19MouseClicked
        mouseClicked(19);
    }//GEN-LAST:event_position19MouseClicked

    private void position20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position20MouseClicked
        mouseClicked(20);
    }//GEN-LAST:event_position20MouseClicked

    private void position21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position21MouseClicked
        mouseClicked(21);
    }//GEN-LAST:event_position21MouseClicked

    private void position22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position22MouseClicked
        mouseClicked(22);
    }//GEN-LAST:event_position22MouseClicked

    private void position23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position23MouseClicked
        mouseClicked(23);
    }//GEN-LAST:event_position23MouseClicked

    private void position24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_position24MouseClicked
        mouseClicked(24);
    }//GEN-LAST:event_position24MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BlueText;
    private javax.swing.JLabel RedText;
    private javax.swing.JLabel blueStone1;
    private javax.swing.JLabel blueStone10;
    private javax.swing.JLabel blueStone11;
    private javax.swing.JLabel blueStone12;
    private javax.swing.JLabel blueStone13;
    private javax.swing.JLabel blueStone14;
    private javax.swing.JLabel blueStone15;
    private javax.swing.JLabel blueStone16;
    private javax.swing.JLabel blueStone17;
    private javax.swing.JLabel blueStone18;
    private javax.swing.JLabel blueStone19;
    private javax.swing.JLabel blueStone2;
    private javax.swing.JLabel blueStone20;
    private javax.swing.JLabel blueStone21;
    private javax.swing.JLabel blueStone22;
    private javax.swing.JLabel blueStone23;
    private javax.swing.JLabel blueStone24;
    private javax.swing.JLabel blueStone3;
    private javax.swing.JLabel blueStone4;
    private javax.swing.JLabel blueStone5;
    private javax.swing.JLabel blueStone6;
    private javax.swing.JLabel blueStone7;
    private javax.swing.JLabel blueStone8;
    private javax.swing.JLabel blueStone9;
    private javax.swing.JLabel blueStonePack1;
    private javax.swing.JLabel blueStonePack10;
    private javax.swing.JLabel blueStonePack11;
    private javax.swing.JLabel blueStonePack12;
    private javax.swing.JLabel blueStonePack2;
    private javax.swing.JLabel blueStonePack3;
    private javax.swing.JLabel blueStonePack4;
    private javax.swing.JLabel blueStonePack5;
    private javax.swing.JLabel blueStonePack6;
    private javax.swing.JLabel blueStonePack7;
    private javax.swing.JLabel blueStonePack8;
    private javax.swing.JLabel blueStonePack9;
    private javax.swing.JLabel highlighter1;
    private javax.swing.JLabel highlighter10;
    private javax.swing.JLabel highlighter11;
    private javax.swing.JLabel highlighter12;
    private javax.swing.JLabel highlighter13;
    private javax.swing.JLabel highlighter14;
    private javax.swing.JLabel highlighter15;
    private javax.swing.JLabel highlighter16;
    private javax.swing.JLabel highlighter17;
    private javax.swing.JLabel highlighter18;
    private javax.swing.JLabel highlighter19;
    private javax.swing.JLabel highlighter2;
    private javax.swing.JLabel highlighter20;
    private javax.swing.JLabel highlighter21;
    private javax.swing.JLabel highlighter22;
    private javax.swing.JLabel highlighter23;
    private javax.swing.JLabel highlighter24;
    private javax.swing.JLabel highlighter25;
    private javax.swing.JLabel highlighter26;
    private javax.swing.JLabel highlighter27;
    private javax.swing.JLabel highlighter28;
    private javax.swing.JLabel highlighter29;
    private javax.swing.JLabel highlighter3;
    private javax.swing.JLabel highlighter30;
    private javax.swing.JLabel highlighter31;
    private javax.swing.JLabel highlighter32;
    private javax.swing.JLabel highlighter33;
    private javax.swing.JLabel highlighter34;
    private javax.swing.JLabel highlighter35;
    private javax.swing.JLabel highlighter36;
    private javax.swing.JLabel highlighter37;
    private javax.swing.JLabel highlighter38;
    private javax.swing.JLabel highlighter39;
    private javax.swing.JLabel highlighter4;
    private javax.swing.JLabel highlighter40;
    private javax.swing.JLabel highlighter41;
    private javax.swing.JLabel highlighter42;
    private javax.swing.JLabel highlighter43;
    private javax.swing.JLabel highlighter44;
    private javax.swing.JLabel highlighter45;
    private javax.swing.JLabel highlighter46;
    private javax.swing.JLabel highlighter47;
    private javax.swing.JLabel highlighter48;
    private javax.swing.JLabel highlighter5;
    private javax.swing.JLabel highlighter6;
    private javax.swing.JLabel highlighter7;
    private javax.swing.JLabel highlighter8;
    private javax.swing.JLabel highlighter9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.Box.Filler position1;
    private javax.swing.Box.Filler position10;
    private javax.swing.Box.Filler position11;
    private javax.swing.Box.Filler position12;
    private javax.swing.Box.Filler position13;
    private javax.swing.Box.Filler position14;
    private javax.swing.Box.Filler position15;
    private javax.swing.Box.Filler position16;
    private javax.swing.Box.Filler position17;
    private javax.swing.Box.Filler position18;
    private javax.swing.Box.Filler position19;
    private javax.swing.Box.Filler position2;
    private javax.swing.Box.Filler position20;
    private javax.swing.Box.Filler position21;
    private javax.swing.Box.Filler position22;
    private javax.swing.Box.Filler position23;
    private javax.swing.Box.Filler position24;
    private javax.swing.Box.Filler position3;
    private javax.swing.Box.Filler position4;
    private javax.swing.Box.Filler position5;
    private javax.swing.Box.Filler position6;
    private javax.swing.Box.Filler position7;
    private javax.swing.Box.Filler position8;
    private javax.swing.Box.Filler position9;
    private javax.swing.JLabel redStone1;
    private javax.swing.JLabel redStone10;
    private javax.swing.JLabel redStone11;
    private javax.swing.JLabel redStone12;
    private javax.swing.JLabel redStone13;
    private javax.swing.JLabel redStone14;
    private javax.swing.JLabel redStone15;
    private javax.swing.JLabel redStone16;
    private javax.swing.JLabel redStone17;
    private javax.swing.JLabel redStone18;
    private javax.swing.JLabel redStone19;
    private javax.swing.JLabel redStone2;
    private javax.swing.JLabel redStone20;
    private javax.swing.JLabel redStone21;
    private javax.swing.JLabel redStone22;
    private javax.swing.JLabel redStone23;
    private javax.swing.JLabel redStone24;
    private javax.swing.JLabel redStone3;
    private javax.swing.JLabel redStone4;
    private javax.swing.JLabel redStone5;
    private javax.swing.JLabel redStone6;
    private javax.swing.JLabel redStone7;
    private javax.swing.JLabel redStone8;
    private javax.swing.JLabel redStone9;
    private javax.swing.JLabel redStonePack1;
    private javax.swing.JLabel redStonePack10;
    private javax.swing.JLabel redStonePack11;
    private javax.swing.JLabel redStonePack12;
    private javax.swing.JLabel redStonePack2;
    private javax.swing.JLabel redStonePack3;
    private javax.swing.JLabel redStonePack4;
    private javax.swing.JLabel redStonePack5;
    private javax.swing.JLabel redStonePack6;
    private javax.swing.JLabel redStonePack7;
    private javax.swing.JLabel redStonePack8;
    private javax.swing.JLabel redStonePack9;
    // End of variables declaration//GEN-END:variables
}
