package com.antonleagre.pokemonsaturn.engine.battle.commands;

import com.antonleagre.pokemonsaturn.engine.battle.ToServer;
import com.antonleagre.pokemonsaturn.engine.battle.messages.PlayerMessage;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;

public class PlayerCommand implements ToServer {


    private class PlayerOptions {
        private @Nullable String name;
        private @Nullable String avatar;
        @SerializedName("team")
        private @Nullable String packedTeam;
    }

    private PlayerMessage.Player player;
    private PlayerOptions options;

    public PlayerCommand(PlayerMessage.Player player, PlayerOptions options){
        this.player = player;
        this.options = options;
    }

    @Override
    public String serverFormat(Gson gson) {
        //check if the options are null
            String optionstring = "{}";
            if (options != null)
                optionstring = gson.toJson(options);

        return ">player " + player.toString() + " " + optionstring;
    }

    public static void main(String[] args) {
        PlayerCommand myPlayerCommand = new PlayerCommand(PlayerMessage.Player.PLAYER_1, null);
        System.out.println(myPlayerCommand.serverFormat(new Gson()));
    }


}
