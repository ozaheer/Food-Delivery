//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Food Delivery Lab
// Files: FoodRobot.java, Student.java, DeliveryQueue.java, DeliveryQueueTester.java
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
public class Delivery implements Comparable<Delivery> {
  private int studentId;
  private String robotName;
  private int distance;

  public Delivery(Student student, FoodRobot foodRobot) {
    distance =
        Math.abs(student.getX() - foodRobot.getX()) + Math.abs(student.getY() - foodRobot.getY());
    robotName = foodRobot.getName();
    studentId = student.getID();
  }

  public int compareTo(Delivery otherDelivery) {
    if (this.distance < otherDelivery.distance) {
      return -1;
    } else if (this.distance > otherDelivery.distance) {
      return 1;
    } else {
      if (this.studentId < otherDelivery.studentId) {
        return -1;
      } else if (this.studentId > otherDelivery.studentId) {
        return 1;
      } else {
        if ((this.robotName.compareTo(otherDelivery.robotName)) < 0) {
          return -1;
        } else {
          return 1;
        }
      }
    }
  }
  
  public boolean equals(Object otherObject) {
    if (otherObject instanceof Delivery) {
      if (((Delivery) otherObject).studentId == this.studentId) {
        return true;
      }
      if (((Delivery) otherObject).robotName.equals(this.robotName)) {
        return true;
      }
      return false;
    }
    if (otherObject instanceof Student) {
      if (((Student) otherObject).getID() == this.studentId) {
        return true;
      } else {
        return false;
      }
    }
    if (otherObject instanceof FoodRobot) {
      if (((FoodRobot) otherObject).getName().equals(this.robotName)) {
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

  public String toString() {
    return "The distance between " + studentId + " and " + robotName +
    " is " + distance;
   }
  
}
