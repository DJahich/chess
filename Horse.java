package chess;

public class Horse extends ChessPiece {
    // определить цвет фигуры
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // ограничить движение вне доски
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }
        // запрет на движение в ту же позицию
        if (line == toLine && column == toColumn) {
            return false;
        }
        
        int diffLine = Math.abs(line - toLine);
        int diffColumn = Math.abs(column - toColumn);
        // движение по букве Г
        if (!((diffLine == 2 && diffColumn == 1) || (diffLine == 1 && diffColumn == 2))) {
            return false;
        }

        // убрать фигуру с доски, если ее срубили
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        //запрет на движение на своих
        return targetPiece == null || !targetPiece.getColor().equals(this.getColor());
    }

    @Override
    public String getSymbol() {
        return "H"; 
    }
}
