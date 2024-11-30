package chess;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        int direction = this.getColor().equals("White") ? 1 : -1;

        
        if (toColumn == column && toLine == line + direction &&
            chessBoard.board[toLine][toColumn] == null) {
            return true;
        }

        
        if (toColumn == column && toLine == line + 2 * direction && 
            chessBoard.board[toLine][toColumn] == null &&
            chessBoard.board[line + direction][column] == null &&
            (line == 1 && this.getColor().equals("White") || 
             line == 6 && this.getColor().equals("Black"))) {
            return true;
        }

        
        if (Math.abs(toColumn - column) == 1 && toLine == line + direction &&
            chessBoard.board[toLine][toColumn] != null &&
            !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
