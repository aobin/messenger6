package com.aobin.common.logging;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHostConverter extends ClassicConverter
{
  private static String HOSTNAME;

  static
  {
    try
    {
      // Storing it in static field to prevent the cost of getting
      // it every time we are logging anything.
      HOSTNAME = InetAddress.getLocalHost().getHostName();
    }
    catch(UnknownHostException e)
    {
      HOSTNAME = "UNKNOWN";
    }
  }

  public String convert(ILoggingEvent arg0)
  {
    return HOSTNAME;
  }

}
