package com.epam.currency.model;

import lombok.*;

/**
 * @author Semion Rutshtein
 * @version 1.0
 * @comment: Entity class for rates
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rate {
    private double currencyRate;
    private String currencyName;
    private Long baseCurrencyId;

}
