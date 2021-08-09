package domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

public class Pet {
    @JsonProperty("id")
    private int id;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("name")
    private String name;

    @JsonProperty("photoUrls")
    private ArrayList<String> photoUrls;

    @JsonProperty("tags")
    private ArrayList<Tag> tags;

    @JsonProperty("status")
    private String status;

    public Pet withId (int id){
        this.id = id;
        return this;
    }

    public Pet withName (String name){
        this.name = name;
        return this;
    }

    public Pet withPhotoUrls (ArrayList<String> photoUrls){
        this.photoUrls = photoUrls;
        return this;
    }

    public Pet withTags (ArrayList<Tag> tags){
        this.tags = tags;
        return this;
    }

    public Pet withStatus (String status){
        this.status = status;
        return this;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return id == pet.id &&
                Objects.equals(name, pet.name) &&
                Objects.equals(photoUrls, pet.photoUrls) &&
                Objects.equals(tags, pet.tags) &&
                Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, photoUrls, tags, status);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
