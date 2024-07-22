package State;

import Gumball.GumballMachine;

public class NoQuarterState implements State {
  private final GumballMachine gumballMachine;


  public NoQuarterState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("You inserted a quarter");
    gumballMachine.setState(gumballMachine.getChooceState());
  }

  @Override
  public void choose(String chosen) {
    System.out.println("You need to insert a quarter first.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("You haven’t inserted a quarter");
  }

  @Override
  public void turnCrank() {
    System.out.println("You turned, but there’s no quarter");
  }

  @Override
  public void dispense() {
    System.out.println("You need to pay first");
  }
}
