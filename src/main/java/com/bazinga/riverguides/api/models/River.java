package com.bazinga.riverguides.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeName("river")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties(ignoreUnknown = true)
public class River {
    @NotNull
    @Size(max = 255, min = 1)
    private String riverName;
    @NotNull
    @Size(max = 255, min = 1)
    private String sectionName;
    @NotNull
    @Size(max = 255, min = 1)
    private String region;
    @NotNull
    @Size(max = 255, min = 1)
    private String country;
    @NotNull
    @Size(max = 25, min = 1)
    private String grade;
    @Size(max = 25, min = 1)
    private String length;
    @Size(max = 25, min = 1)
    @Pattern(regexp = "[0-9]*")
    private String funRating;
    @Digits(integer = 10, fraction = 7)
    private double startGeoCoords;
    @Digits(integer = 10, fraction = 7)
    private double endGeoCoords;
    @NotNull
    @Size(max = 2000, min = 1)
    private String description;
    @NotNull
    @Size(max = 255, min = 1)
    private String author;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String createdDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String lastUpdatedDate;
    @NotNull
    @Size(max = 255, min = 1)
    private String lastEditor;

    public River() {
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getFunRating() {
        return funRating;
    }

    public void setFunRating(String funRating) {
        this.funRating = funRating;
    }

    public double getStartGeoCoords() {
        return startGeoCoords;
    }

    public void setStartGeoCoords(double startGeoCoords) {
        this.startGeoCoords = startGeoCoords;
    }

    public double getEndGeoCoords() {
        return endGeoCoords;
    }

    public void setEndGeoCoords(double endGeoCoords) {
        this.endGeoCoords = endGeoCoords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor;
    }
}
