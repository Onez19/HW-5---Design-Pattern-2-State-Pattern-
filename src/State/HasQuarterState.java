package State;

import Gumball.GumballMachine;

public class HasQuarterState implements State {
  private final GumballMachine gumballMachine;

  public HasQuarterState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  public void insertQuarter() {
    System.out.println("You can’t insert another quarter");
  }

  public void ejectQuarter() {
    System.out.println("Quarter returned");
    gumballMachine.setState(gumballMachine.getNoQuarterState());
  }

  public void turnCrank() {
    System.out.println("You turned...");
    gumballMachine.setState(gumballMachine.getSoldState());
  }

  public void dispense() {
    System.out.println("No gumball dispensed");
  }
}
