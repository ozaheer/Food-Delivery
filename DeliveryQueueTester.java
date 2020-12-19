
public class DeliveryQueueTester {
  public static boolean testCompareTo() {
    Student Oneeb = new Student(2, 2, 10);
    FoodRobot Squire = new FoodRobot(3, 3, "cowabunga");
    Delivery d = new Delivery(Oneeb, Squire);

    Student Oneeb2 = new Student(2, 2, 10);
    FoodRobot Squire2 = new FoodRobot(3, 3, "sodomite");
    Delivery d2 = new Delivery(Oneeb2, Squire2);

    System.out.println(d.compareTo(d2));
    return true;
  }
  
  
  public static boolean testOfferDelivery2() {
    DeliveryQueue testQueue = new DeliveryQueue();
    Student Ahmed = new Student(1, 1, 2);
    Student Sameer = new Student(2, 2, 2);
    Student Khadija = new Student(3, 3, 6);
    Student Omer = new Student(4, 4, 8);
    
    Student Ahmed2 = new Student(5, 5, 4);
    Student Sameer2 = new Student(6, 6, 7);
    Student Khadija2 = new Student(7, 7, 9);
    Student Omer2 = new Student(8, 8, 11);
    
    FoodRobot xx = new FoodRobot(2, 2, "F");
    FoodRobot yy = new FoodRobot(4, 4, "G");
    FoodRobot zz = new FoodRobot(6, 6, "H");
    FoodRobot aa = new FoodRobot (8, 8, "I");
    
    FoodRobot bb = new FoodRobot(10, 10, "G");
    FoodRobot cc = new FoodRobot(12, 12, "Z");
    FoodRobot dd = new FoodRobot(14, 14, "H");
    FoodRobot ee = new FoodRobot(16, 16, "I");
    
    testQueue.offerDelivery(new Delivery(Omer, aa));
    testQueue.offerDelivery(new Delivery(Ahmed, xx));
    testQueue.offerDelivery(new Delivery(Khadija, zz));    
    testQueue.offerDelivery(new Delivery(Sameer, yy));
    
    testQueue.offerDelivery(new Delivery(Khadija2, bb));
    testQueue.offerDelivery(new Delivery(Omer2, dd));
    testQueue.offerDelivery(new Delivery(Ahmed2, ee));
    testQueue.offerDelivery(new Delivery(Sameer2, cc));
    
    System.out.println(testQueue.toString());
    System.out.println("");
    System.out.println(testQueue.pollBestDelivery());
    System.out.println("");
    System.out.println(testQueue.toString());
    System.out.println(testQueue.pollBestDelivery());
    System.out.println("");
    System.out.println(testQueue.toString());
    System.out.println(testQueue.pollBestDelivery());
    System.out.println("");
    System.out.println(testQueue.toString());
   
    return true;
  }
  
  public static boolean testEquals() {
    Student tester = new Student(5, 10, 1);
    Student tester2 = new Student(4, 8, 2);
    
    FoodRobot a = new FoodRobot(3, 3, "abercrombie");
    FoodRobot b = new FoodRobot (5, 4, "abercrombie");
    
    Delivery test = new Delivery (tester, a);
    Delivery test2 = new Delivery (tester2, b);
    
    System.out.println(test.equals(test2));
    return true;
  }

  public static boolean testOfferDelivery() {
    // create a new DeliveryQueue
    DeliveryQueue minHeap = new DeliveryQueue();
    // create some Student and FoodRobot objects
    Student one = new Student(1, 1, 1);
    Student two = new Student(3, 2, 2);
    FoodRobot a = new FoodRobot(2, 3, "A");
    FoodRobot b = new FoodRobot(5, 4, "B");
    // create some Delivery objects and add them to the DeliveryQueue
    minHeap.offerDelivery(new Delivery(one, a));
    minHeap.offerDelivery(new Delivery(one, b));
    minHeap.offerDelivery(new Delivery(two, a));
    minHeap.offerDelivery(new Delivery(two, b));

    // check if the size is correct (2 students * 2 foodRobots = 4 deliveries)
    if (minHeap.getSize() != 4) {
      System.out.println("size is incorrect");
      return false;
    }
    // check first (highest priority delivery to be returned)
    String bestDelivery = minHeap.pollBestDelivery().toString();
    if (!bestDelivery.equals("The distance between 2 and A is 2")) {
      System.out.println("pollbestdelivery is not working");
      return false;
    }
    // check if the size is correct (only delivery w/student 1 + robot B left)
    if (minHeap.getSize() != 1) {
      System.out.println("size not decremented correctly?");
      return false;
    }
    // check last (lowest priority delivery to be returned)
    String worstDelivery = minHeap.peek().toString();
    if (!worstDelivery.equals("The distance between 1 and B is 7"))
      return false;

    // only return true after all previous tests pass
    return true;
  }

  public static void main(String[] args) {
    // testCompareTo();
    //System.out.println(testOfferDelivery());
    testOfferDelivery2();
    //testEquals();
  }
}
