package com.dropwizard.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {

    private long id;
    private String content;

    public Saying(){
        super();
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public void setContent(String content) {
        this.content = content;
    }
}
