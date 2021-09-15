package com.antonleagre.pokemonsaturn.engine.battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BattleReader extends BufferedReader {

    private static final String BLOCK_END = "\n";

    public BattleReader(Reader in) {
        super(in);
    }

    public String readRawBattleBlockMessage() throws IOException {
        StringBuilder raw = new StringBuilder();

        boolean previous_newline = false;
        while (true){
            char c = (char) read();

            raw.append(c);
            if(c == '\n' && previous_newline){
                return raw.toString().stripTrailing();
            }

            if(c == '\n') previous_newline = true;
        }
    }

    public BattleBlockMessage readBattleBlockMessage() throws IOException {
        String raw = readRawBattleBlockMessage();

        String[] lines = raw.split("\\R"); //split on any line separator

        BattleBlockMessage.BlockType blockType = null;
        try {
             blockType = BattleBlockMessage.BlockType.valueOf(lines[0].toUpperCase());
        }catch (IllegalArgumentException e){
            throw new IOException("Error while parsing server block message type: got " + lines[0] +
                    " but was expecting one of " + Arrays.toString(BattleBlockMessage.BlockType.values()));
        }

        String[] message_lines = new String[lines.length - 2];
        for (int i = 1; i < lines.length - 1; i++) { // i starting at one until n-1 (last line will always be a newline, first line is the blockmessagetype
            message_lines[i - 1] = lines[i];
        }

        return new BattleBlockMessage(blockType, Arrays.stream(message_lines).collect(Collectors.toList()));
    }
}
