package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;

public class Game {
  private List<Player> players;
  private Board gameBoard;

  public Game() {
    gameBoard = new Board(3);

    players = new ArrayList<Player>(2);
    players.add(new Player("player1", new PlayingPieceO()));
    players.add(new Player("player2", new PlayingPieceX()));
    System.out.printf("1. name: %s \t playing piece: %s\n", players.get(0).getName(), players.get(0).getPlayingPiece());
    System.out.printf("2. name: %s \t playing piece: %s\n", players.get(1).getName(), players.get(1).getPlayingPiece());
  }

  public void startGame() {
    boolean noWinner = true;
    Scanner scan = new Scanner(System.in);

    while (noWinner) {
      if (!gameBoard.isFreeSpaceAvailable()) {
        System.out.println("Game Tie!");
        scan.close();
        return;
      }

      Player playing = players.removeFirst();

      gameBoard.printBoard();
      System.out.printf("%s's turn\n", playing.getName());
      System.err.print("Enter piece location as x,y :");
      String[] coords = scan.nextLine().split(",");
      int row = Integer.parseInt(coords[0]) - 1;
      int col = Integer.parseInt(coords[1]) - 1;

      boolean isAdded = gameBoard.addPiece(row, col, playing.getPlayingPiece());

      if (!isAdded) {
        System.out.println("invalid slot location try again!");
        players.addFirst(playing);
        continue;
      }

      noWinner = !gameBoard.isWinner(playing, row, col);

      if (!noWinner) {
        gameBoard.printBoard();
        System.out.printf("%s won this game!\n", playing.getName());
        scan.close();
      }

      players.addLast(playing);
    }
  }
}