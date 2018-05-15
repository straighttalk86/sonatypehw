package com.straighttalk.converters;

import org.apache.commons.lang3.StringUtils;

public class NumbersToWords {
    private final static String[] to_19 = {"zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private final static String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private final static String[] denom = {"",
            "thousand", "million", "billion", "trillion", "quadrillion",
            "quintillion", "sextillion", "septillion", "octillion", "nonillion",
            "decillion", "undecillion", "duodecillion", "tredecillion", "quattuordecillion",
            "sexdecillion", "septendecillion", "octodecillion", "novemdecillion", "vigintillion"};


    public NumbersToWords() {
    }

    // convert a value < 100 to English.
    private String convert_nn(int val) {
        if (val < 20)
            return to_19[val];
        String dcap = "";
        for (int v = 0; v < tens.length; v++) {
            dcap = tens[v];
            int dval = 20 + 10 * v;
            if (dval + 10 > val) {
                if ((val % 10) != 0)
                    dcap += " " + to_19[val % 10];
                break;
            }
        }
        return dcap;
    }

    // convert a value < 1000 to english
    private String convert_nnn(int val) {
        String word = "";
        int rem = val / 100;
        int mod = val % 100;
        if (rem > 0) {
            word = to_19[rem] + " hundred and";
            if (mod > 0) {
                word = word + " ";
            }
        }
        if (mod > 0) {
            word = word + convert_nn(mod);
        }
        return word;
    }

    public String convert(int val) {
        String ret = "";

        if (val < 100) {
            ret = convert_nn(val);
        } else if (val < 1000) {
            ret = convert_nnn(val);
        } else {
            for (int v = 0; v < denom.length; v++) {
                int didx = v - 1;
                int dval = new Double(Math.pow(1000, v)).intValue();
                if (dval > val) {
                    int mod = new Double(Math.pow(1000, didx)).intValue();
                    int l = val / mod;
                    int r = val - (l * mod);
                    ret = convert_nnn(l) + " " + denom[didx];
                    if (r > 0) {
                        ret += " " + convert(r);
                    }
                    break;
                }
            }
        }
        return StringUtils.capitalize(StringUtils.lowerCase(ret));
    }
}
