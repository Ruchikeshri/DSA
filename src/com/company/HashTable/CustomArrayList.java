package com.company.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomArrayList<E>
extends CustomAbstractList<E>{

private static final int DEFAULT_CAPACITY = 10;
private static final Object[] EMPTY_ELEMENTDATA = {};
private Object[] elementData;
private int size;

   public CustomArrayList(){
       this.elementData = EMPTY_ELEMENTDATA;
   }
   public  CustomArrayList(int initialCapacity) {
       if (initialCapacity > 0) {
           this.elementData = new Object[initialCapacity];
       } else if (initialCapacity == 0) {
           this.elementData = EMPTY_ELEMENTDATA;
       } else {
           throw new IllegalArgumentException("Illegal Capacity "+ initialCapacity);
       }
   }

   public CustomArrayList(Collection<? extends  E> c){
       elementData = c.toArray();
       size = elementData.length;

        if(elementData.getClass() != Object[].class){
            elementData = Arrays.copyOf(elementData,size,Object[].class);
        }
   }


    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index){
       rangeCheck(index);
       return elementData(index);
    }

    private void rangeCheck(int index) {
       if(index > size || index <0){
           throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
       }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    @Override
    public void add(int index,E element){
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = element;
        size++;
        modeCount++;
    }

    @Override
    public E set(int index,E element){
       rangeCheck(index);
       E oldValue = elementData(index);
       elementData[index] = element;
       return oldValue;
    }

    @Override
    public E remove(int index){
       rangeCheck(index);
       E oldValue = elementData(index);
       int numMoved = size - index-1;
       if(numMoved > 0){
           System.arraycopy(elementData,index+1,elementData,index,numMoved);
       }
        elementData[--size] = null;
       modeCount++;
       return oldValue;
    }

    @Override
    public void clear(){
       for(int i=0;i<size;i++){
           elementData[i] = null;
       }
       size =0;
       modeCount++;
    }
    private void ensureCapacity(int minCapacity) {
        if(elementData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
        }

        if(minCapacity - elementData.length >0){
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
       int oldCapacity = elementData.length;
       int newCapacity = oldCapacity + (oldCapacity >> 1);

       if(newCapacity -minCapacity <0){
           newCapacity = minCapacity;
       }
       elementData = Arrays.copyOf(elementData,newCapacity);
   }


    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }
    }
