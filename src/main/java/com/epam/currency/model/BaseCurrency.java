package com.epam.currency.model;

import lombok.*;

/**
 * @author Semion Rutshtein
 * @version 1.0
 * @comment: Entity class our base currency
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseCurrency {

    private String currencyName;
    private long date;
}
