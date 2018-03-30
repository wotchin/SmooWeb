package com.github.wotchin.response;

public enum ContentType {
    APPLICATION_ATOM_XML("application/atom+xml"),
    APPLICATION_FORM_URLENCODED("application/x-www-form-urlencoded"),
    APPLICATION_JSON("application/json"),
    APPLICATION_JAVASCRIPT("application/javascript"),
    APPLICATION_OCTET_STREAM("application/octet-stream"),
    APPLICATION_SVG_XML("application/svg+xml"),
    APPLICATION_XHTML_XML("application/xhtml+xml"),
    APPLICATION_XML("application/xml"),
    MULTIPART_FORM_DATA("multipart/form-data"),
    TEXT_HTML("text/html"),
    TEXT_PLAIN("text/plain"),
    TEXT_XML("text/xml"),
    WILDCARD("*/*"),
    DEFAULT_TEXT("text/html"),
    DEFAULT_BINARY("application/octet-stream");

    private String type = null;
    private ContentType(String str){
       type = str;
    }

    @Override
    public String toString() {
        return type + "; charset=utf-8";
    }
}

