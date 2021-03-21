package matadorGame;

import matadorGame.fields.*;

public class GameBoard {
  //ArrayList<Field> fields = new ArrayList<>();
  private Field[] fields = new Field[40];

  // Colors
  private final String END = "\033[0m";
  private final String BLACK_TEXT = "\033[30m";
  private final String PURPLE = "\033[48:2:150:0:255m";
  private final String ORANGE = "\033[48:2:255:90:0m";
  private final String SHIPPING_BLUE = "\033[48:2:50:0:255m";
  private final String GREEN = "\033[42m";
  private final String GRAY = "\033[48:2:160:160:160m";
  private final String RED = "\033[41m";
  private final String WHITE = "\033[47m";
  private final String YELLOW = "\033[43m";
  private final String BLACK = "\033[40m";


  public GameBoard() {
    renderBoard();
  }

  public Field[] getFields() { return fields; }

  // Method
  public void addField(int i, Field field){
    this.fields[i] = field;
  }

  public void renderBoard() {

    fields[0]  = new Start("Start", 1);
    fields[1]  = new Street(PURPLE + BLACK_TEXT + "Rødovrevej" + END, 2, 50, 1200);
    fields[2]  = new HappyCardField("Happy card", 3);
    fields[3]  = new Street(PURPLE + BLACK_TEXT +"Hvidovrevej" + END, 4, 50, 1200);
    fields[4]  = new Taxes("StateTax", 5);
    fields[5]  = new Shipping(SHIPPING_BLUE + "Rederiet Lindinger A/S" + END, 6, 4000);
    fields[6]  = new Street(ORANGE + BLACK_TEXT + "Roskildevej" + END, 7, 100, 2000);
    fields[7]  = new HappyCardField("Happy card", 8);
    fields[8]  = new Street(ORANGE + BLACK_TEXT + "Valby Langgade" + END, 9, 100, 2000);
    fields[9]  = new Street(ORANGE + BLACK_TEXT + "Allégade" + END, 10, 150, 2400);
    fields[10] = new PrisonVisit(BLACK + "På Besøg" + END, 11);
    fields[11] = new Street(GREEN + "Frederiksberg Alle" + END, 12, 200, 2800);
    fields[12] = new Brewery(RED + "Coca Cola" + END, 13, 3000);
    fields[13] = new Street(GREEN + "Bülowsvej" + END, 14, 200, 2800);
    fields[14] = new Street(GREEN + "Gl. Kongevej" + END, 15, 250, 3200);
    fields[15] = new Shipping(SHIPPING_BLUE + "Grenaa-hundested" + END, 16, 4000);
    fields[16] = new Street(GRAY + BLACK_TEXT + "Bernstorffsvej" + END, 17, 300, 3600);
    fields[17] = new HappyCardField("Happy card", 18);
    fields[18] = new Street(GRAY + BLACK_TEXT + "Hellerupvej" + END, 19, 300, 3600);
    fields[19] = new Street(GRAY + BLACK_TEXT + "Strandvej" + END, 20, 350, 4000);
    fields[20] = new Refuge("Parking", 21);
    fields[21] = new Street(RED + "Trianglen" + END, 22, 350, 4400);
    fields[22] = new HappyCardField("Happy card", 23);
    fields[23] = new Street(RED + "Østerbrogade" + END, 24, 350, 4400);
    fields[24] = new Street(RED + "Grønningen" + END, 25, 400, 4800);
    fields[25] = new Shipping(SHIPPING_BLUE + "Mols-Linien A/S" + END, 26, 4000);
    fields[26] = new Street(WHITE + BLACK_TEXT + "Bredgade" + END, 27, 450, 5200);
    fields[27] = new Street(WHITE + BLACK_TEXT + "Kgs. Nytorv" + END, 28, 450, 4800);
    fields[28] = new Brewery(GREEN + "Faxe Bryggeri" + END, 29, 3000);
    fields[29] = new Street(WHITE + BLACK_TEXT + "Østergade" + END, 30, 500, 5600);
    fields[30] = new Prison(BLACK + "In prison" + END, 31);
    fields[31] = new Street(YELLOW + BLACK_TEXT + "Amagertorv" + END, 32, 550, 6000);
    fields[32] = new Street(YELLOW + BLACK_TEXT + "Vimmelskaftet" + END, 33, 550, 6000);
    fields[33] = new HappyCardField("Happy card", 34);
    fields[34] = new Street(YELLOW + BLACK_TEXT + "Nygade" + END, 35, 600, 6400);
    fields[35] = new Shipping(SHIPPING_BLUE + "Skandanavisk Liniatrafik A/S" + END, 36, 4000);
    fields[36] = new HappyCardField("Happy card", 37);
    fields[37] = new Street(PURPLE + "Frederiksborggade" + END, 38, 900, 7000);
    fields[38] = new Taxes("Tax", 39);
    fields[39] = new Street(PURPLE + "Rådhuspladsen" + END, 40, 1000, 8000);

  }

