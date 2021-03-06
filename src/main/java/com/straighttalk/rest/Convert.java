package com.straighttalk.rest;

import com.straighttalk.converters.NumbersToWords;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Locale;
import java.text.SimpleDateFormat;

/**
 * Convert --- REST API serving up end points needed to convert
 * numbers to words.
 * @author    Joshua Buzzard
 */
@Path("/convert")
public class Convert {

    /**
     * numbersToWords end point - takes a number to convert param and the language to convert
     * it to.
     * @param numToConv An int to convert to words
     * @return JSON containing the int converted to words
     */
    @GET
    @Path("/numbersToWords")
    @Produces(MediaType.APPLICATION_JSON)
    public String numbersToWords(@QueryParam("numToConv") int numToConv) {
        NumbersToWords n = new NumbersToWords();
        JSONObject j = new JSONObject();
        j.put("conversion", n.convert(numToConv));
        return j.toString();
    }


    /**
     * localeList - returns the list of supported locale languages that the number
     * can be converted into
     * @return JSON array of the supported languages
     */
    @GET
    @Path("/localeList")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLocaleList() {
        Locale locales[] = SimpleDateFormat.getAvailableLocales();
        JSONArray list = new JSONArray();
        //iterate through each locale
        for (int i = 0; i < locales.length; i++) {
            list.put(locales[i].toString());
        }
        return list.toString();
    }
}