package wotchin.test;

import com.github.wotchin.*;
import com.github.wotchin.annotation.Controller;
import com.github.wotchin.annotation.RequestMapping;
import com.github.wotchin.request.RequestHeader;
import com.github.wotchin.response.HttpResponse;
import com.github.wotchin.response.HttpResponseBuilder;
import com.github.wotchin.response.ResponseHeaderFactory;

@Controller
public class Template implements RouterTemplate {

    public HttpResponse index(RequestHeader head) {
        return new HttpResponse(ResponseHeaderFactory.standardHead(),"It works.".getBytes());
    }

    public HttpResponse notFound(RequestHeader head) {
        return new HttpResponse(ResponseHeaderFactory.notfoundHead(),"not found".getBytes());
    }

    public HttpResponse serverError(RequestHeader head, String error) {
        return new HttpResponseBuilder().setStatusCode(500).bodyText("Internal Server Error").builder();
    }

    @RequestMapping("/test")
    public HttpResponse test(RequestHeader head) {

        return new HttpResponse(ResponseHeaderFactory.standardHead(),head.getClientHost().getBytes());
//        return new HttpResponseBuilder().setStatusCode(500).bodyText("ffff").builder();
    }


}
