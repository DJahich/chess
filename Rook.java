package chess;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) || 
            !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        
        if (line != toLine && column != toColumn) return false;

        int stepLine = line == toLine ? 0 : (toLine > line ? 1 : -1);
        int stepColumn = column == toColumn ? 0 : (toColumn > column ? 1 : -1);

        int currentLine = line + stepLine;
        int currentColumn = column + stepColumn;

        while (currentLine != toLine || currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null) return false;
            currentLine += stepLine;
            currentColumn += stepColumn;
        }

        
        if (chessBoard.board[toLine][toColumn] != null && 
            chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
