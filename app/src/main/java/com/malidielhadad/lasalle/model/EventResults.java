package com.malidielhadad.lasalle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by malidielhadad on 26/04/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventResults extends BaseResponse {
    private Event[] data;

    public EventResults(){

    }
    public Event[] getData() {
        return data;
    }

    public void setData(Event[] data) {
        this.data = data;
    }
}
