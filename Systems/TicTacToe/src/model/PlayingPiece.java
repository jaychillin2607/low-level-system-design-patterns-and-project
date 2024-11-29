package model;

public abstract class PlayingPiece {
  private PieceType playingPiece;

  public PlayingPiece(PieceType piece) {
    this.playingPiece = piece;
  }

  public PieceType getPlayingPiece() {
    return playingPiece;
  }

  @Override
  public String toString() {
    return playingPiece.toString();
  }

}