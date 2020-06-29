package com.example.crudusuario.webservice;


import androidx.annotation.NonNull;

import java.io.Serializable;

public class CasosPorEstado implements Serializable {

    public String uf;
    public String state;
    public String cases;
    public String deaths;
    public String suspects;
    public String refuses;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getSuspects() {
        return suspects;
    }

    public void setSuspects(String suspects) {
        this.suspects = suspects;
    }

    public String getRefuses() {
        return refuses;
    }

    public void setRefuses(String refuses) {
        this.refuses = refuses;
    }

    @NonNull
    @Override
    public String toString() {
        return this.state;
    }
}
