package com.example;

public interface ExternalApi {

    String getData();

    String getData(String input);

    void connect();

    void disconnect();
}