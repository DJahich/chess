package chess;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        
        if (line == toLine && column == toColumn) {
            return false;
        }

        
        int diffLine = Math.abs(line - toLine);
        int diffColumn = Math.abs(column - toColumn);
        boolean isValidKnightMove = (diffLine == 2 && diffColumn == 1) || (diffLine == 1 && diffColumn == 2);

        if (!isValidKnightMove) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null && 
            chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "H"; 
    }
}

