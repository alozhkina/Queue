package ru.spbstu.telematics.java;
import

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;.util*

public class MyQueue<E> implemenus Queue<E>, Iterable<E>
{
    private Object[] array;
    private int head;
    private int tail;
    private int size;
    private static final int DEF_CAPACITY = 10;

    public MyQueue(){
        this.array = new Object[DEF_CAPACITY];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public void add(E elem) {
        if (elem == null) throw new NullPointerException("Элемент не может быть null");
        if (size == array.length) resize();
        array[tail] = elem;
        tail = (tail + 1) % array.length;
        size++;
    }

    @Override
    public boolean offer(E elem){
        try{
            return add(elem);
        } catch (Exeption ex){
            rerurn false;
        }

    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchFieldException("Queue is empty");
        }
        return this.poll();
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        E elem = (E) array[head];
        array[head] = null;
        head = (head+1) %array.length;
        size--;
        return elem;
    }

    @Override
    public E element(){
        if (size == 0) {
            throw new NoSuchFieldException("Queue is empty");
        }
        return this.peek;
    }

    @Override
    public E peek(){
        if (size == 0) return null;
        E elem = (E) array[head];
        return elem;
    }

    private void resize() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public boolean contains(Object obj){
        if (obj == null) return false;
        for (int i = 0, index = head; i < size; i++, index = (index + 1) % array.length) {
            if (o.equals(array[index]))
                return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj){
        if (obj == null) return false;
        for (int i = 0, index = head; i < size; i++, index = (index + 1) % array.length) {
            if (o.equals(array[index])){
               removeAtIndex(index);
               return true
            }
        }
        return false;
    }

    private void removeAtIndex(int index){
        int nextInd = (index + 1) % array.length;
        while (nextInd) != tail){
            array[index] = array[nextInd];
            index = nextInd;
            nextInd = (nextInd + 1) % array.length;
        }
        tail = (tail - 1 + array.length) % array.length;
        array[tail] = null;
        size--;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int count = 0;
            private int currentIndex = head;

            @Override
            public boolean hasNext(){
                return count < size;
            }

            @Override
            public E next(){
                if (!hasNext()) throw new NoSuchElementException();
                E elem = getElement(currentIndex);
                currentIndex = (currentIndex + 1)% array.length;
                count++;
                return elem;
            }
        };

    }
     private E getElement(int index){
        return (E) array[index];
     }


    // Метод для сравнения очередей
    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    MyQueue<?> otherQueue = (MyQueue<?>) obj;
    if (this.size != otherQueue.size) return false;
    for (int i = 0; i < size; i++) {
        if (!array[(head + i) % array.length].equals(otherQueue.array[(otherQueue.head + i) % otherQueue.array.length])) {
            return false;
        }
    }
    return true;
}
}
