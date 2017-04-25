package com.malidielhadad.lasalle.network;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.malidielhadad.lasalle.model.Event;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.Arrays;
import java.util.List;

/**
 * Created by malidielhadad on 25/04/2017.
 */

public class EventManager {

    private static EventManagerListener listener;

    interface EventManagerListener{
        void onEventsReceived(List<Event> events);
        void onEventsFailed();

    }
    public static void getAllEvents(final EventManagerListener listener) {
        String url = UrlBuilder.getAllEventsUrl();
    }

    public static void getAllEvents() {

        String url = UrlBuilder.getAllEventsUrl();

        JacksonRequest<Event[]> requestEvents = new JacksonRequest<Event[]>(Request.Method.GET, url,
                new JacksonRequestListener<Event[]>() {
                    @Override
                    public void onResponse(Event[] response, int statusCode, VolleyError error) {

                        // callback
                        if(listener != null ) {
                            if(response != null){
                                listener.onEventsReceived(Arrays.asList(response));
                            }
                            if(error != null){
                                listener.onEventsFailed();
                            }
                        }

                    }

                    @Override
                    public JavaType getReturnType() {
                        return ArrayType.construct(SimpleType.constructUnsafe(Event.class), null);
                    }
                });


    }
}
