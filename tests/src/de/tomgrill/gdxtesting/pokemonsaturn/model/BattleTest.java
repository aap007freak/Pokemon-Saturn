package de.tomgrill.gdxtesting.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.battle.BattlePokemon;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class BattleTest {

    @Test
    public void stageMultipliersTest(){
        assertEquals(BattlePokemon.accuracyEvasionStageMultipliers.length, 13);
        assertEquals(BattlePokemon.attackDefenseSpecialSpeedMultipliers.length, 13);
    }
}
