/*
 *  6510450411
 *  Thanachote Ngamkana
 */
package State;


public interface State {
    void insertQuarter();
    void choose(String chosen);
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
