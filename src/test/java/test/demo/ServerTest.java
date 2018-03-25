package test.demo;


import com.github.wotchin.*;

public class ServerTest {

    public static void main(String[] args) {
        try {
            new HttpServerBuilder()
                    .port(9000)
                    .setControllers(Template.class)
                    .builder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
