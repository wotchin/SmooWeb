package com.github.wotchin;

import com.github.wotchin.request.Request;
import com.github.wotchin.response.Response;

public interface UnusualEvent {
    public void notFound(Request req, Response res);
    public void internalServerError(Request req,Response res);
    public void badRequest(Request req,Response res);
}
