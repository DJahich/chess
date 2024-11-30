package chess;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Validate positions
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // A piece cannot move to its current position
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Validate knight's move
        int diffLine = Math.abs(line - toLine);
        int diffColumn = Math.abs(column - toColumn);
        if (!((diffLine == 2 && diffColumn == 1) || (diffLine == 1 && diffColumn == 2))) {
            return false;
        }

        // Ensure target square is not occupied by a piece of the same color
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        return targetPiece == null || !targetPiece.getColor().equals(this.getColor());
    }

    @Override
    public String getSymbol() {
        return "H"; 
    }
}
