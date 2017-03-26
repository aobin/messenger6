package com.aobin.common.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;

public class LifecycleFilter extends Filter<ILoggingEvent>
{

  @Override
  public FilterReply decide(ILoggingEvent event)
  {
    Marker marker = event.getMarker();
    if(marker != null && marker.equals(WpLoggerConstants.MARKER_LIFECYCLE))
    {
      return FilterReply.ACCEPT;
    }
    else
    {
      return FilterReply.DENY;
    }
  }

}
