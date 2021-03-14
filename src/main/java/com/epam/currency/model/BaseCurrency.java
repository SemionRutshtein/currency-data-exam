package com.epam.currency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Semion Rutshtein
 * @version 1.0
 * @comment: Entity class for base currency
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseCurrency {

    private String currencyName;
    private long date;
}
