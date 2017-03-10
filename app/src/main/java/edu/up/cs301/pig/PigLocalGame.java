package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState piggy;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        piggy = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(piggy.getWhoseTurn()==playerIdx) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigRollAction){
            double dice = Math.random();
            if(dice < .166){
                piggy.setDieVal(1);
                piggy.setRunningTotal(0);
                if (piggy.getWhoseTurn()==0) {
                    piggy.setWhoseTurn(1);
                }
                else{
                    piggy.setWhoseTurn(0);
                }
            }
            else if(dice < (.166*2)){
                piggy.setDieVal(2);
                piggy.setRunningTotal(piggy.getRunningTotal() + 2);
            }
            else if(dice < (.166*3)){
                piggy.setDieVal(3);
                piggy.setRunningTotal(piggy.getRunningTotal() + 3);
            }
            else if(dice < (.166*4)){
                piggy.setDieVal(4);
                piggy.setRunningTotal(piggy.getRunningTotal() + 4);
            }
            else if(dice < (.166*5)){
                piggy.setDieVal(5);
                piggy.setRunningTotal(piggy.getRunningTotal() + 5);
            }
            else if(dice < (.166*6)){
                piggy.setDieVal(6);
                piggy.setRunningTotal(piggy.getRunningTotal() + 6);
            }
            return true;
        }

        if(action instanceof PigHoldAction){
            if(piggy.getWhoseTurn()==0){
                piggy.setScore0(piggy.getRunningTotal()+piggy.getScore0());
                piggy.setRunningTotal(0);
                piggy.setWhoseTurn(1);
            }
            else{
                piggy.setScore1(piggy.getRunningTotal()+piggy.getScore1());
                piggy.setRunningTotal(0);
                piggy.setWhoseTurn(0);
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState peggy = new PigGameState(piggy);
        p.sendInfo(peggy);
        //TODO  You will implement this method
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(piggy.getScore0() >= 50){
        return (this.playerNames[0] + " wins with " + piggy.getScore0() + " points!");
    }
        if(piggy.getScore1() >= 50) {
            return (this.playerNames[1] + " wins with " + piggy.getScore1() + " points!");
        }
        //TODO  You will implement this method
        return null;
    }

}// class PigLocalGame
