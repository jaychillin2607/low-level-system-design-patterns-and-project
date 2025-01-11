package models;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
  private Cell[][] cells;
  private int boardSize;
  private int snakeCount;
  private int ladderCount;

  public Board() {
    this(10, 4, 4);
  }

  public Board(int boardSize, int snakeCount, int ladderCount) {
    this.boardSize = boardSize;
    this.snakeCount = snakeCount;
    this.ladderCount = ladderCount;

    initializeBoard();
    addJumps();
  }

  public void initializeBoard() {
    cells = new Cell[boardSize][boardSize];

    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        cells[i][j] = new Cell();
      }
    }

  }

  public void addJumps() {

    // adding ladder(s)
    for (int i = 0; i < ladderCount;) {
      int ladderStart = ThreadLocalRandom.current().nextInt(1, boardSize * boardSize - 1);
      int ladderEnd = ThreadLocalRandom.current().nextInt(1, boardSize * boardSize - 1);
      Cell cell = getCell(ladderStart);
      if (ladderStart >= ladderEnd || cell.getJump() != null) {
        continue;
      }

      cell.setJump(new Jump(ladderStart, ladderEnd));
      i++;
    }

    // adding snake(s)
    for (int i = 0; i < snakeCount;) {
      int snakeStart = ThreadLocalRandom.current().nextInt(1, boardSize * boardSize - 1);
      int snakeEnd = ThreadLocalRandom.current().nextInt(1, boardSize * boardSize - 1);
      Cell cell = getCell(snakeStart);
      if (snakeStart <= snakeEnd || cell.getJump() != null) {
        continue;
      }

      cell.setJump(new Jump(snakeStart, snakeEnd));
      i++;
    }
  }

  public Cell getCell(int pos) {
    return cells[pos / boardSize][pos % boardSize];
  }
}