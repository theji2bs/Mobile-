package com.malidielhadad.lasalle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by malidielhadad on 26/04/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventResult {

    private Event event;

    @JsonProperty("data")
    public Event getEvent() {
        return event;
    }

    @JsonProperty("data")
    public void setEvent(Event event) {
        this.event = event;
    }
}
