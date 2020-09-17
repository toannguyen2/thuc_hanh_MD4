package org.codegym.helper;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FormatNumber {
    public FormatNumber(){}

    public static String format(BigDecimal n) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(n);
    }
}
