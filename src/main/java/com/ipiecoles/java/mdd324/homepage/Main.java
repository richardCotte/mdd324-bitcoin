package com.ipiecoles.java.mdd324.homepage;

import com.ipiecoles.java.mdd324.homepage.utils.Utils;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        Double bitcoinAmount = 1d;
        String currencyList = "EUR,USD,JPY";

        String bitcoinCourseJson = Utils.getPageContents("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=" + currencyList);

        Genson genson = new GensonBuilder().useRuntimeType(true).create();
        Map<String, Object> map = genson.deserialize(bitcoinCourseJson, Map.class);
        String[] currencyArray = currencyList.split(",");

        HashMap<String, Double> hashMap = new HashMap<>();

        for (String currency :
                currencyArray) {
            Double bitcoinVal = Math.round((Double) map.get(currency) * bitcoinAmount * 100) / 100d;
            hashMap.put(currency, bitcoinVal);
        }
        BTCClass btcClass = new BTCClass(hashMap, bitcoinAmount);
        System.out.print(btcClass);
    }

}
