/*
 *  6510450411
 *  Thanachote Ngamkana
 */
package State;

import Gumball.GumballMachine;

public class SoldOutState implements State{
  private final GumballMachine gumballMachine;
  public SoldOutState(GumballMachine gumballMachine){
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("You can't insert a quarter, The machine is sold out.");
  }

  @Override
  public void choose(String chosen) {
    System.out.println("You can't choose a flavor, the machine is sold out.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("You haven't inserted a quarter.");
  }

  @Override
  public void turnCrank() {
    System.out.println("You turned, but there's no gumballs.");
  }

  @Override
  public void dispense() {
    System.out.println("No gumball dispensed.");
  }
}
