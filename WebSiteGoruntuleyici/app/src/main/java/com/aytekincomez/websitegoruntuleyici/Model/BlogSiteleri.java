package com.aytekincomez.websitegoruntuleyici.Model;

public class BlogSiteleri {

    private boolean cokluYazar;
    private String webSiteAdi;
    private String webSiteUrl;
    private boolean kisiselMi;

    public BlogSiteleri() {
    }

    public BlogSiteleri(boolean cokluYazar, String webSiteAdi, String webSiteUrl, boolean kisiselMi) {
        this.cokluYazar = cokluYazar;
        this.webSiteAdi = webSiteAdi;
        this.webSiteUrl = webSiteUrl;
        this.kisiselMi = kisiselMi;
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

    public boolean isKisiselMi() {
        return kisiselMi;
    }

    public void setKisiselMi(boolean kisiselMi) {
        this.kisiselMi = kisiselMi;
    }
}
