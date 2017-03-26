package com.aobin.common.logging;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public interface WpLoggerConstants
{
  Marker MARKER_LIFECYCLE = MarkerFactory.getMarker("LIFECYCLE");
  Marker MARKER_CATASTROPHIC = MarkerFactory.getMarker("CATASTROPHIC");
}
