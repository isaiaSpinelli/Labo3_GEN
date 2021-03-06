public class Player {
    private String name;
    private Board board ;
    private Dice dices [];
    private Piece piece ;

    Player(String name, Board board, Dice[] dices){
        this.name = name;
        this.board = board;
        this.dices = dices;
        piece = new Piece(name+"'s token", board.getSquareIndex(0));
    }

    void takeTurn(){
        char fvTot = 0;
        // Joue les dés
        for(Dice dice : dices){
            dice.roll();
            fvTot += dice.getFaceValue();
        }
        Square oldLoc = piece.getLocation();
        Square newLoc = board.getSquare( oldLoc, fvTot );

        piece.setLocation( newLoc );

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getPiece() {
        return piece;
    }

}
