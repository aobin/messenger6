package com.aobin.messenger.jms;

import javax.jms.Destination;


public interface MessegeProducer
{
    void sendMessage(Destination destination, final String message);
}
