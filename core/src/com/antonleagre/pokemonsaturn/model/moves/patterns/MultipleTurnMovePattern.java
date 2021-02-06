package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;
import com.antonleagre.pokemonsaturn.model.moves.MovePattern;

/**
 * MovePattern for moves that take up multiple turns.
 */
public class MultipleTurnMovePattern implements MovePattern {

    private int turn = -1;

    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        turn += 1;
        boolean result = nth(turn, pm, battle);
        if(turn == 0){
            result = useTurn(pm, battle);
        }else if (turn == 1) {
            result = firstAfter(pm, battle);
        } else if (turn == 2) {
            result = secondAfter(pm, battle);
        } else if (turn == 3) {
            result = thirdAfter(pm, battle);
        } else if (turn == 4) {
            result = fourthAfter(pm, battle);
        } else if (turn == 5) {
            result = fifthAfter(pm, battle);
        }
        return result;
    }

    /**
     * Is called when the move is first used.
     *
     * @param pm     PMPair containing the original Move and Target
     * @param battle Battle-environment as it the first turn after.
     *
     * @return Whether or not to keep the move in memory. Please return false if the move isn't needed in memory
     *         anymore.
     *         <p>
     *         Important. When a class implements both this method and {@link #nth(int, PMPair, Battle)}, the return
     *         value of this function will take precedence over the other function.
     */
    protected boolean useTurn(PMPair pm, Battle battle){
        return true;
    }

    /**
     * Is called the first turn <b>after</b> the move was used, thus the <b>second</b> turn the move is in play.
     *
     * @param pm     PMPair containing the original Move and Target
     * @param battle Battle-environment as it the first turn after.
     *
     * @return Whether or not to keep the move in memory. Please return false if the move isn't needed in memory
     *         anymore.
     *         <p>
     *         Important. When a class implements both this method and {@link #nth(int, PMPair, Battle)}, the return
     *         value of this function will take precedence over the other function.
     */
    protected boolean firstAfter(PMPair pm, Battle battle) {
        return true;
    }

    /**
     * Is called the second turn <b>after</b> the move was used, thus the <b>third</b> turn the move is in play.
     *
     * @param pm     PMPair containing the original Move and Target
     * @param battle Battle-environment as it the first turn after.
     *
     * @return Whether or not to keep the move in memory. Please return false if the move isn't needed in memory
     *         anymore.
     *         <p>
     *         Important. When a class implements both this method and {@link #nth(int, PMPair, Battle)}, the return
     *         value of this function will take precedence over the other function.
     */
    protected boolean secondAfter(PMPair pm, Battle battle) {
        return true;
    }

    /**
     * Is called the third turn <b>after</b> the move was used, thus the <b>fourth</b> turn the move is in play.
     *
     * @param pm     PMPair containing the original Move and Target
     * @param battle Battle-environment as it the first turn after.
     *
     * @return Whether or not to keep the move in memory. Please return false if the move isn't needed in memory
     *         anymore.
     *         <p>
     *         Important. When a class implements both this method and {@link #nth(int, PMPair, Battle)}, the return
     *         value of this function will take precedence over the other function.
     */
    protected boolean thirdAfter(PMPair pm, Battle battle) {
        return true;
    }

    /**
     * Is called the fourth turn <b>after</b> the move was used, thus the <b>fifth</b> turn the move is in play.
     *
     * @param pm     PMPair containing the original Move and Target
     * @param battle Battle-environment as it the first turn after.
     *
     * @return Whether or not to keep the move in memory. Please return false if the move isn't needed in memory
     *         anymore.
     *         <p>
     *         Important. When a class implements both this method and {@link #nth(int, PMPair, Battle)}, the return
     *         value of this function will take precedence over the other function.
     */
    protected boolean fourthAfter(PMPair pm, Battle battle) {
        return true;
    }

    /**
     * Is called the fifth turn <b>after</b> the move was used, thus the <b>sixth</b> turn the move is in play.
     *
     * @param pm     PMPair containing the original Move and Target
     * @param battle Battle-environment as it the first turn after.
     *
     * @return Whether or not to keep the move in memory. Please return false if the move isn't needed in memory
     *         anymore.
     *         <p>
     *         Important. When a class implements both this method and {@link #nth(int, PMPair, Battle)}, the return
     *         value of this function will take precedence over the other function.
     */
    protected boolean fifthAfter(PMPair pm, Battle battle) {
        return true;
    }

    /**
     * Function that gets called every turn the move is in play. Please note that
     *
     * @param n The n-th turn <b>after</b> the move was used. So the turn the move was used is represented by n = 0
     *
     * @return Whether or not to keep the move in memory. Please return false if the move isn't needed in memory
     *         anymore.
     *         <p>
     *         Important. When a class implements both this method and {@link #firstAfter(PMPair, Battle)} till {@link #fifthAfter(PMPair, Battle)}, the return
     *         value of those functions will take precedence over this function.
     */
    protected boolean nth(int n, PMPair pm, Battle battle) {
        return true;
    }

    @Override
    public void end() {

    }
}
