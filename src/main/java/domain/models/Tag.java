package domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;
}
