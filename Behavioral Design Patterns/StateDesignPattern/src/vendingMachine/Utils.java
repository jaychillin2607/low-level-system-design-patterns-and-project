package vendingMachine;

public class Utils {
  public static int getCoinValue(Coin coin) {
    switch (coin) {
      case Coin.CENT:
        return 1;
      case Coin.NICKEL:
        return 5;
      case Coin.DIME:
        return 10;
      default:
        return 25;
    }
  }

  public static String getCoinName(Coin coin) {
    switch (coin) {
      case Coin.CENT:
        return "cent";
      case Coin.NICKEL:
        return "nickel";
      case Coin.DIME:
        return "dime";
      default:
        return "quarter";
    }
  }

  public static String getItemName(ItemType itemType) {
    switch (itemType) {
      case ItemType.COFFEE:
        return "coffee";
      case ItemType.PEPSI:
        return "pepsi";
      case ItemType.COKE:
        return "coca cola";
      default:
        return "dr. pepper";
    }
  }
}
