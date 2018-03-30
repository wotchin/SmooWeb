package test.demo;

import com.github.wotchin.*;
import com.github.wotchin.annotation.Controller;
import com.github.wotchin.annotation.RequestMapping;
import com.github.wotchin.request.Request;
import com.github.wotchin.request.RequestMethod;
import com.github.wotchin.response.Response;

@Controller
public class Template implements WebController {


    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void index(Request req,Response res){
        if(req.getHeader().getCookie() == null){
            res.end("No cookies");
        }else{
            res.end(req.getHeader().getCookie().toString());
        }
    }

    @RequestMapping("/res")
    public void res(Request req,Response res){
        res.end(req.getHeader().toString());
    }

}
