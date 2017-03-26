package com.aobin.common.logging;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.CoreConstants;

import java.util.ArrayList;
import java.util.List;

public class StackTraceFilterConverter extends ClassicConverter
{

  List<String> ignoredStackTraceLines = null;

  public void start()
  {
    final List<String> optionList = getOptionList();

    if(optionList != null && optionList.size() > 1)
    {
      final int optionListSize = optionList.size();
      for(int i = 0; i < optionListSize; i++)
      {
        String ignoredStackTraceLine = optionList.get(i);
        addIgnoreStackTraceLine(ignoredStackTraceLine);
      }
    }
    super.start();
  }

  private void addIgnoreStackTraceLine(String ignoredStackTraceLine)
  {
    if(ignoredStackTraceLines == null)
    {
      ignoredStackTraceLines = new ArrayList<String>();
    }
    ignoredStackTraceLines.add(ignoredStackTraceLine);
  }

  @Override
  public String convert(ILoggingEvent event)
  {
    IThrowableProxy tp = event.getThrowableProxy();

    if(tp == null)
    {
      return CoreConstants.EMPTY_STRING;
    }

    StringBuilder buf = new StringBuilder(2048);
    subjoinRootCauseFirst(tp, buf);
    return buf.toString();
  }

  private void subjoinRootCauseFirst(IThrowableProxy tp, StringBuilder buf)
  {
    if(tp.getCause() != null)
    {
      subjoinRootCauseFirst(tp.getCause(), buf);
    }
    subjoinRootCause(tp, buf);
  }

  private void subjoinRootCause(IThrowableProxy tp, StringBuilder buf)
  {
    ThrowableProxyUtil.subjoinFirstLineRootCauseFirst(buf, tp);
    buf.append(CoreConstants.LINE_SEPARATOR);
    StackTraceElementProxy[] stepArray = tp.getStackTraceElementProxyArray();

    int length = stepArray.length;

    int maxIndex = length;

    int ignoredCount = 0;
    for(int i = 0; i < maxIndex; i++)
    {
      String string = stepArray[i].toString();
      if(!isIgnoredStackTraceLine(string))
      {
        buf.append(CoreConstants.TAB);
        buf.append(string);
        if(ignoredCount > 0)
        {
          buf.append(" [" + ignoredCount + " skipped]");
          ignoredCount = 0;
        }
        buf.append(CoreConstants.LINE_SEPARATOR);
      }
      else
      {
        ++ignoredCount;
      }
    }

  }

  private boolean isIgnoredStackTraceLine(String line)
  {
    if(ignoredStackTraceLines != null)
    {
      for(String ignoreStackTraceLine : ignoredStackTraceLines)
      {
        if(line.contains(ignoreStackTraceLine))
        {
          return true;
        }
      }
    }
    return false;
  }

}
