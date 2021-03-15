package com.epam.currency.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Semion Rutshtein
 * @version 1.0
 * @comment: All currency enum
 */

@Getter
@ToString
@AllArgsConstructor
public enum CurrencyEnum {
    CAD ("CAD"),
    HKD ("HKD"),
    ISK ("ISK"),
    PHP ("PHP"),
    DKK ("DKK"),
    HUF ("HUF"),
    CZK ("CZK"),
    GBP ("GBP"),
    RON ("RON"),
    SEK ("SEK"),
    IDR ("IDR"),
    INR ("INR"),
    BRL ("BRL"),
    RUB ("RUB"),
    HRK ("HRK"),
    JPY ("JPY"),
    THB ("THB"),
    CHF ("CHF"),
    EUR ("EUR"),
    MYR ("MYR"),
    BGN ("BGN"),
    TRY ("TRY"),
    CNY ("CNY"),
    NOK ("NOK"),
    NZD ("NZD"),
    ZAR ("ZAR"),
    USD ("USD"),
    MXN ("MXN"),
    SGD ("SGD"),
    AUD ("AUD"),
    ILS ("ILS"),
    KRW ("KRW"),
    PLN ("PLN");

    private final String currency;


}
