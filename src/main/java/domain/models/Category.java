package domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Category {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return id == category.id &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
