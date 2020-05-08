/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

/**
 *
 * @author Eimstoa
 */
public class Flugziel {
    private int zid;
    private String abflug;
    private String ankunft;

    public Flugziel() {
    }

    public Flugziel(int zid, String abflug, String ankunft) {
        this.zid = zid;
        this.abflug = abflug;
        this.ankunft = ankunft;
    }

    public int getZid() {
        return zid;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    public String getAbflug() {
        return abflug;
    }

    public void setAbflug(String abflug) {
        this.abflug = abflug;
    }

    public String getAnkunft() {
        return ankunft;
    }

    public void setAnkunft(String ankunft) {
        this.ankunft = ankunft;
    }
    
    
    
}
