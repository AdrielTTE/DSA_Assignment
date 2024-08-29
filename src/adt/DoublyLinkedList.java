
package adt;

import java.util.Comparator;

public class DoublyLinkedList<T extends Comparable<T>> implements SortedListInterface<T> {

    private Node head;
    private Node tail;
    private int numOfEntries=0;
    
    //Jacquelin's functions
    @Override
    public boolean filter(Comparable data) {
         Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;

    }

    @Override
    public boolean replace(Comparable oldData, Comparable newData) {
         Node current = head;
        while (current != null) {
            if (current.data.equals(oldData)) {
                current.data = (T) newData;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
   
    //Adriel's part
    @Override
    public T getEntry(Integer givenPosition) {
        int halfNumOfEntries = getNumOfEntries()/2;
        int count;
        if(givenPosition > 0 && givenPosition < halfNumOfEntries){
            count=1;
            Node currentNode = head;
            while (count < givenPosition){
                count++;
                currentNode = currentNode.next;
            }
            
            return currentNode.data;
            
        }
        
        else if (givenPosition > 0 && givenPosition > halfNumOfEntries){
            count = getNumOfEntries();
            Node currentNode = tail;  
            while (count < givenPosition){
                count--;
                currentNode = currentNode.previous;
            }
            
            return (T)currentNode;
    }
    else{
            System.out.println("Error: Given position is invalid!");
            return null;
        }
    }
    
    @Override
    public boolean sort(Comparator comparator) {
        if (head == null || head.next == null) 
            return true;

        boolean swapped;
        do {
            swapped = false;
            Node currentNode = head;
            while (currentNode.next != null) {
                Node nextNode = currentNode.next;
                if (comparator.compare(currentNode.data, nextNode.data) > 0) {
                    // Swap the data between currentNode and nextNode
                    T tempData = currentNode.data;
                    currentNode.data = nextNode.data;
                    nextNode.data = tempData;
                    swapped = true;
                }
                currentNode = nextNode;
            }
        } while (swapped);

        return true;
    }
    

    //Qi Yao's part
    
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            // If the list is empty, make the new node the head and tail of the list
            head = newNode;
            tail = newNode;
        } else {
            Node nodeBefore = null;
            Node currentNode = head;

            while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
                nodeBefore = currentNode;
                currentNode = currentNode.next;
            }

            if (nodeBefore == null) {
                // Insert at the beginning of the list
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            } else if (currentNode == null) {
                // Insert at the end of the list
                nodeBefore.next = newNode;
                newNode.previous = nodeBefore;
                tail = newNode;
            } else {
                // Insert in the middle of the list
                newNode.next = currentNode;
                newNode.previous = nodeBefore;
                nodeBefore.next = newNode;
                currentNode.previous = newNode;
            }
        }

        numOfEntries++;
        return true;
    }

    //Cher Wei's Part
    @Override
    public boolean remove(T anEntry) {
        if(head == null){    //isEmpty
            return false;
        }else{
            Node beforeNode = null;
            Node currentNode = head;
            while (currentNode !=null && currentNode.data.compareTo(anEntry)< 0){
                beforeNode = currentNode;
                currentNode = currentNode.next;
            }// while
        if(currentNode != null && currentNode.data.equals(anEntry)){  //comapareTo(anEntry) ==0
        if(currentNode == head){    
            head = head.next;          
        }else{
            beforeNode.next = currentNode.next;
        }
        numOfEntries--;
        return true;
        }
        }
        return false;

    }
    
    //Amanda's Part
    @Override
    public boolean isEmpty() {
         return head == null;
        
    }
    
    @Override
    public void clear() {
         while (head != null) {
            Node temp = head;
            head = head.next;
            // Help the garbage collector by nullifying references
            if (head != null) {
                head.previous = null;
            }
            temp.next = null;
            temp.previous = null;
        }
        tail = null; // Reset the tail as well
    }

   

    @Override
    public Integer getNumOfEntries() {
         return numOfEntries;

    }
    
    @Override
    public String toString() {
    StringBuilder result = new StringBuilder();
    Node current = head;

    while (current != null) {
        result.append(current.data);
        if (current.next != null) {
            result.append("\n\n");
        }
        current = current.next;
    }

    return result.toString();
}
    
    
  
   
private Node findMiddle(Node start, Node end) {
        Node slow = start;
        Node fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Override
    public T search(T value) {
        Node entry = binarySearch(value);
        return (entry != null) ? entry.data : null;
    }

    private Node binarySearch(T value) {
        Node start = head;
        Node end = null;

        while (start != end) {
            Node middle = findMiddle(start, end);  // Updated findMiddle method to take start and end

            if (middle == null) {
                return null;
            }

            int comparison = middle.data.compareTo(value);

            if (comparison == 0) {
                return middle;
            } else if (comparison < 0) {
                start = middle.next;
            } else {
                end = middle;
            }
        }

        return null;
}

    
    private class Node {
    
    //To add getDataprivate class Node {

    private T data;
    private Node next;
    private Node previous;

    private Node(T data) {
      this.data = data;
      next = null;
      previous = null;
    }

    private Node(T data, Node next, Node previous) {
      this.data = data;
      this.next = next;
      this.previous = previous;
    }
    
  
  }
    
}



