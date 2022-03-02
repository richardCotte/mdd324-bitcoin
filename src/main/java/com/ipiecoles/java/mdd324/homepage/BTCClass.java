package com.ipiecoles.java.mdd324.homepage;

import java.util.HashMap;

public class BTCClass {
    private HashMap<String, Double> currenciesEquivalent;
    private Double btcAmount;

    public BTCClass(HashMap<String, Double> currenciesEquivalent, Double btcAmount) {
        this.currenciesEquivalent = currenciesEquivalent;
        this.btcAmount = btcAmount;
    }

    public HashMap<String, Double> getCurrenciesEquivalent() {
        return currenciesEquivalent;
    }

    public void setCurrenciesEquivalent(HashMap<String, Double> currenciesEquivalent) {
        this.currenciesEquivalent = currenciesEquivalent;
    }

    public Double getBtcAmount() {
        return btcAmount;
    }

    public void setBtcAmount(Double btcAmount) {
        this.btcAmount = btcAmount;
    }

    @Override
    public String toString() {
        return "BTCClass{" +
                "currenciesEquivalent=" + currenciesEquivalent +
                ", btcAmount=" + btcAmount +
                '}';
    }
}
