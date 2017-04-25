package com.malidielhadad.lasalle.network;

/**
 * Created by malidielhadad on 25/04/2017.
 */

class UrlBuilder {

    private static String baseUrl = "http://58fefd5e0dcf7e00111705c8.mockapi.io/test";
    private static String pathEvents = "events";

    public static String getAllEventsUrl() {
        return baseUrl+"/"+pathEvents;
    }
    public static String getEventUrl(String id) {
        return getAllEventsUrl()+"/"+id;
    }

    public static  String getCreateEventUrl() {
        return getAllEventsUrl();
    }

    public static String getDeleteEventUrl(String id) {
        return getAllEventsUrl()+"/"+id;
    }

    public static String getUpdateEventUrl(String id) {
        return getAllEventsUrl()+"/"+id;
    }

}
