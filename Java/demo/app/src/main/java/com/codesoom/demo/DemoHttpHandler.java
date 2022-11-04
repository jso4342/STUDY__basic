package com.codesoom.demo;

import com.codesoom.demo.models.Task;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class DemoHttpHandler implements HttpHandler {
    private List<Task> tasks = new ArrayList<>();

    public DemoHttpHandler() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Do Nothing...");
        tasks.add(task);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // 어떤 요청이 있었나 ?
        // 1. Method - GET, POST. PUT/PATCH, DELETE ...
        // 2. Path - "/", "/tasks" . "/tasks/1", ...
        // 3. Headers, Body(Content)

        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        System.out.println(method + " " + path);

        String content = "Hello World!";

        if (method.equals("GET") && path.equals("/tasks")){
         //   content = tasks.toString();
           // content = "[{\"id\":" + tasks.get(0).getId() + ", \"title\":" + tasks.get(0).getTitle()+ "}]"; 이렇게 할 수는 있지만 너무 노가다...
        }

        if (method.equals("POST") && path.equals("/tasks")){
            content = "Create a new task";
        }

        exchange.sendResponseHeaders(200, content.getBytes().length);
                                    // getBytes() 를 하는 이유 : 영어나 숫자는 상관없지 한국어에서 오류가 생길 수 있음
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(content.getBytes()); // write 가 byte[] 를 매개변수로 받음
        outputStream.flush();
        outputStream.close();
    }
}
