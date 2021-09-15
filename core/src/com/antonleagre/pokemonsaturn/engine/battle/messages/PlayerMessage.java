package com.antonleagre.pokemonsaturn.engine.battle.messages;

import com.antonleagre.pokemonsaturn.engine.battle.FromServer;
import org.jetbrains.annotations.Nullable;

public class PlayerMessage implements FromServer<PlayerMessage> {

    public enum Player {
        PLAYER_1,
        PLAYER_2,
        PLAYER_3,
        PLAYER_4;

        @Override
        public String toString() { // formatted like p1, p2, p4
            return "p" + this.name().charAt(7);
        }
    }

    private Player player;
    private String username;
    private @Nullable String avatar;
    private int rating;


    @Override
    public PlayerMessage toObject(String message) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
