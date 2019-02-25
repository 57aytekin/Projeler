package com.aytekincomez.instagramuidesign.Model;

public class DataPartt {
    private String fileName;
    private byte[] content;
    private String type;

    public DataPartt() {
    }

    public DataPartt(String name, byte[] data) {
        fileName = name;
        content = data;
    }

    String getFileName() {
        return fileName;
    }

    byte[] getContent() {
        return content;
    }

    String getType() {
        return type;
    }
}
