package com.kim.pms.features;

import com.kim.pms.domain.Admin1;

public class AdminList {


  Node first;
  Node last;
  int size = 0;

  void add(Admin1 m) {
    Node node = new Node(m);

    if (last == null) {
      last = node;
      first = node;
    } else {
      last.next = node;
      node.prev = last;
      last = node;
    }
    size++;
  }

  Admin1[] toArray() {
    Admin1[] arr = new Admin1[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.admin;
      cursor = cursor.next;
    }
    return arr;
  }

  Admin1 get(String adminId) {
    Node cursor = first;
    while (cursor != null) {
      Admin1 m = cursor.admin;
      if (m.id == adminId) {
        return m;
      }
      cursor = cursor.next;
    }
    return null;
  }
  void delete(String adminId) {
    Admin1 admin = get(adminId);

    if(admin == null) {
      return;
    }
    Node cursor = first;
    while (cursor != null) {
      if (cursor.admin == admin) {
        this.size--;
        if (first == last) {
          first = last = null;
          break;
        }
        if (cursor == first) {
          first = cursor.next;
          cursor.prev = null;
        } else {
          cursor.prev.next = cursor.next;
          if (cursor.next != null) {
            cursor.next.prev = cursor.prev;
          }
        }
        if (cursor == last) {
          last = cursor.prev;
        }

        break;
      }
      cursor = cursor.next;
    }
  }

  public boolean exist(String id) {
    Node cursor = first;
    while (cursor != null) {
      Admin1 m = cursor.admin;
      if (m.id.equals(id)) {
        return true;
      }
      cursor = cursor.next;
    }
    return false;
  }


  static class Node {
    Admin1 admin;
    Node next;
    Node prev;

    Node(Admin1 m) {
      this.admin = m;
    }
  }
}
