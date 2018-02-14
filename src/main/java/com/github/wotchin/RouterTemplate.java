package com.github.wotchin;


import com.github.wotchin.request.HttpRequest;
import com.github.wotchin.response.HttpResponse;

public interface RouterTemplate {

      HttpResponse index(HttpRequest head);

      HttpResponse notFound(HttpRequest head);

      HttpResponse serverError(HttpRequest head,String error);

}
