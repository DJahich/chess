package chess;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        
        boolean straightLineMove = line == toLine || column == toColumn;
        boolean diagonalMove = Math.abs(line - toLine) == Math.abs(column - toColumn);

        return (straightLineMove || diagonalMove) && (line != toLine || column != toColumn);
    }

    @Override
    public String getSymbol() {
        return "Q"; 
    }
}
