package matadorGame.fields;

public class Shipping extends Ownable {

  // Constructor
  public Shipping(String name, int number, int salePrice, String cardID) {
    super(name, number, salePrice, cardID);
  }


  // Method

  // Rent is calculated based on the amounts of properties owned in the class Shipping.
  public int rent(){

    int shippingFieldsOwned = getOwner().getCountShipping();
    int rentToPay;

    switch (shippingFieldsOwned){
      case 1:
        rentToPay = 500;
        break;
      case 2:
        rentToPay = 1000;
        break;
      case 3:
        rentToPay = 2000;
        break;
      case 4:
        rentToPay = 4000;
        break;
      default:
        rentToPay = 0;
    }
    return rentToPay;
    }


  @Override
  public String toString() {
    return "====================\n" +
        getNumber() + ". " + getName() + "\n" +

        "Rent 1 card: " + 500 + "\n" +
        "Rent 2 cards: " + 1000 + "\n" +
        "Rent 3 cards: " + 2000 + "\n" +
        "Rent 4 cards: " + 4000 + "\n" +

        "Sales price: " + getSalePrice() + "\n" +
        "====================\n"
        ;
  }

  }


