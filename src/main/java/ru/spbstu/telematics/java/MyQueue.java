package ru.spbstu.telematics.java;
import.util*

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
    public boolean add(E elem){
    if (elem == null) throw new NullPointerException("Элемент не может быть null");
    if (size == array.length) resize();
    array[tail] = elem;
    tail = (tail + 1) % array.length;
    size++;
    return true;
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchFieldException("Queue is empty");
        }
        E elem = (E) array[head];
        array[head] = null;
        head = (head+1) %array.length;
        size--;
        return elem;
    }
}
