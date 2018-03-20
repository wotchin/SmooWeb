package wotchin.test;

import com.github.wotchin.*;
import com.github.wotchin.annotation.Controller;
import com.github.wotchin.annotation.RequestMapping;
import com.github.wotchin.request.Request;
import com.github.wotchin.request.RequestMethod;
import com.github.wotchin.response.Response;

@Controller
public class Template implements RouterTemplate {


    @Override
    public void notFound(Request req, Response res) {
        res.end("Not Found!");
    }

    @Override
    public void serverError(Request req, Response res) {
        res.end("error");
    }

    @RequestMapping(path = "/",method = RequestMethod.POST)
    public void index(Request req,Response res){
        res.end("It works.");
    }

}
