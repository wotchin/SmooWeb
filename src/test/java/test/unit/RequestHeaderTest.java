package test.unit;

import com.github.wotchin.Cookie;
import com.github.wotchin.URI;
import com.github.wotchin.request.RequestHeader;
import org.junit.jupiter.api.Test;

public class RequestHeaderTest {

    RequestHeader getRequestHeader(){
        final String header = "GET /test/s?ie=utf-8&f=3&rsv_bp=1&tn=baidu&wd=uri HTTP/1.1\n" +
                "Host: www.baidu.com\n" +
                "Connection: keep-alive\n" +
                "Cache-Control: max-age=0\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Accept-Language: en-US,en;q=0.9\n" +
                "Cookie: BAIDUID=21D8B51F88A1571874419EBCF39615F0:FG=1; BIDUPSID=21D8B51F88A1571874419EBCF39615F0; PSTM=1518154859;";


         return new RequestHeader(header);
    }

    @Test
    void testURI(){

        RequestHeader header = getRequestHeader();

        for(String it : header.keySet()){
            System.out.println(it + " -> " + header.get(it));
        }

        URI uri = header.getUri();
        System.out.println(uri.toString());
        System.out.println("Path : " + uri.getPath());
        System.out.println("Query : " + uri.getQuery());
        System.out.println("Uri : " + uri.getFullString());

    }

    @Test
    void testCookie(){
        RequestHeader header = getRequestHeader();

        Cookie cookie = header.getCookie();
        cookie.put("four",4);
        System.out.println(cookie.toString());

    }

    @Test
    void testRequestHeader(){
        RequestHeader header = getRequestHeader();
        System.out.println(header.getProtocol());
        System.out.println(header.getMethod());
    }
}
