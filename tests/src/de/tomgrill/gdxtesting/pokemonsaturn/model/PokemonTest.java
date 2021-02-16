package de.tomgrill.gdxtesting.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.pokemon.BasePokemon;
import com.antonleagre.pokemonsaturn.model.pokemon.EffortValues;
import com.antonleagre.pokemonsaturn.model.pokemon.Type;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class PokemonTest {

    //BasePokemon Tests
    @Test
    public void AllBasePokemonPresent() {
        assertEquals(BasePokemon.values().length, 493);
    }

    //EV tests
    @Test
    public void AllPokemonHaveAEVYieldDefeatedEnumFieldTest(){
        EffortValues.EVYieldByPokemonDefeated[] evyields = EffortValues.EVYieldByPokemonDefeated.values();

        for(BasePokemon bp: BasePokemon.values()){
            assertTrue(Arrays.stream(evyields).anyMatch(evpd -> evpd.toString().equals(bp.toString())));
        }

    }

    //type tests
    @Test
    public void AllTypesAreInTheTypeEffectivenessChart() {
        int numTypes = Type.values().length - 1; // TODO: 2/02/2021 This -1 is because we can ignore FAIRY type, when I
        // remove the fairy type, this test will fail so this -1 needs to be removed then
        assertEquals(Type.typeEffectivenessChart.length, numTypes);
        assertEquals(Type.typeEffectivenessChart[0].length, numTypes);
    }

    @Test
    public void GeneralTypeChecks() {
        assertEquals(Type.getTypesImmuneToWhenAttacking(Type.FIGHTING), Set.of(Type.GHOST));
        assertEquals(Type.getTypeModifier(Type.DARK, Type.PSYCHIC), 2, 0);
    }

}
