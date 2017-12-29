package wotchin.test;

import com.github.wotchin.*;

@Controller
public class Template implements RouterTemplate {

    public HttpResponse homepage(HttpRequest head) {
        return new HttpResponse(ResponseHeadFactory.standardHead(),"hello".getBytes());
    }

    public HttpResponse notFound(HttpRequest head) {
        return new HttpResponse(ResponseHeadFactory.notfoundHead(),"not found".getBytes());
    }

    public HttpResponse serverError(HttpRequest head, String error) {
        return new HttpResponseBuilder().setStatusCode(500).bodyText("ffff").builder();
    }

    @Router("/test")
    public HttpResponse defaultRequest(HttpRequest head) {

        return new HttpResponse(ResponseHeadFactory.standardHead(),head.getClientHost().getBytes());
//        return new HttpResponseBuilder().setStatusCode(500).bodyText("ffff").builder();
    }


}
