package com.github.wotchin;

import com.github.wotchin.request.Request;
import com.github.wotchin.request.RequestHeader;
import com.github.wotchin.response.Response;

public class SimpleUnusualEvent implements UnusualEvent {

    @Override
    public void notFound(Request req, Response res) {
        RequestHeader requestHeader = req.getHeader();
        String url = requestHeader.getUrl();
        res.getHeader().setStateCode(404);
        res.end("Not found the URL:<br>" + url);
    }

    @Override
    public void internalServerError(Request req, Response res) {
        res.getHeader().setStateCode(500);
        res.end("Sorry,Server Error!");
    }

    @Override
    public void badRequest(Request req, Response res) {
        res.getHeader().setStateCode(400);
        res.end("Bad Request");
    }
}
