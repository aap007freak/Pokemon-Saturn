package com.antonleagre.pokemonsaturn.engine.battle;


import java.util.List;

public class BattleBlockMessage {

    enum BlockType {
        UPDATE,
        SIDEUPDATE,
    }

    private BlockType blockType;
    private List<String> messages;

    public BattleBlockMessage(BlockType blockType, List<String> messages) {
        this.blockType = blockType;
        this.messages = messages;
    }
}

