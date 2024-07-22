package Gumball;

import State.*;

public class GumballMachine {
  private State soldOutState;
  private State noQuarterState;
  private State hasQuarterState;
  private State soldState;
  private State winnerState;

  private State state = soldOutState;
  private int count = 0;


  public State getWinnerState() {
    return winnerState;
  }

  public int getCount() {
    return count;
  }

  public State getState() {
    return state;
  }

  public State getSoldState() {
    return soldState;
  }

  public State getHasQuarterState() {
    return hasQuarterState;
  }

  public State getNoQuarterState() {
    return noQuarterState;
  }

  public State getSoldOutState() {
    return soldOutState;
  }




  public GumballMachine(int numberGumballs) {
    soldOutState = new SoldOutState(this);
    noQuarterState = new NoQuarterState(this);
    hasQuarterState = new HasQuarterState(this);
    soldState = new SoldState(this);
    winnerState = new WinnerState(this);

    this.count = numberGumballs;
    if (numberGumballs > 0) {
      state = noQuarterState;
    }
  }

  public void insertQuarter() {
    state.insertQuarter();
  }

  public void ejectQuarter() {
    state.ejectQuarter();
  }

  public void turnCrank() {
    state.turnCrank();
    state.dispense();
  }

  public void setState(State state) {
    this.state = state;
  }

  public void releaseBall() {
    System.out.println("A gumball comes rolling out the slot...");
    if (count != 0) {
      count = count - 1;
    }
  }
}
