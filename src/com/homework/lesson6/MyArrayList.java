package com.homework.lesson6;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList<T> extends AbstractList<T> {
    private int size = 0;
    private static final int MAX_SIZE = 10;
    private T[] data;

    public MyArrayList() {
        data = (T[]) new Object[MAX_SIZE];
    }

    @Override
    public boolean add(T element) {
        if (size == MAX_SIZE) {
            throw new MyArrayStoreException("Size must be less then 10");
        }
        data[size] = element;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new MyArrayStoreException("Index more then size");
        }
        return data[index];
    }

    @Override
    public boolean remove(Object element) {
        if (element == null) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                removeAndShift(i);
                return true;
            }
        }
        return false;
    }

    private void removeAndShift(int index) {
        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[data.length - 1] = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (cursor>=size){
                throw new MyArrayStoreException("cursor bigger than size");
            }
            T next = data[cursor];
            cursor++;
            return next;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(data[cursor-1]);
            cursor--;
        }
    }

}
