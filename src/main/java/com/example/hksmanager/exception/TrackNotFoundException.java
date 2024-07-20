package com.example.hksmanager.exception;

public class TrackNotFoundException extends RuntimeException{

    public TrackNotFoundException(String message){
        super(message);
    }
}
