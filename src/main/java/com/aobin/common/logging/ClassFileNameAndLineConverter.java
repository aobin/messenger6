package com.aobin.common.logging;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class ClassFileNameAndLineConverter extends ClassicConverter
{

  @Override
  public String convert(ILoggingEvent event)
  {
    StackTraceElement lastNonLoggingCallerFromStackTrace = getLastNonLoggingCallerFromStackTrace(event);
    return lastNonLoggingCallerFromStackTrace.getFileName() + ":" + lastNonLoggingCallerFromStackTrace.getLineNumber();
  }

  private StackTraceElement getLastNonLoggingCallerFromStackTrace(ILoggingEvent arg0)
  {
    StackTraceElement[] stack = arg0.getCallerData();

    if(stack.length >= 2)
    {
      // to accommodate wrapper classes
      // pick the 2nd element in stack when the stack length is more/equal to 2.
      return stack[1];
    }
    else
    {
      // For now, just grab the first item in the stack. If a common class file is used, this will have to traverse the list to get outside
      // of
      // that class (or else everything will look like it is logging from the same class)
      return stack[0];
    }
  }

}
