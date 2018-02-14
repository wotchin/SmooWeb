package com.github.wotchin.response;


public final class HttpResponse {

    private byte[] data;
    private String head;


    public HttpResponse(ResponseHeader head, byte[] data) {

        head.set("Content-Length",String.valueOf(data.length));
        this.head = head.getAll();
        this.data = data;
    }

    /*
    public HttpResponse(String head,byte[] data) {

        this.head = head;
        this.data = data;
    }

*/

    public byte[] getData(){

        return byteMerger(head.getBytes(),data);
    }

    private byte[] byteMerger(byte[] byte_1, byte[] byte_2){
        byte[] byte_3 = new byte[byte_1.length+byte_2.length];
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
        return byte_3;
    }
}
