/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends stanford.karel.Karel {

    public void run() {
        for (int i = 0; i < 3; i++) {
            if (noBeepersPresent()) {
            putBeeper();
            turnLeft();
            }
            doProcess();
            goDown();
            goToNextOne();
        }
    }
    private void doProcess(){
        while (frontIsClear()) {
            move();
            if (noBeepersPresent()) {
                putBeeper();
            }
        }
    }
    private void goDown(){
        turnLeft();
        turnLeft();
        while (beepersPresent()) {
            move();
            if (frontIsBlocked()) {
                turnLeft();
            }
        }
    }
    private void goToNextOne(){
        for (int i = 0; i < 3; i++) {
            move();
        }
        if (beepersPresent()) {
            turnLeft();
            doProcess();
        } else {
            putBeeper();
            turnLeft();
            doProcess();
        }
    }
}
