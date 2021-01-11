/**
 * 
 */
package com.path.bo.core.account;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AccountQueryConstant.java used to
 */
public class AccountQueryConstant
{
    public static final HashMap<BigDecimal, String> keyRef = new HashMap<BigDecimal, String>();
    static
    {
      keyRef.put(BigDecimal.ONE, "January_key");
      keyRef.put(BigDecimal.valueOf(2), "February_key");
      keyRef.put(BigDecimal.valueOf(3), "March_key");
      keyRef.put(BigDecimal.valueOf(4), "April_key");
      keyRef.put(BigDecimal.valueOf(5), "May_key");
      keyRef.put(BigDecimal.valueOf(6), "June_key");
      keyRef.put(BigDecimal.valueOf(7), "July_key");
      keyRef.put(BigDecimal.valueOf(8), "August_key");
      keyRef.put(BigDecimal.valueOf(9), "September_key");
      keyRef.put(BigDecimal.TEN, "October_key");
      keyRef.put(BigDecimal.valueOf(11), "November_key");
      keyRef.put(BigDecimal.valueOf(12), "December_key");
    }
}