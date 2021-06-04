package com.example.projet_mobil;

import java.util.List;

public class Seance {
    private String startDate;
    private int duration, isDone, id, clientID;


    public Seance() {
    }

    public Seance(String startDate, int duration, int isDone, int id, int clientID) {
        this.startDate = startDate;
        this.duration = duration;
        this.isDone = isDone;
        this.id = id;
        this.clientID = clientID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}
