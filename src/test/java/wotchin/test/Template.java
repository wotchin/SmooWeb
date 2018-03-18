package wotchin.test;

import com.github.wotchin.*;
import com.github.wotchin.annotation.Controller;
import com.github.wotchin.annotation.RequestMapping;
import com.github.wotchin.request.Request;
import com.github.wotchin.request.RequestHeader;
import com.github.wotchin.response.HttpResponse;
import com.github.wotchin.response.HttpResponseBuilder;
import com.github.wotchin.response.Response;
import com.github.wotchin.response.ResponseHeaderFactory;

@Controller
public class Template implements RouterTemplate {


    @Override
    public void notFound(Request req, Response res) {
        res.end("Hello World");
    }

    @Override
    public void serverError(Request req, Response res) {
        res.end("error");
    }

    @RequestMapping(value = "/")
    public void index(Request req,Response res){
        res.end("fuck");
    }

}
