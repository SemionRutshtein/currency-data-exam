package com.epam.currency;

import com.epam.currency.controller.Converter;
import com.epam.currency.model.BaseCurrency;
import com.epam.currency.model.Rate;
import com.epam.currency.repository.DataManager;
import com.epam.currency.utill.UrlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class CurrencyApplication implements CommandLineRunner {
    @Autowired
    private DataManager dataManager;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CurrencyApplication.class, args);

    }
    @Override
    public void run(String... args) {
        System.out.printf("data" + dataManager);
        String currentCurrency = "ILS";
        String url = "https://api.exchangeratesapi.io/latest?base=";

        URL myUrl = UrlParser.currentURL(url, currentCurrency);
        String realJsonAfterParsing = UrlParser.parseUrl(myUrl);

        dataManager.getConnection();

        Map<BaseCurrency, List<Rate>> convert = Converter.convert(realJsonAfterParsing);
        Set<Map.Entry<BaseCurrency, List<Rate>>> entries = convert.entrySet();
        List<Map.Entry<BaseCurrency, List<Rate>>> list = new ArrayList(entries);
        Map.Entry<BaseCurrency, List<Rate>> first = list.get(0);

        dataManager.addRate(first.getKey(),  first.getValue());

//       List<Rate> rates =  new ArrayList<>();
//       rates.add(new Rate(1.2D, "HKD", null));
//       rates.add(new Rate(1.23D, "HKD", null));
//       rates.add(new Rate(1.43D, "ISK", null));
//       dataManager.addRate(new BaseCurrency("USD", System.currentTimeMillis()), rates);

        dataManager.closeConnection();

    }

}
