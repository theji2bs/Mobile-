package com.malidielhadad.lasalle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by malidielhadad on 25/04/2017.
 */


@JsonIgnoreProperties(ignoreUnknown = true)

public class Event {

    public static class Location {
        private double latitude, longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double laditude) {
            this.latitude = laditude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }


    private String id, name, imageUrl, updatedAt, createdAt, description;
    private String information;
    private Location location;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updateAt) {
        this.updatedAt = updateAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

