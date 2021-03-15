package com.epam.currency.repository;

import com.epam.currency.model.BaseCurrency;
import com.epam.currency.model.Rate;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @author Semion Rutshtein
 * @version 1.0
 * @comment: Repository class for saving data into tables
 */

@Component
public class DataManager {

    private Connection conn;

    @Value("${spring.datasource.url}")
    private String connectionString;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.username}")
    private String user;

    @SneakyThrows
    public void addRate (BaseCurrency baseCurrency, List<Rate> rates) {

        String sqlInsertIntoBaseTable = "insert into base_currency (id, currency_name, date) values (?, ?, ?)";
        String sqlInsertIntoRates =  "insert into rates (currency_name, currency_rate, base_currency_id) values (?, ?, ?)";

        long baseCurrencyId = System.nanoTime();

        PreparedStatement preparedStatement = conn.prepareStatement(sqlInsertIntoBaseTable);
        preparedStatement.setLong(1, baseCurrencyId);
        preparedStatement.setString(2, baseCurrency.getCurrencyName());
        preparedStatement.setLong(3, baseCurrency.getDate());

        PreparedStatement preparedStatementForRates = conn.prepareStatement(sqlInsertIntoRates);

        for (Rate rate: rates) {
            preparedStatementForRates.setString(1, rate.getCurrencyName());
            preparedStatementForRates.setDouble(2, rate.getCurrencyRate());

            rate.setBaseCurrencyId(baseCurrencyId);
            preparedStatementForRates.setLong(3, rate.getBaseCurrencyId());

            preparedStatementForRates.addBatch();


        }
        int row = preparedStatement.executeUpdate();
        preparedStatementForRates.executeBatch();
    }
    @SneakyThrows
    public Connection getConnection() {
        this.conn = DriverManager.getConnection(connectionString, user, password);

        return this.conn;
    }

    @SneakyThrows
    public void closeConnection () {
        this.conn.close();
    }



}
