package adt;

import java.util.Comparator;

public interface SortedListInterface<T extends Comparable<T>>{
 
  public boolean add(T newEntry);

  public boolean remove(T anEntry);

  public boolean filter(T data);

  public void clear();
  
  public boolean replace(T oldData, T newData);

  public Integer getNumOfEntries();
  
  public T getEntry(Integer givenPosition);

  public boolean isEmpty();
  
  //To change to sortData
  public boolean sort(Comparator<T> comparator);//method refers to how the user wishes to sort the list
  
  public T search(T entry);
  

} 

