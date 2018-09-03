package com.example.demo.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentList<T> implements List<T>{
  
  private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private final List<T> list;
  
  public ConcurrentList(List<T> list) {
    this.list = list;
  }
 /**
  * write lock으로 Thread Safe 환경을 만들어주고 해당 명령어를 실행시킨 뒤 unlock 한다.
  * 보기에는 마치 transaction 방식처럼 느껴지면서 성능에 영향을 미칠 것 같지만 생각외로 효율이 좋음!
  * (구현하지 않은 코드는 사용하지 말기)
  * 
  */
  @Override
  public int size() {
    readWriteLock.readLock().lock();
    try {
      return list.size();
    }finally {
      readWriteLock.readLock().unlock();
    }
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean contains(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object[] toArray() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean add(T t) {
    readWriteLock.writeLock().lock();
    boolean success;
    try {
      success = list.add(t);
    }finally {
      readWriteLock.writeLock().unlock();
    }
    return success;
  }

  @Override
  public boolean remove(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public T get(int index) {
    readWriteLock.readLock().lock();
    try {
      return list.get(index);
    }finally {
      readWriteLock.readLock().unlock();
    }
  }

  @Override
  public T set(int index, T element) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void add(int index, T element) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public T remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int indexOf(Object o) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public ListIterator<T> listIterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    // TODO Auto-generated method stub
    return null;
  }

}
