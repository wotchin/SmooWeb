package com.github.wotchin;


public interface RouterTemplate {

      HttpResponse homepage(HttpRequest head);

      HttpResponse notFound(HttpRequest head);

      HttpResponse serverError(HttpRequest head,String error);

}
