package com.bazinga.riverguides.api.test.builders;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "rivers")
public class RiversTable {
    @Id
    @Column(name = "river_name")
    private String riverName;
    @Column(name = "section_name")
    private String sectionName;
    @Column(name = "region")
    private String region;
    @Column(name = "country")
    private String country;
    @Column(name = "grade")
    private String grade;
    @Column(name = "fun_rating")
    private String funRating;
    @Column(name = "length")
    private String length;
    @Column(name = "start_coords_northings")
    private double startGeoCoordsNorthings;
    @Column(name = "start_coords_eastings")
    private double startGeoCoordsEastings;
    @Column(name = "end_coords_northings")
    private double endGeoCoordsNorthings;
    @Column(name = "end_coords_eastings")
    private double endGeoCoordsEastings;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;
    @Column(name = "last_editor")
    private String lastEditor;

    private RiversTable(final Builder builder) {
        this.riverName = builder.riverName;
        this.sectionName = builder.sectionName;
        this.region = builder.region;
        this.country = builder.country;
        this.grade = builder.grade;
        this.funRating = builder.funRating;
        this.length = builder.length;
        this.startGeoCoordsNorthings = builder.startGeoCoordsNorthings;
        this.startGeoCoordsEastings = builder.startGeoCoordsEastings;
        this.endGeoCoordsNorthings = builder.endGeoCoordsNorthings;
        this.endGeoCoordsEastings = builder.endGeoCoordsEastings;
        this.description = builder.description;
        this.author = builder.author;
        this.createdDate = builder.createdDate;
        this.lastUpdatedDate = builder.lastUpdatedDate;
        this.lastEditor = builder.lastEditor;
    }

    public static class Builder {
        private String riverName;
        private String sectionName;
        private String region;
        private String country;
        private String grade;
        private String funRating;
        private String length;
        private double startGeoCoordsNorthings;
        private double startGeoCoordsEastings;
        private double endGeoCoordsNorthings;
        private double endGeoCoordsEastings;
        private String description;
        private String author;
        private Date createdDate;
        private Date lastUpdatedDate;
        private String lastEditor;

        public Builder withDefaultData() {
            this.riverName = "Dargle";
            this.sectionName = "Main Section";
            this.region = "Wicklow";
            this.country = "Ireland";
            this.grade = "4(4+)";
            this.funRating = "10";
            this.length = "5km";
            this.startGeoCoordsNorthings = 112.256365;
            this.startGeoCoordsEastings = 008.256365;
            this.endGeoCoordsNorthings = 113.3121657;
            this.endGeoCoordsEastings = 006.3121657;
            this.description = "Cool place";
            this.author = "Star Lord";
            //Back to the Future 2 date 21/10/2015 16:29:00
            this.createdDate = new Date(1445441340000L);
            //21/10/1980 16:29:00
            this.lastUpdatedDate = new Date(340990140000L);
            this.lastEditor = "Bugs Bunny";
            return this;
        }

        public RiversTable build() {
            return new RiversTable(this);
        }
    }
}
