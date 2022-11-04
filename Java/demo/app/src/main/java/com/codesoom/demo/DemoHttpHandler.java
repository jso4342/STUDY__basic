package com.codesoom.demo;

import com.codesoom.demo.models.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoHttpHandler implements HttpHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Task> tasks = new ArrayList<>();

    public DemoHttpHandler() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Do Nothing...");
        tasks.add(task);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setTitle("Second");
        tasks.add(task2);
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

        // 바디 읽어오기
        InputStream inputStream = exchange.getRequestBody();
        String body = new BufferedReader(new InputStreamReader(inputStream))
            .lines()
            .collect(Collectors.joining("\n"));

        System.out.println(method + " " + path);
        if (!body.isBlank()){
           // System.out.println(body);
            Task task = toTask(body);
            tasks.add(task);
          //  System.out.println(task);
        }
        String content = "Hello World!";

        if (method.equals("GET") && path.equals("/tasks")){
            content = tasksToJSON();
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

    private Task toTask(String content) throws JsonProcessingException {
        return objectMapper.readValue(content, Task.class);
    }

    private String tasksToJSON() throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        objectMapper.writeValue(outputStream, tasks);

        return outputStream.toString();
    }
}
