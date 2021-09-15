package com.antonleagre.pokemonsaturn.engine.battle.messages;

import com.antonleagre.pokemonsaturn.engine.battle.FromServer;

import java.util.Locale;

public class GameTypeMessage implements FromServer<GameTypeMessage> {

    enum GameType {
            SINGLES,
            DOUBLES,
            TRIPLES,
            MULTI,
            FREEFORALL;

        private String serverRep;

        GameType() {
            this.serverRep = toString().toLowerCase(Locale.ROOT);
        }
    }

    private GameType gameType;

    public GameTypeMessage(GameType gameType) {
        this.gameType = gameType;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    @Override
    public GameTypeMessage toObject(String message) {
        return null;
    }
}
