package control;


public class Main {
    public static void main(String[] args){
        Game game= new Game();
        game.addRedPiece(1);
        game.addBluePiece(10);

        game.addRedPiece(2);
        game.addBluePiece(11);

        game.addRedPiece(3);
        game.addBluePiece(12);

        Game.findNextMode(game);

    }
}
