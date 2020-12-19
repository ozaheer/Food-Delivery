//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Food Delivery Lab
// Files: Student.java, Delivery.java, DeliveryQueue.java, DeliveryQueueTester.java
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
public class FoodRobot {
  private int x;
  private int y;
  private String name;
  
  public FoodRobot(int x, int y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  public String getName() { 
    return name;
  }
  
  public String toString() {
    String returnString = ("" + name + "(" + x + ", " + y + ")");
    return returnString;
  }
}
