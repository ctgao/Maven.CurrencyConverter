package io.zipcoder.currencyconverterapplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CurrencyType {
    AUSTRALIAN_DOLLAR(2.70),
    CANADIAN_DOLLAR(2.64),
    CHINESE_YR(13.84),
    EURO(1.88),
    FRANC(2.02),
    POUND(1.64),
    RINGGIT(8.94),
    RUPEE(136.64),
    SINGAPORE_DOLLAR(1.86),
    US_DOLLAR(2.0),
    UNIVERSAL_CURRENCY(1.0),
    YEN(231.68);

    private final double rate;

    CurrencyType(double rate) {
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public static CurrencyType getTypeOfCurrency(ConvertableCurrency currency) {
        String currencyName = currency.getClass().getSimpleName();
//        Pattern pattern;
//        Matcher matcher;
//        for(CurrencyType ct : CurrencyType.values()){
//            String ctName = ct.name();
//            ctName = ctName.indexOf("_") == -1 ? ctName : ctName.substring(0, ctName.indexOf("_"));
//            pattern = Pattern.compile(ctName, Pattern.CASE_INSENSITIVE);
//            matcher = pattern.matcher(currencyName);
//            if(matcher.find()){
//                return ct;
//            }
//        }
        // Here's another way that doesn't use pattern and matcher!
        // You have to get the SIMPLE name otherwise it'll give you the whole entire class
        // which includes the package name
        for(CurrencyType ct : CurrencyType.values()){
            String ctName = ct.name().replace("_", "");
            if(currencyName.equalsIgnoreCase(ctName)){
                return ct;
            }
        }
        // OH NO BAD CURRENCY!!!
        return null;
    }
}
