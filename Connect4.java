class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Cell {
    private Player owner;

    public Cell() {
        this.owner = null;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isEmpty() {
        return owner == null;
    }
}

class Board {
    private final int COLSIZE = 6;
    private final int ROWSIZE = 7;
    private Cell[][] cells;

    public Board() {
        cells = new Cell[COLSIZE][ROWSIZE];
        for (int i = 0; i < COLSIZE; i++) {
            for (int j = 0; j < ROWSIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public boolean placeToken(int column, Player player) {
        for (int i = 0; i < ROWSIZE; i++) {
            if (cells[column][i].isEmpty()) {
                cells[column][i].setOwner(player);
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(Player player) {
        // Check horizontal lines
        for (int i = 0; i < COLSIZE; i++) {
            for (int j = 0; j < ROWSIZE - 3; j++) {
                if (cells[i][j].getOwner() == player &&
                        cells[i][j + 1].getOwner() == player &&
                        cells[i][j + 2].getOwner() == player &&
                        cells[i][j + 3].getOwner() == player) {
                    return true;
                }
            }
        }

        // Check vertical lines
        for (int i = 0; i < COLSIZE - 3; i++) {
            for (int j = 0; j < ROWSIZE; j++) {
                if (cells[i][j].getOwner() == player &&
                        cells[i + 1][j].getOwner() == player &&
                        cells[i + 2][j].getOwner() == player &&
                        cells[i + 3][j].getOwner() == player) {
                    return true;
                }
            }
        }

        // Check diagonals from bottom-left to top-right
        for (int i = 3; i < COLSIZE; i++) {
            for (int j = 0; j < ROWSIZE - 3; j++) {
                if (cells[i][j].getOwner() == player &&
                        cells[i - 1][j + 1].getOwner() == player &&
                        cells[i - 2][j + 2].getOwner() == player &&
                        cells[i - 3][j + 3].getOwner() == player) {
                    return true;
                }
            }
        }

        // Check diagonals from top-left to bottom-right
        for (int i = 3; i < COLSIZE; i++) {
            for (int j = 3; j < ROWSIZE; j++) {
                if (cells[i][j].getOwner() == player &&
                        cells[i - 1][j - 1].getOwner() == player &&
                        cells[i - 2][j - 2].getOwner() == player &&
                        cells[i - 3][j - 3].getOwner() == player) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < COLSIZE; i++) {
            for (int j = 0; j < ROWSIZE; j++) {
                if (cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Connect4 {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Connect4(String player1Name, String player2Name) {
        this.board = new Board();
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.currentPlayer = player1;
    }

    public boolean placeToken(int column) {
        boolean result = board.placeToken(column, currentPlayer);
        // if (result && board.checkWin(currentPlayer)) {
        // System.out.println(currentPlayer.getName() + " wins!");
        // } else {
        // switchPlayer();
        // }
        // switchPlayer();
        return result;
    }

    public boolean isPlayer1Turn() {
        return currentPlayer == player1;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public int isGameOver() {
        int result = -1;
        if (board.checkWin(player1)) {
            result = 1;
        } else if (board.checkWin(player2)) {
            result = 2;
        } else if (board.isDraw()) {
            result = 0;
        }
        return result;
    }

}
