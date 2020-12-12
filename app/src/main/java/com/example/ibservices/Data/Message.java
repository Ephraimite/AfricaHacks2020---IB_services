
package com.example.ibservices.Data;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("account-ref")
    private String mAccountRef;
    @SerializedName("client-ref")
    private String mClientRef;
    @SerializedName("message-id")
    private String mMessageId;
    @SerializedName("message-price")
    private String mMessagePrice;
    @SerializedName("network")
    private String mNetwork;
    @SerializedName("remaining-balance")
    private String mRemainingBalance;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("to")
    private String mTo;

    public String getAccountRef() {
        return mAccountRef;
    }

    public void setAccountRef(String accountRef) {
        mAccountRef = accountRef;
    }

    public String getClientRef() {
        return mClientRef;
    }

    public void setClientRef(String clientRef) {
        mClientRef = clientRef;
    }

    public String getMessageId() {
        return mMessageId;
    }

    public void setMessageId(String messageId) {
        mMessageId = messageId;
    }

    public String getMessagePrice() {
        return mMessagePrice;
    }

    public void setMessagePrice(String messagePrice) {
        mMessagePrice = messagePrice;
    }

    public String getNetwork() {
        return mNetwork;
    }

    public void setNetwork(String network) {
        mNetwork = network;
    }

    public String getRemainingBalance() {
        return mRemainingBalance;
    }

    public void setRemainingBalance(String remainingBalance) {
        mRemainingBalance = remainingBalance;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTo() {
        return mTo;
    }

    public void setTo(String to) {
        mTo = to;
    }

}
