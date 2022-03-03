package com.ipiecoles.java.mdd324.homepage;

import com.ipiecoles.java.mdd324.homepage.utils.Utils;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BitcoinService {

    public static BtcClass getBtcCourse(BtcParameterClass btcParameter) throws IOException {

        System.out.println(btcParameter);

        String bitcoinCourseJson = Utils.getPageContents("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=" + btcParameter.getCurrencyList());
        Genson genson = new GensonBuilder().useRuntimeType(true).create();

        Map<String, Object> map = genson.deserialize(bitcoinCourseJson, Map.class);
        String[] currencyArray = btcParameter.getCurrencyList().split(",");

        HashMap<String, Double> hashMap = new HashMap<>();

        for (String currency :
                currencyArray) {
            Double bitcoinVal = Math.round((Double) map.get(currency) * btcParameter.getBitcoinAmount() * 100) / 100d;
            hashMap.put(currency, bitcoinVal);
        }

        return new BtcClass(hashMap, btcParameter.getBitcoinAmount());

    }

}
