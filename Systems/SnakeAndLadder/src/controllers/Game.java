package controllers;

import java.util.ArrayDeque;
import java.util.Deque;
import models.*;

public class Game {

  Deque<Player> players;
  Board board;
  Dice dice;
  String winner;
  int playerCount;
  int boardSize;

  public Game() {
    this(2, 1, 10, 4, 4);
  }

  public Game(int playerCount, int diceCount, int boardSize, int snakeCount, int ladderCount) {
    this.boardSize = boardSize;
    this.playerCount = playerCount;
    this.dice = new Dice(diceCount);
    this.players = new ArrayDeque<>();
    this.board = new Board(boardSize, snakeCount, ladderCount);
    addPlayers();
    winner = null;
  }

  public void addPlayers() {
    for (int i = 0; i < playerCount; i++) {
      players.addLast(new Player(String.format("p%d", (i + 1)), 0));
    }
  }

  public void startGame() {
    System.out.println("Starting Game");
    while (winner == null) {
      Player turn = nextTurn();
      System.out.printf("%s's turn, current position: %d\nRolling dice...\n", turn, turn.getCurrentPosition());

      int diceRoll = dice.rollDice();
      System.out.printf("Received %d\n", diceRoll);

      int newPos = turn.getCurrentPosition() + diceRoll;
      newPos = checkJump(newPos);
      turn.setCurrentPosition(newPos);

      if (newPos > boardSize * boardSize - 1) {
        winner = turn.getId();
        break;
      }
      System.out.printf("Player %s moved to position: %d\n", turn, turn.getCurrentPosition());
    }
    System.out.println("Winner is: " + winner);
  }

  public Player nextTurn() {
    Player turn = players.removeFirst();
    players.addLast(turn);
    return turn;
  }

  public int checkJump(int newPos) {
    if (newPos > boardSize * boardSize - 1) {
      return newPos;
    }

    Jump jump = board.getCell(newPos).getJump();
    if (jump != null) {
      String jumpBy = jump.getStart() < jump.getEnd() ? "ladder" : "jump";
      System.out.printf("jump by %s\n", jumpBy);
      return jump.getEnd();
    }

    return newPos;
  }

}