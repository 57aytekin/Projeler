package com.aytekincomez.websitegoruntuleyici.Model;

public class HaberSiteleri {

    private boolean cokluYazar;
    private String webSiteAdi;
    private String webSiteUrl;

    public HaberSiteleri() {
    }

    public HaberSiteleri(boolean cokluYazar, String webSiteAdi, String webSiteUrl) {
        this.cokluYazar = cokluYazar;
        this.webSiteAdi = webSiteAdi;
        this.webSiteUrl = webSiteUrl;
    }

    public boolean isCokluYazar() {
        return cokluYazar;
    }

    public void setCokluYazar(boolean cokluYazar) {
        this.cokluYazar = cokluYazar;
    }

    public String getWebSiteAdi() {
        return webSiteAdi;
    }

    public void setWebSiteAdi(String webSiteAdi) {
        this.webSiteAdi = webSiteAdi;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }
}
