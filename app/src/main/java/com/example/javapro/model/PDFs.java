package com.example.javapro.model;

public class PDFs {
    public String name;
    public String url;

    public PDFs(String name, String url, int img, boolean isbooked, String id) {
        this.name = name;
        this.url = url;
    }

    public PDFs(String name) {
        this.name = name;
    }


    public PDFs(String name, String url, int img) {
        this.name = name;
        this.url = url;
    }

    public PDFs () {}
    public PDFs(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

