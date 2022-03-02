package com.ipiecoles.java.mdd324.homepage;

public class BtcParameterClass {

    private String currencyList;
    private Double bitcoinAmount;

    public BtcParameterClass(String currencyList, Double bitcoinAmount) {
        this.currencyList = currencyList;
        this.bitcoinAmount = bitcoinAmount;
    }

    public String getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(String currencyList) {
        this.currencyList = currencyList;
    }

    public Double getBitcoinAmount() {
        return bitcoinAmount;
    }

    public void setBitcoinAmount(Double bitcoinAmount) {
        this.bitcoinAmount = bitcoinAmount;
    }

}
