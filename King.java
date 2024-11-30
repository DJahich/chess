package chess;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        int diffLine = Math.abs(line - toLine);
        int diffColumn = Math.abs(column - toColumn);

        return diffLine <= 1 && diffColumn <= 1 && (line != toLine || column != toColumn);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column)) {
            return false; // Invalid position
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = chessBoard.board[i][j];
                if (piece != null && !piece.getColor().equals(this.getColor())) {
                    // If an opponent's piece can move to the King's position, it's under attack
                    if (piece.canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }

        return false; // No opponent pieces can attack the King
    }
}