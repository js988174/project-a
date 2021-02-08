package com.kim.util;

public class Stack extends List implements Cloneable {

  public Object push(Object item) {
    this.add(item);
    return item;
  }
  public Object pop() {
    return this.delete(this.size-1);
  }

  @Override
  public Stack clone() throws CloneNotSupportedException {
    Stack stack = new Stack();

    for (int i =0; i < size; i++) {
      stack.push(get(i));
    }
    return stack;
  }
}
