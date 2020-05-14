/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Eimstoa
 */
public class Flug {
    
    private int fid;
    private Flugziel flugziel;
    private Date datum;
    private float preis;
    private float flugdauer;
    private Time zeit;
    

    public Flug() {
    }

    public Flug(int fid, Flugziel flugziel, Date datum, float preis, float flugdauer, Time zeit) {
        this.fid = fid;
        this.flugziel = flugziel;
        this.datum = datum;
        this.preis = preis;
        this.flugdauer = flugdauer;
        this.zeit = zeit;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Flugziel getFlugziel() {
        return flugziel;
    }

    public void setFlugziel(Flugziel flugziel) {
        this.flugziel = flugziel;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public Time getZeit() {
        return zeit;
    }

    public void setZeit(Time zeit) {
        this.zeit = zeit;
    }
    
    public float getFlugdauer() {
        return flugdauer;
    }

    public void setFlugdauer(float flugdauer) {
        this.flugdauer = flugdauer;
    }
    
    
}
