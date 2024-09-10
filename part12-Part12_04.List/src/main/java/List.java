/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class List<T> {

    private T[] values;
    private int indexQuantity;

    public List() {
        this.values = (T[]) new Object[10];
        this.indexQuantity = 0;
    }

    public void add(T value) {
        // It's better to use different approach of adding 
        // and removing values from the list
        // look for using List as a Queue Implementation
        // Current add state is O(1)
        // Current remove state is O(n)
        // By using Queue Implementation it can become O(1) as well
        if (this.values.length == this.indexQuantity) {
            grow();
        }
        
        this.values[this.indexQuantity] = value;
        this.indexQuantity++;
    }

    private void grow() {
        int newSize = this.values.length + this.values.length / 2;
        T[] newValues = (T[]) new Object[newSize];

        for (int i = 0; i < this.indexQuantity; i++) {
            newValues[i] = this.values[i];
        }

        this.values = newValues;
    }

    public boolean contains(T value) {
        return indexOfValue(value) >= 0;
    }

    public void remove(T value) {
        // It's better to use different approach of adding 
        // and removing values from the list
        // look for using List as a Queue Implementation
        // Current add state is O(1)
        // Current remove state is O(n)
        // By using Queue Implementation it can become O(1) as well
        int indexToRemove = indexOfValue(value);

        if (indexToRemove < 0) {
            return;
        }

        moveToTheLeft(indexToRemove);
        this.indexQuantity--;
    }

    public int indexOfValue(T value) {
        for (int i = 0; i < this.indexQuantity; i++) {
            if (this.values[i] == value || this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.indexQuantity; i++) {
            this.values[i] = this.values[i + 1];
            this.values[i + 1] = null;
        }
    }

    public T value(int index) {
        if (index < 0 || index > this.indexQuantity) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of [0, " + this.indexQuantity + "]");
        }
        
        return this.values[index];
    }
    
    public int size(){
        return this.indexQuantity;
    }
}
