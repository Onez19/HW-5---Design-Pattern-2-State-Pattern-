/*
 *  6510450411
 *  Thanachote Ngamkana
 */
package State;

import Gumball.GumballMachine;

import java.util.Random;

public class ChooseState implements State {
  Random randomWinner = new Random(System.currentTimeMillis());
  private final GumballMachine gumballMachine;

  public ChooseState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("You can’t insert another quarter");
  }

  @Override
  public void choose(String chosen) {
    System.out.println("You have chosen the flavor " + chosen);
    gumballMachine.setFlavor(chosen);
  }

  @Override
  public void ejectQuarter() {
    System.out.println("Quarter returned");
    gumballMachine.setState(gumballMachine.getNoQuarterState());
  }

  @Override
  public void turnCrank() {
    System.out.println("You turned...");

    int winner = randomWinner.nextInt(10);
    if ((winner == 0) && (gumballMachine.getCount() > 1)) {
      gumballMachine.setState(gumballMachine.getWinnerState());
    } else {
      gumballMachine.setState(gumballMachine.getSoldState());
    }
  }

  @Override
  public void dispense() {
    System.out.println("No gumball dispensed");
  }
}
