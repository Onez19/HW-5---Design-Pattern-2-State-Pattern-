package Gumball;/*
 *  6510450411
 *  Thanachote Ngamkana
 */

import Service.IO;

class Gumball {
  private int quality;
  private final int noID;
  private States state;
  private final IO io = new IO();

  public enum States {
    NO_QUARTER,
    HAS_QUARTER,
    GUMBALL_SOLD,
    OUT_OF_GUMBALL
  }

  public enum Symbols {
    INSERT_QUARTER,
    EJECT_QUARTER,
    TURNS_CRANK,
    DISPENSE_GUMBALL,
    INCORRECT
  }

  public Gumball(int quality, int noID) {
    this.noID = noID;
    this.quality = quality;

    if (this.quality > 0) {
      state = States.NO_QUARTER;
    } else {
      state = States.OUT_OF_GUMBALL;
    }
  }

  public boolean insert() {
    if (this.state == States.NO_QUARTER && quality <= 0) {
      io.print("You can't insert a quarter, the machine is sold out.\n");
      return false;
    } else if (this.state == States.NO_QUARTER) {
      this.state = States.HAS_QUARTER;
      io.print("You inserted a quarter\n");
      return true;
    } else {
      io.print("You can't insert another quarter.\n");
      return false;
    }

  }

  public boolean eject() {
    if (this.state == States.HAS_QUARTER) {
      this.state = States.NO_QUARTER;
      io.print("Quarter returned.\n");
      return true;
    } else {
      io.print("Incorrect\n");
      return false;
    }
  }

  public boolean turnsCrank() {
    if (this.state == States.HAS_QUARTER) {
      this.state = States.GUMBALL_SOLD;
      io.print("Your turned...\n");
      return true;
    } else if (this.state == States.NO_QUARTER) {
      io.print("You turned but there's no quarter.\n");
      return false;
    } else {
      io.print("You haven't inserted a quarter.\n");
      return false;
    }
  }

  public boolean dispense() {
    if (this.state == States.GUMBALL_SOLD) {
      if (quality > 0) {
        this.state = States.NO_QUARTER;
        quality--;
        io.print("A gumball comes rolling out the slot\n");
        return true;
      } else {
        this.state = States.OUT_OF_GUMBALL;
        io.print("Opps, out of gumballs.\n");
        return false;
      }
    } else {
      io.print("Incorrect\n");
      return false;
    }
  }

  public int getNoID() {
    return noID;
  }

  public Symbols getSymbol(int choice) {
    return switch (choice) {
      case 1 -> Symbols.INSERT_QUARTER;
      case 2 -> Symbols.EJECT_QUARTER;
      case 3 -> Symbols.TURNS_CRANK;
      case 4 -> Symbols.DISPENSE_GUMBALL;
      default -> Symbols.INCORRECT;
    };
  }

  public void start() {
    boolean valid = true;
    if (this.state != States.OUT_OF_GUMBALL) {

      while (valid) {
        io.print("Inventory : " + quality + " gumballs\n");
        io.print("Machine is wating for quarter.\n");

        Symbols selected = getSymbol(io.input());
        if (selected == Symbols.INSERT_QUARTER) {
          valid = insert();
        } else if (selected == Symbols.EJECT_QUARTER) {
          valid = eject();
        } else if (selected == Symbols.TURNS_CRANK) {
          valid = turnsCrank();
        } else if (selected == Symbols.DISPENSE_GUMBALL) {
          valid = dispense();
        } else {
          io.print("Incorrect\n");
        }
        io.print("\n");
      }

    } else {
      io.print("Inventory : " + quality + " gumballs\n");
      io.print("Machine is sold out.\n");
    }
  }
}