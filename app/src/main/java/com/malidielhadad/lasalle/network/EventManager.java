package com.malidielhadad.lasalle.network;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.malidielhadad.lasalle.LasalleApp;
import com.malidielhadad.lasalle.model.Event;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.Arrays;
import java.util.List;

/**
 * Created by malidielhadad on 25/04/2017.
 */

public class EventManager {

    public static EventManager listener;


    public interface Listener<T> {
        void onReceived(T result);
        void onFailed();
    }

  /*
    public interface EventManagerListener{
        void onEventsReceived(List<Event> events);
        void onEventsFailed();

    }

    public interface EventListener {
        void onEventsReceived(Event event);
        void onEventsFailed();
    } */

    public static void getAllEvents(final Listener<List<Event>> listener) {

        String url = UrlBuilder.getAllEventsUrl();

        JacksonRequest<Event[]> requestEvents = new JacksonRequest<Event[]>(Request.Method.GET, url,
                new JacksonRequestListener<Event[]>() {
                    @Override
                    public void onResponse(Event[] response, int statusCode, VolleyError error) {

                        // callback
                        if(listener != null ) {
                            if(response != null){
                                listener.onReceived(Arrays.asList(response));
                            }
                            if(error != null){
                                listener.onFailed();
                            }
                        }

                    }

                    @Override
                    public JavaType getReturnType() {
                        return ArrayType.construct(SimpleType.constructUnsafe(Event.class), null);
                    }
                });

        LasalleApp
                .getSharedInstance()
                .getRequestQueue()
                .add(requestEvents);

    }

    public static void getEvent(String eventId, final Listener<Event> listener) {

        String url = UrlBuilder.getEventUrl(eventId);

        JacksonRequest<Event> requestEvent = new JacksonRequest<Event>(Request.Method.GET,
                url, new JacksonRequestListener<Event>() {
            @Override
            public void onResponse(Event response, int statusCode, VolleyError error) {

                if(listener != null) {
                    if(response != null) {
                        listener.onReceived(response);
                    } else if (error != null) {
                        listener.onFailed();
                    }
                }

            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(Event.class);
            }
        });
        LasalleApp
                .getSharedInstance()
                .getRequestQueue()
                .add(requestEvent);
    }
}
