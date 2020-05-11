/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

/**
 *
 * @author z0041r3p
 */
public class Statistik {
    private int anz_storn;
    private int anz_geflog;
    private int anz_user;
    private int anz_aktiv;
    private int umsatz;

    public Statistik(){}
    
    public Statistik(int anz_storn, int anz_geflog, int anz_user, int anz_aktiv, int umsatz) {
        this.anz_storn = anz_storn;
        this.anz_geflog = anz_geflog;
        this.anz_user = anz_user;
        this.anz_aktiv = anz_aktiv;
        this.umsatz = umsatz;
    }
    
    public int getAnz_storn() {
        return anz_storn;
    }

    public void setAnz_storn(int anz_storn) {
        this.anz_storn = anz_storn;
    }

    public int getAnz_geflog() {
        return anz_geflog;
    }

    public void setAnz_geflog(int anz_geflog) {
        this.anz_geflog = anz_geflog;
    }

    public int getAnz_user() {
        return anz_user;
    }

    public void setAnz_user(int anz_user) {
        this.anz_user = anz_user;
    }

    public int getAnz_aktiv() {
        return anz_aktiv;
    }

    public void setAnz_aktiv(int anz_aktiv) {
        this.anz_aktiv = anz_aktiv;
    }

    public int getUmsatz() {
        return umsatz;
    }

    public void setUmsatz(int umsatz) {
        this.umsatz = umsatz;
    }
    
    
}
