//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Food Delivery Lab
// Files: FoodRobot.java, Delivery.java, Student.java, DeliveryQueueTester.java
// Course: CS300 Spring 2020
//
// Author: Oneeb Zaheer
// Email: ozaheer@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: 
// Partner Email: 
// Partner Lecturer's Name: 
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understood the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

public class DeliveryQueue {
  private static final int INITIAL_CAPACITY = 20;
  private Delivery[] heap;
  private int size;

  public DeliveryQueue() {
    heap = new Delivery[INITIAL_CAPACITY];
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    if (size > 0) {
      return false;
    } else {
      return true;
    }
  }

  public void offerDelivery(Delivery deliveryToAdd) {
    try {
      Delivery testDelivery = heap[size];
    } catch (ArrayIndexOutOfBoundsException e) {
      Delivery[] newHeap = new Delivery[size + size];
      for (int i = 0; i < heap.length; i++) {
        newHeap[i] = heap[i];
      }
      heap = newHeap;
    } finally {
      heap[size] = deliveryToAdd;
      percolateUp(size);
      size++;
    }
  }

  public Delivery pollBestDelivery() throws NoSuchElementException {
    if (!isEmpty()) {
      Delivery toReturn = heap[0];
      int nullReferences = 0;
      int nonNullValues = 0;
      for (int i = 0; i < size; i++) { // possible point of bugs
        if (toReturn.equals(heap[i])) {
          heap[i] = null;
          nullReferences++;
        }
      }
      for (int i = 0; i < size; i++) {
        if (heap[i] != null) {
          heap[nonNullValues] = heap[i];
          nonNullValues++;
        }
      }
      while (nonNullValues < size) {
        heap[nonNullValues] = null;
        nonNullValues++;
      }
      for (int i = 0; i < nullReferences; i++) {
        size--;
      }
      heapify();
      return toReturn;
    } else {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
  }

  public Delivery peek() throws NoSuchElementException {
    if (!isEmpty()) {
      return heap[0];
    } else {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
  }

  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string;
  }

  private void percolateUp(int currentIndex) {
    int parentIndex = getParentIndex(currentIndex);
    if (heap[currentIndex].compareTo(heap[parentIndex]) == -1) {
      swap(currentIndex, parentIndex);
      percolateUp(parentIndex);
    } else {
      return;
    }
  }

  private void percolateDown(int currentIndex) {
    int leftChildIndex = getLeftChildIndex(currentIndex);
    int rightChildIndex = getRightChildIndex(currentIndex);
    if (hasRightChild(currentIndex)) {
      if (heap[currentIndex].compareTo(heap[rightChildIndex]) == 1) {
        if (heap[rightChildIndex].compareTo(heap[leftChildIndex]) == -1) {
          swap(currentIndex, rightChildIndex);
          percolateDown(rightChildIndex);
        } else {
          swap(currentIndex, leftChildIndex);
          percolateDown(leftChildIndex);
        }
      }
    } else if (hasLeftChild(currentIndex)) {
      if (heap[currentIndex].compareTo(heap[leftChildIndex]) == 1) {
        swap(currentIndex, leftChildIndex);
        percolateDown(leftChildIndex);
      }
    } else {
      return;
    }
  }


  private int getParentIndex(int childIndex) {
    int parentIndex = (int) Math.floor((childIndex - 1) / 2);
    return parentIndex;
  }

  private int getLeftChildIndex(int parentIndex) {
    int leftChildIndex = (2 * parentIndex + 1);
    return leftChildIndex;
  }

  private int getRightChildIndex(int parentIndex) {
    int rightChildIndex = (2 * parentIndex + 2);
    return rightChildIndex;
  }

  private void swap(int index1, int index2) {
    Delivery holdDelivery2 = heap[index2];
    heap[index2] = heap[index1];
    heap[index1] = holdDelivery2;
  }

  private boolean hasLeftChild(int currentIndex) {
    try {
      heap[getLeftChildIndex(currentIndex)].toString();
      return true;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    } catch (NullPointerException e) {
      return false;
    }
  }

  private boolean hasRightChild(int currentIndex) {
    try {
      heap[getRightChildIndex(currentIndex)].toString();
      return true;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    } catch (NullPointerException e) {
      return false;
    }

  }

  public void heapify() {

    for (int i = size; i >= 0; i--) {
      if (hasLeftChild(i)) {
        percolateDown(i);
      } else {
        continue;
      }

    }
  }

}
