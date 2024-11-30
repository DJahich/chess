package chess;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // определить позицию
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        
        int direction = this.getColor().equals("White") ? 1 : -1;

        // движение на одну клетку вперед
        if (toColumn == column && toLine == line + direction &&
            chessBoard.board[toLine][toColumn] == null) {
            return true;
        }

        // возможность пройти две клетки с первой позиции
        if (toColumn == column && toLine == line + 2 * direction && 
            chessBoard.board[toLine][toColumn] == null &&
            chessBoard.board[line + direction][column] == null &&
            ((line == 1 && this.getColor().equals("White")) || 
             (line == 6 && this.getColor().equals("Black")))) {
            return true;
        }

        // рубить по диагонали
        return Math.abs(toColumn - column) == 1 && toLine == line + direction &&
               chessBoard.board[toLine][toColumn] != null &&
               !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
