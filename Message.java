/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.quickchat;

/**
 *
 * @author Shiko
 */
public class Message {

    private static int messageCount = 0;

    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;

    public Message(String recipient, String message) {
        messageCount++;
        this.messageID = "MSG" + messageCount;
        this.recipient = recipient;
        this.message = message;
        this.messageHash = createMessageHash();
    }

    public boolean checkMessageLength() {
        return message != null && message.length() <= 250;
    }

    public boolean checkRecipientCell() {
        return recipient != null && recipient.matches("^\\+27\\d{9}$");
    }

    public String createMessageHash() {

        if (message == null || message.isEmpty()) {
            return "INVALID";
        }

        String[] words = message.split(" ");

        String first = words[0];
        String last = words[words.length - 1];

        return (messageID + ":" + messageCount + ":" + first + last).toUpperCase();
    }

    public String getMessageDetails() {
        return "Message ID: " + messageID +
               "\nRecipient: " + recipient +
               "\nMessage: " + message +
               "\nMessage Hash: " + messageHash;
    }

    public static int returnTotalMessages() {
        return messageCount;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageHash() {
        return messageHash;
    }
}
