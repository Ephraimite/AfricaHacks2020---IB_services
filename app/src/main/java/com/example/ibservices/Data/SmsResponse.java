
package com.example.ibservices.Data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SmsResponse {

    @SerializedName("message-count")
    private String mMessageCount;
    @SerializedName("messages")
    private List<Message> mMessages;


    public String getMessageCount() {
        return mMessageCount;
    }

    public void setMessageCount(String messageCount) {
        mMessageCount = messageCount;
    }

    public List<Message> getMessages() {
        return mMessages;
    }

    public void setMessages(List<Message> messages) {
        mMessages = messages;
    }

}
