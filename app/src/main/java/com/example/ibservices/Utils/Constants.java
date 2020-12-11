package com.example.ibservices.Utils;

public class Constants {
    public static final String SERVICE_TYPE =  key("SERVICE TYPE");
    public static final String DATE =  key("DATE");
    public static final String TIME =  key("APPOINTMENT TIME");
    public static final String HOUSE_TYPE =  key("HOUSE TYPE");
    public static final String NO_OF_ROOMS =  key("NO OF ROOMS");
    public static final String PARCELS =  key("PARCELS");
    public static final String CLOTH_TYPE =  key("CLOTH_TYPE");
    public static final String NO_OF_CLOTH =  key("NO_OF_CLOTH");
    public static final String TOTAL_PRICE =  key("TOTAL_PRICE");


    public static final String API_KEY = "9638fb73";
    public static final String SECRET_KEY = "e9P0XjIdc3lGsQuu";


    private static String key(String key){
        return Constants.class.getSimpleName()+key;
    }

}
