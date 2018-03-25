package test.unit;

import com.github.wotchin.Cookie;
import org.junit.jupiter.api.Test;


class CookieTest {

    @Test
    void addElement(){
        Cookie cookie = new Cookie();
        cookie.put("one","1");
        cookie.put("two",2);
        cookie.put("three",3.0f);
        cookie.put("four",4.0000d);
        System.out.println(cookie.toString());
    }

    @Test
    void parseCookie(){
        Cookie cookie = new Cookie("four=4.0;one=1;two=2;three=3.0");
        System.out.println(cookie.get("four"));
    }
}
