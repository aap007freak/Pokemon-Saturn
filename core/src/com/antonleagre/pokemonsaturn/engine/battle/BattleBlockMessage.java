package com.antonleagre.pokemonsaturn.engine.battle;


import com.antonleagre.pokemonsaturn.engine.battle.messages.GameTypeMessage;
import org.jetbrains.annotations.Nullable;

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

