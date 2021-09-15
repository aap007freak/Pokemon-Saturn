package com.antonleagre.pokemonsaturn.engine.controllers;

import com.antonleagre.pokemonsaturn.engine.battle.BattleProcess;
import com.antonleagre.pokemonsaturn.engine.battle.BattleReader;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class BattleController {

    public static void main(String[] args){
        BattleProcess process = new BattleProcess();
        BattleReader reader = new BattleReader(new InputStreamReader(process.getFromProcess()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getToProcess()));

        Thread thread = new Thread(() -> {
            try {
                printToSOUTForever(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        try {
            writer.write(">start {\"formatid\":\"gen7randombattle\"}\n");
            writer.flush();
            Thread.sleep(2000);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void printToSOUTForever(@NotNull BattleReader reader) throws IOException {
        String line;
        while (true) {
            line = reader.readRawBattleBlockMessage();
            if (line == null) { break; }
            System.out.println(line);
        }
    }
}

