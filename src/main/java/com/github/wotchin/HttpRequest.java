package com.github.wotchin;

public class HttpRequest {


    private  String accept = null;
    private  String agent = null;
    private  String host = null;
    private  String language = null;
    private  String charset = null;
    private  String encoding = null;
    private  String connection = null;
    private  String method = null;
    private  String uri = null;
    private  String protocol = null;
    private  String client = null;
    //private  byte []data; //附加内容 留坑

    public String getAccept(){
        return accept;
    }
    public String getAgent(){
        return agent;
    }
    public String getHost(){
        return host;
    }
    public String getLanguage(){
        return language;
    }
    public String getCharset(){
        return charset;
    }
    public String getEncoding(){
        return encoding;
    }
    public String getConnection(){
        return connection;
    }
    public String getMethod(){
        return method;
    }
    public String getUri(){
        return uri;
    }
    public String getProtocol(){
        return protocol;
    }
    public String getClientHost(){
        return client;
    }


    HttpRequest(String s,String client){
        this.client = client;

        if (s.startsWith("GET")) {
            method = "Get";

            int index = s.indexOf("HTTP");
//            System.out.println("index--->" + index);
            uri = s.substring(3 + 1, index - 1);// 用index-1可以去掉连接中的空格
//            System.out.println("uri--->" + uri);

            protocol = s.substring(index);
//            System.out.println("protocol---->" + protocol);

        } else if (s.startsWith("POST")) {
            method = "POST";

            int index = s.indexOf("HTTP");
//            System.out.println("index--->" + index);
            uri = s.substring(3 + 1, index - 1);// 用index-1可以去掉连接中的空格
//            System.out.println("uri--->" + uri);

            protocol = s.substring(index);
//            System.out.println("protocol---->" + protocol);

        } else if (s.startsWith("Accept:")) {
            accept = s.substring("Accept:".length() + 1);
//            System.out.println("accept--->" + accept);
//            request.setAccept(accept);

        } else if (s.startsWith("User-Agent:")) {
            agent = s.substring("User-Agent:".length() + 1);
//            System.out.println("agent--->" + agent);
//            request.setAgent(agent);

        } else if (s.startsWith("Host:")) {
            host = s.substring("Host:".length() + 1);
//            System.out.println("host--->" + host);
//            request.setHost(host);

        } else if (s.startsWith("Accept-Language:")) {
            language = s.substring("Accept-Language:".length() + 1);
//            System.out.println("language--->" + language);
//            request.setLanguage(language);

        } else if (s.startsWith("Accept-Charset:")) {
            charset = s.substring("Accept-Charset:".length() + 1);
//            System.out.println("charset--->" + charset);
//            request.setCharset(charset);
        } else if (s.startsWith("Accept-Encoding:")) {
            encoding = s.substring("Accept-Encoding:".length() + 1);
//            System.out.println("encoding--->" + encoding);
//            request.setEncoding(encoding);

        } else if (s.startsWith("Connection:")) {
            connection = s.substring("Connection:".length() + 1);
//            System.out.println("connection--->" + connection);
//            request.setConnection(connection);
        }
    }
}
