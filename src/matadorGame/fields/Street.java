package matadorGame.fields;

public class Street extends Ownable {



  // Constructor
  public Street(String name, int number, int rent, int salePrice) {
    super(name, number, salePrice);
    setRent(rent);
  }


  // Method

  @Override
  public int rent() {
    return getRent();
  }
  @Override
  public String toString() {
    return "====================\n" +
        getNumber() + ". " + getName() + "\n" +

        "Rent: " + getRent() + "\n" +
        "Rent 1 house: " + (getRent() + 500) + "\n" +
        "Rent 2 house: " + (getRent() + 800) + "\n" +
        "Rent 3 house: " + (getRent() + 1200) + "\n" +
        "Rent 4 house: " + (getRent() + 1500) + "\n" +
        "Rent hotel: " + (getRent() + 2000) + "\n" +

        "Sales price: " + getSalePrice() + "\n" +
        "====================\n"
        ;
  }

}

