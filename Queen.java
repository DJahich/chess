package chess;

public class Queen extends ChessPiece {
    // определить цвет 
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //запрет на движение вне доски
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // движение по прямой и диагонали
        boolean straightLineMove = line == toLine || column == toColumn;
        boolean diagonalMove = Math.abs(line - toLine) == Math.abs(column - toColumn);
        // запрет на движение в ту же позицию
        return (straightLineMove || diagonalMove) && (line != toLine || column != toColumn);
    }

    @Override
    public String getSymbol() {
        return "Q"; 
    }
}