  public void  printBoard(){
    for (Field field : fields) {
      System.out.println(field.getNumber() + ". " + field.getName());
    }
  }


  /*
  public ArrayList<Field> getFields() { return fields; }

  // Method
  public void addField(Field field){
  this.fields.add(field);
  }

  public void renderBoard() {

//Start (1)
    fields.add(new Street("Rødovrevej", 2, 50, 1200));
// lykkekort (3)
    fields.add(new Street("Hvidovrevej", 4, 50, 1200));
    fields.add(new Taxes("StateTax", 5));
    fields.add(new Shipping("Rederiet Lindinger A/S", 6, 4000));
    fields.add(new Street("Roskildevej", 7, 150, 2000));
//lykkekort (8)
    fields.add(new Street("Valby Langgade", 9, 150, 2000));
    fields.add(new Street("Allégade", 10, 200, 2400));
    fields.add(new PrisonVisit("På Besøg", 11))
    fields.add(new Street("Frederiksberg Alle", 12, 500, 2800));
    fields.add(new Brewery("Coca Cola", 13, 3000));
    fields.add(new Street("Bülowsvej", 14, 500, 2800));
    fields.add(new Street("Gl. Kongevej", 15, 550, 3200));
    fields.add(new Shipping("Grenaa-hundested", 16, 4000));
    fields.add(new Street("Bernstorffsvej", 17, 600, 3600));
//lykkekort (18)
    fields.add(new Street("Hellerupvej", 19, 600, 3600));
    fields.add(new Street("Strandvej", 20, 650, 4000));
    fields.add(new Refuge("Parking", 21));
    fields.add(new Street("Trianglen", 22, 700, 4400));
//Lykkekort (23)
    fields.add(new Street("Østerbrogade", 24, 700, 4400));
    fields.add(new Street("Grønningen", 25, 750, 4800));
    fields.add(new Shipping("Mols-Linien A/S", 26, 4000));
    fields.add(new Street("Bredgade", 27, 700, 5200));
    fields.add(new Street("Kgs. Nytorv", 28, 700, 4800));
    fields.add(new Brewery("Faxe Bryggeri", 29, 3000));
    fields.add(new Street("Østergade", 30, 750, 5600));
    fields.add(new Prison("In prison", 31));
    fields.add(new Street("Amagertorv", 32, 800, 6000));
    fields.add(new Street("Vimmelskaftet", 33, 800, 6000));
//lykkekort (34)
    fields.add(new Street("Nygade", 35, 850, 6400));
    fields.add(new Shipping("Skandanavisk Liniatrafik A/S", 36, 4000));
//lykkekort (37)
    fields.add(new Street("Frederiksborggade", 38, 900, 7000));
    fields.add(new Taxes("Tax", 39));
    fields.add(new Street("Rådhuspladsen", 40, 1000, 8000));



  }

  public void  printBoard(){
    for (Field f: fields) {
      System.out.println(f.getNumber() + ". " + f.getName());
    }
  }
   */
}
