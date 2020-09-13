package de.tomgrill.gdxtesting.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.pokemon.BaseStats;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)
public class PokemonTest {

    @Test
    public void AllBasePokemonPresent(){
        assertEquals(BaseStats.values().length, 250);
    }
}
