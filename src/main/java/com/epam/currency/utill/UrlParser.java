package com.epam.currency.utill;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Semion Rutshtein
 * @version 1.0
 * @comment: Class for parsing url in string
 */
public class UrlParser {

    @SneakyThrows
    public static URL currentURL(String url, String currency) {
        String resultStr = url+currency;
        URL res = new URL(resultStr);
        return res;
    }

    // Parsing our current URL to String and save data inside
    public static String parseUrl (URL url) {

        if (url == null) {
            return "This is empty url";
        }

        StringBuilder stringBuilder = new StringBuilder();
        //Open a URL connection for reading data inside
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            // Read data and save in StringBuilder
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
