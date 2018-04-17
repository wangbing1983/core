package com.exorcist.msa.core.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppThreadCache {
  private static final ThreadLocal<AppThreadCache.ThreadContext> cache = new ThreadLocal<AppThreadCache.ThreadContext>() {
    protected AppThreadCache.ThreadContext initialValue() {
      return new AppThreadCache.ThreadContext(null);
    }
  };

  public AppThreadCache() {
  }

  public static void setExtraData(String key, Object data) {
    ((AppThreadCache.ThreadContext)cache.get()).extraData.put(key, data);
  }

  public static Object getExtraData(String key) {
    return ((AppThreadCache.ThreadContext)cache.get()).extraData.get(key);
  }

  public static void setStartTime() {
    ((AppThreadCache.ThreadContext)cache.get()).startTime = System.currentTimeMillis();
  }

  public static long getStartTime() {
    return ((AppThreadCache.ThreadContext)cache.get()).startTime;
  }

  public static void setStaffId(Integer staffId) {
    ((AppThreadCache.ThreadContext)cache.get()).staffId = staffId;
  }

  public static long getStaffId() {
    return (long)((AppThreadCache.ThreadContext)cache.get()).staffId;
  }

  private static class ThreadContext {
    Integer staffId;
    long startTime;
    Map<String, Object> extraData;

    private ThreadContext() {
      this.extraData = new ConcurrentHashMap();
    }
  }
