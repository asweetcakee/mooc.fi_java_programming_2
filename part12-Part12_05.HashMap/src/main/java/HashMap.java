
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mefferio
 */
public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int index;

    public HashMap() {
        this.values = new List[32];
        this.index = 0;
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);

        if (this.values[hashValue] == null) {
            return null;
        }

        List<Pair<K, V>> valuesAtIndex = this.values[hashValue];

        return valuesAtIndex.stream()
                .filter(pair -> pair.getKey().equals(key))
                .map(Pair::getValue)
                .findFirst()
                .orElse(null);
    }

    public void add(K key, V value) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int findAtIndex = getIndexOfKey(valuesAtIndex, key);

        if (findAtIndex < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.index++;
        } else {
            valuesAtIndex.get(findAtIndex).setValue(value);
        }
        
        if (1.0 * this.index / this.values.length > 0.75){
            grow();
        }
    }

    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new ArrayList<>();
        }
        return this.values[hashValue];
    }

    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
        return IntStream.range(0, myList.size())
                .filter(i -> myList.get(i).getKey().equals(key))
                .findFirst()
                .orElse(-1);
    }

    private void grow() {
        List<Pair<K, V>>[] newValues = new List[this.values.length * 2];
        
        for (int i = 0; i < this.values.length; i++){
            copy(newValues, i);
        }
        
        this.values = newValues;
    }
    
    private void copy(List<Pair<K, V>>[] newArray, int fromIdx) {
        for (int i = 0; i < this.values[fromIdx].size(); i++){
            Pair<K, V> pair = this.values[fromIdx].get(i);            
            int hashValue = Math.abs(pair.getKey().hashCode() % newArray.length);
            
            if (newArray[hashValue] == null){
                newArray[hashValue] = new ArrayList<>();
            }
            
            newArray[hashValue].add(pair);
        }
    }
    
    public V remove(K key){
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int foundAtIndex = getIndexOfKey(valuesAtIndex, key);
        
        if (foundAtIndex < 0){
            return null;
        }
        
        Pair<K, V> pair = valuesAtIndex.get(foundAtIndex);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }
    
    public int size(){
        return this.index;
    }
    
    public void print(){
        for (List<Pair<K, V>> list : this.values) {
            if (list == null){
                continue;
            }
            for (int j = 0; j < list.size(); j++){
                System.out.println(list.get(j).getKey() + " " + list.get(j).getValue());
            }
        }
    }
}
