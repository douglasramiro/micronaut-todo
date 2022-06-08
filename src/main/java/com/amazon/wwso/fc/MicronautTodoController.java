package com.amazon.wwso.fc;

import io.micronaut.http.annotation.*;

@Controller("/micronautTodo")
public class MicronautTodoController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}