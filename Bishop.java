package chess;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Validate positions
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // Check if the move is diagonal
        if (Math.abs(line - toLine) != Math.abs(column - toColumn)) {
            return false;
        }

        // Determine the direction of movement
        int stepLine = (toLine > line) ? 1 : -1;
        int stepColumn = (toColumn > column) ? 1 : -1;

        // Check if the path is clear
        int currentLine = line + stepLine;
        int currentColumn = column + stepColumn;
        while (currentLine != toLine && currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += stepLine;
            currentColumn += stepColumn;
        }

        // Ensure the target square is not occupied by a piece of the same color
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        return targetPiece == null || !targetPiece.getColor().equals(this.getColor());
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
