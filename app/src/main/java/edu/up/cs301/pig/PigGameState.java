package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by yu18 on 3/9/2017.
 */
public class PigGameState extends GameState{
    private int whoseTurn;
    private int score0;
    private int score1;
    private int runningTotal;
    private int dieVal;

    public PigGameState()
    {
        whoseTurn = 0;
    }
}
