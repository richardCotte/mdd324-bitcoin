package com.ipiecoles.java.mdd324.homepage;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LambdaApp implements RequestHandler<Map<String, Object>, GatewayResponse> {

    @Override
    public GatewayResponse handleRequest(Map<String, Object> input, Context context) {

        BtcClass btcClass = null;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Access-Control-Allow-Origin", "https://pjvilloud.github.io");
        Genson genson = new GensonBuilder().useRuntimeType(true).create();

        BtcParameterClass btcParameter = genson.deserialize((String)input.get("body"), BtcParameterClass.class);

        try {
            btcClass = BitcoinService.getBtcCourse(btcParameter);
        } catch (IOException e) {
            return new GatewayResponse(
                    "{'error':'Erreur interne'}",
                    headers,
                    500
            );
        }

        String jsonOutput = genson.serialize(btcClass);

        return new GatewayResponse(
                jsonOutput,
                headers,
                200
        );

    }
}
