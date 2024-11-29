package model;

public class Board {
  private PlayingPiece[][] board;
  private int availableSlot;
  private int size;

  public Board(int size) {
    this.size = size;
    board = new PlayingPiece[size][size];
    availableSlot = size * size;
  }

  public boolean isFreeSpaceAvailable() {
    return availableSlot != 0;
  }

  public boolean addPiece(int row, int col, PlayingPiece piece) {
    if (board[row][col] != null) {
      return false;
    }

    board[row][col] = piece;
    --availableSlot;
    return true;
  }

  public void printBoard() {
    for (int i = 0; i <= size; i++) {
      if (i == 0)
        System.out.print("  ");
      else
        System.out.print("| " + i + " ");
    }
    System.out.println();

    for (int i = 0; i < size; i++) {
      System.out.print((i + 1) + " ");
      for (int j = 0; j < size; j++) {
        System.err.print("| " + (board[i][j] != null ? (board[i][j].toString() + " ") : "- "));
      }
      System.out.println();
    }
  }

  public boolean isWinner(Player player, int row, int col) {
    boolean rowMatch = true, colMatch = true, diag1Match = true, diag2Match = true;

    PlayingPiece piece = player.getPlayingPiece();
    for (int i = 0; i < size; i++) {
      // check if row matches
      if (board[row][i] == null || board[row][i] != piece) {
        rowMatch = false;
      }

      // check if col matches
      if (board[i][col] == null || board[i][col] != piece) {
        colMatch = false;
      }

      // check if diag1 matches
      if (board[i][i] == null || board[i][i] != piece) {
        diag1Match = false;
      }

      // check of diag2 matches
      if (board[i][size - i - 1] == null || board[i][size - i - 1] != piece) {
        diag2Match = false;
      }
    }

    return rowMatch || colMatch || diag1Match || diag2Match;
  }
}