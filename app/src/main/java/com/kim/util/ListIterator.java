package com.kim.util;

public class ListIterator {
  List list;
  int cursor = 0;

  public ListIterator(List list) {
    list =list;
  }
  public boolean hasNext() {
    return cursor < list.size();
  }
  public Object next() {
    return cursor < list.size();
  }

}
