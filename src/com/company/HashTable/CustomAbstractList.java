//package com.company.HashTable;
//
//import java.util.*;
//import java.util.function.Consumer;
//
//public abstract class CustomAbstractList<E> {
//
//    protected  int modeCount =0;
//
//    public boolean add(E e){
//        add(size(), e);
//        return true;
//    }
//
//
//    public void add(int index, E element){
//        throw  new UnsupportedOperationException("Add Operation not supported");
//    }
//
//    public E remove(int index){
//        throw new UnsupportedOperationException("Remove not supported");
//    }
//
//    public boolean remove(Object o){
//        for(Iterator<E> it = iterator();it.hasNext();){
//            if(Objects.equals(o,it.hasNext())){
//                it.remove();
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public E get(int index){
//        throw new UnsupportedOperationException("GET Operation not supported");
//    }
//
//    public E set(int index, E element){
//        throw new UnsupportedOperationException("Set not permitted");
//    }
//
//    public boolean isEmpty(){
//        return size() ==0;
//    }
//
//    public boolean contains(Object o){
//        return indexOf(o) >=0;
//    }
//
//
//    public int indexOf(Object o){
//        Iterator<E> it = iterator();
//        int index =0;
//        while (it.hasNext()){
//            if(Objects.equals(o,it.hasNext())){
//                return index;
//            }
//        }
//        return -1;
//    }
//
//    public int lastIndexOf(Object o){
//        ListIterator<E> it = listIterator(size());
//        while (it.hasNext()){
//            if(Objects.equals(o, it.previous())){
//                return it.nextIndex();
//            }
//        }
//        return -1;
//    }
//    public Object[] toArray(){
//        Object[] array = new Object[size()];
//        int i=0;
//
//        for(E e : this){
//            array[i++] =e;
//        }
//        return array;
//    }
//
//    public <T> T[] toArray(T[] a) {
//        int size = size();
//        if (a.length < size) {
//            return (T[]) Arrays.copyOf(toArray(), size, a.getClass());
//        }
//    System.arraycopy(toArray(),0,a,0,size);
//    if(a.length > size){
//        a[size] = null;
//    }
//    return a;
//    }
//    private Iterator<E> iterator() {
//        return new CustomIterator();
//    }
//    public ListIterator<E> listIterator(int index){
//        throw new UnsupportedOperationException("List Iterator not supported");
//    }
//
//    public void clear() {
//        throw new UnsupportedOperationException("Clear operation is not supported");
//    }
//
//    // Add all elements from a collection
//    public boolean addAll(Collection<? extends E> c) {
//        return addAll(size(), c);
//    }
//
//    public boolean addAll(int index, Collection<? extends E> c) {
//        boolean modified = false;
//        for (E e : c) {
//            add(index++, e);
//            modified = true;
//        }
//        return modified;
//    }
//
//
//    public boolean retainAll(Collection<?> c) {
//        boolean modified = false;
//        for (Iterator<E> it = iterator(); it.hasNext(); ) {
//            if (!c.contains(it.next())) {
//                it.remove();
//                modified = true;
//            }
//        }
//        return modified;
//    }
//
//    // Remove all elements that are in a collection
//    public boolean removeAll(Collection<?> c) {
//        boolean modified = false;
//        for (Iterator<E> it = iterator(); it.hasNext(); ) {
//            if (c.contains(it.next())) {
//                it.remove();
//                modified = true;
//            }
//        }
//        return modified;
//    }
//
//    // Check if the list contains all elements in a collection
//    public boolean containsAll(Collection<?> c) {
//        for (Object o : c) {
//            if (!contains(o)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//    public ListIterator<E> listIterator(){
//        return listIterator(0);
//    }
//
//    private class CustomIterator implements Iterator<E>{
//
//        int cursor = 0;
//
//        int lastRet = -1;
//        int expectedModeCount = modeCount;
//
//
//        @Override
//        public boolean hasNext() {
//            return cursor < size();
//        }
//
//        @Override
//        public E next() {
//            checkForComodification();
//            int i = cursor;
//
//            if(i >= size()){
//                throw new NoSuchElementException();
//            }
//            cursor = i+1;
//            return get(lastRet = i);
//        }
//
//
//
//
//        private void checkForComodification() {
//        if(modeCount != expectedModeCount){
//            throw new ConcurrentModificationException();
//        }
//        }
//
//        @Override
//        public void remove() {
//            if (lastRet < 0) {
//                throw new IllegalStateException();
//            }
//            checkForComodification();
//            try {
//                CustomAbstractList.this.remove(lastRet);
//                cursor = lastRet;
//                lastRet = -1;
//                expectedModeCount = modeCount;
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//
//        }
//
//
//    }
//
//
//    public abstract int size();
//}


package com.company.HashTable;

import java.util.*;

public abstract class CustomAbstractList<E> implements Iterable<E> {

    protected int modeCount = 0;

    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    public void add(int index, E element) {
        throw new UnsupportedOperationException("Add operation not supported");
    }

    public E remove(int index) {
        throw new UnsupportedOperationException("Remove not supported");
    }

    public boolean remove(Object o) {
        for (Iterator<E> it = iterator(); it.hasNext(); ) {
            if (Objects.equals(o, it.next())) { // Fixed: Replaced it.hasNext() with it.next()
                it.remove();
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        throw new UnsupportedOperationException("GET operation not supported");
    }

    public E set(int index, E element) {
        throw new UnsupportedOperationException("Set not permitted");
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        Iterator<E> it = iterator();
        int index = 0;
        while (it.hasNext()) {
            if (Objects.equals(o, it.next())) { // Fixed: Replaced it.hasNext() with it.next()
                return index;
            }
            index++;
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size()];
        int i = 0;

        for (E e : this) { // Requires the class to implement Iterable<E>
            array[i++] = e;
        }
        return array;
    }

    public <T> T[] toArray(T[] a) {
        int size = size();
        if (a.length < size) {
            return (T[]) Arrays.copyOf(toArray(), size, a.getClass());
        }
        System.arraycopy(toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public Iterator<E> iterator() { // Changed visibility to public
        return new CustomIterator();
    }

    public void clear() {
        throw new UnsupportedOperationException("Clear operation is not supported");
    }

    public boolean addAll(Collection<? extends E> c) {
        return addAll(size(), c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            add(index++, e);
            modified = true;
        }
        return modified;
    }

    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (Iterator<E> it = iterator(); it.hasNext(); ) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Iterator<E> it = iterator(); it.hasNext(); ) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    private class CustomIterator implements Iterator<E> {

        int cursor = 0;
        int lastRet = -1;
        int expectedModeCount = modeCount;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public E next() {
            checkForComodification();
            int i = cursor;

            if (i >= size()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return get(lastRet = i);
        }

        private void checkForComodification() {
            if (modeCount != expectedModeCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                CustomAbstractList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModeCount = modeCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public abstract int size();
}
