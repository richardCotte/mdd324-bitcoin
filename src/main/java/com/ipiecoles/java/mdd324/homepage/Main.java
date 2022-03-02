package com.ipiecoles.java.mdd324.homepage;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BtcParameterClass btcParameter = new BtcParameterClass("USD,EUR,JPY", 1d);
        BtcClass btcClass = BitcoinService.getBtcCourse(btcParameter);

        Genson genson = new GensonBuilder().useRuntimeType(true).create();

        String jsonOutput = genson.serialize(btcClass);
        System.out.println(jsonOutput);

    }

}
