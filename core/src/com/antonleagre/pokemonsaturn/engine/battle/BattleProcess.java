package com.antonleagre.pokemonsaturn.engine.battle;

import java.io.*;

public class BattleProcess{

    private Process process;
    private InputStream fromProcess;
    private OutputStream toProcess;
    private InputStream errorFromProcess;

    public BattleProcess() {
        try {
           ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Users\\Anton\\Desktop\\Pokemon-Showdown\" && node pokemon-showdown simulate-battle");
           //ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "dir");

            builder.redirectErrorStream(true); //todo this should maybe not happen (i.e. error handling with separate reader?
            this.process = builder.start();
            this.fromProcess = process.getInputStream();
            this.toProcess = process.getOutputStream();
            this.errorFromProcess = process.getErrorStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Process getProcess() {
        return process;
    }

    public InputStream getFromProcess() {
        return fromProcess;
    }

    public OutputStream getToProcess() {
        return toProcess;
    }

    public InputStream getErrorFromProcess() {
        return errorFromProcess;
    }
}

