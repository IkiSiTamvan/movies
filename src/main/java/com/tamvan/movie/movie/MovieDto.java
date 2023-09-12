package com.tamvan.movie.movie;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MovieDto {

    private Integer id;

    @Size(max = 100, message = "title can't longer than 100 char")
    private String title;
    @Size(max = 200, message = "Description can't longer than 200 char")
    private String description;

    @Max(value = 10)
    @Min(value = 0)
    private Float rating;

    @Size(max = 200, message = "Image can't longer than 200 char")
    private String image;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastPlaying;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+7")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+7")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getLastPlaying() {
        return lastPlaying;
    }

    public void setLastPlaying(Date lastPlaying) {
        this.lastPlaying = lastPlaying;
    }

}
