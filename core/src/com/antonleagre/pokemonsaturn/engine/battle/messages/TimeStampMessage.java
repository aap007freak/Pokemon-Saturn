package com.antonleagre.pokemonsaturn.engine.battle.messages;

import com.antonleagre.pokemonsaturn.engine.battle.FromServer;

public class TimeStampMessage implements FromServer<TimeStampMessage> {

    private int timestamp;

    public TimeStampMessage(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String prefix() {
        return "|t:|";
    }

    @Override
    public TimeStampMessage toObject(String message) {
        return new TimeStampMessage(Integer.parseInt(message.substring(4)));
    }
}
