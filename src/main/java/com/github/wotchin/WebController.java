package com.github.wotchin;

import com.github.wotchin.request.Request;
import com.github.wotchin.response.Response;

public interface WebController {


      void notFound(Request req,Response res);
      void serverError(Request req,Response res);

}
