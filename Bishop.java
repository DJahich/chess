package chess;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        // цвет фигуры
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // 
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        // Движение по диагоналии
        if (Math.abs(line - toLine) != Math.abs(column - toColumn)) {
            return false;
        }

        // направление
        int stepLine = (toLine > line) ? 1 : -1;
        int stepColumn = (toColumn > column) ? 1 : -1;

        // определить, есть ли на пути другие фигуры
        int currentLine = line + stepLine;
        int currentColumn = column + stepColumn;
        while (currentLine != toLine && currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += stepLine;
            currentColumn += stepColumn;
        }

        // запрет на атаку своих
        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        return targetPiece == null || !targetPiece.getColor().equals(this.getColor());
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
