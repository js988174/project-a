package com.kim.util;

public interface ObjectFactory<T> {
  T create(String csvStr);
}
