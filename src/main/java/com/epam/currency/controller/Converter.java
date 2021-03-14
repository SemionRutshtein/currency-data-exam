package com.epam.currency.controller;

import com.epam.currency.model.BaseCurrency;
import com.epam.currency.model.Rate;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Semion Rutshtein
 * @version 1.0
 * @comment:
 */
public class Converter {
        public static Map<BaseCurrency, List<Rate>> convert (@NonNull String json) {



            JsonElement jsonTree =JsonParser.parseString(json);
            JsonElement base = null;
            JsonElement date = null;
            List<Rate> ratesList = new ArrayList<>();
            if(jsonTree.isJsonObject()){
                JsonObject jsonObject = jsonTree.getAsJsonObject();

                JsonElement rates = jsonObject.get("rates");

                base = jsonObject.get("base");


                date = jsonObject.get("date");


                if(rates.isJsonObject()) {
                    String baseCurrent = base.getAsString();


                    JsonObject ratesObject = rates.getAsJsonObject();
                    Set<String> currencies = ratesObject.keySet();
                    for (String str: currencies) {
                        JsonElement jsonElement = ratesObject.get(str);
                        double asDouble = jsonElement.getAsDouble();

                        ratesList.add(new Rate(asDouble, str, null));
                    }


                }
//


            }

            BaseCurrency baseCurrency = new BaseCurrency(base.getAsString(),getCurrentDate(date.getAsString()) );

            Map<BaseCurrency, List<Rate>> pojos =  new HashMap<>();
            pojos.put(baseCurrency, ratesList);
            return pojos;
        }

        @SneakyThrows
        public static Long getCurrentDate (String myDate) {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            Date date = simpleDateFormat.parse ( myDate);
            return  date.getTime();
        }

}
