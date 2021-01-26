package de.tomgrill.gdxtesting.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.pokemon.BasePokemon;
import com.antonleagre.pokemonsaturn.model.pokemon.EffortValues;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.jsoup.Connection;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class EVTest {

    @Test
    public void AllPokemonHaveAEVYieldDefeatedEnumFieldTest(){
         EffortValues.EVYieldByPokemonDefeated[] evyields = EffortValues.EVYieldByPokemonDefeated.values();

        for(BasePokemon bp: BasePokemon.values()){
            assertTrue(Arrays.stream(evyields).anyMatch(evpd -> evpd.toString().equals(bp.toString())));
        }

    }
}
