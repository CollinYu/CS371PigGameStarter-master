package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState pudgy = (PigGameState)info;
        if(pudgy.getWhoseTurn()!= this.playerNum){
            return;
        }
        else{
            double s;
            s = Math.random();

            if(s>.5) {
                PigRollAction pra = new PigRollAction(this);
                game.sendAction((GameAction)pra);

            }
            else{
                PigHoldAction pha = new PigHoldAction(this);
                game.sendAction((GameAction)pha);
            }

        }

        // TODO  You will implement this methodpudgy
    }//receiveInfo

}
