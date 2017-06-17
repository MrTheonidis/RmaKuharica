package com.theonidis.ivan.projekt_v1;

import java.util.List;

/**
 * Created by Ivan on 5.6.2017..
 */

public class AndroidVersion {
    private String id;
    private String ime;
    private String vrsta;
    private String urlslike;
    private String vrijeme;
    private String priprema;
    private List<String> sastojci;

    public String getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getVrsta() {
        return vrsta;
    }

    public String getUrlslike() { return urlslike; }

    public String getVrijeme() { return vrijeme; }

    public String getPriprema() { return priprema; }

    public List<String> getSastojci() { return sastojci; }
}
