package project10;

public class part1 {
    public static void main(String[] args) {

        // Step 1: Create an object of our custom class with an initial property value
        DemoItem originalObj = new DemoItem("Initial Text");

        // Step 2: Assign the reference of this object to two different variables (refVar1 and refVar2)
        // Note: We are not copying the object itself, only copying the memory address reference.
        DemoItem refVar1 = originalObj;
        DemoItem refVar2 = originalObj;

        // Step 3: Use the second variable to change the object's property value
        refVar2.text = "Changed with second variable (refVar2)";

        // Step 4: Monitor the properties through all variables
        // and ensure that the changes influence both variables
        // as both variables are pointing to the exact same object in memory.
        System.out.println("Value checked with originalObj: " + originalObj.text);
        System.out.println("Value checked with refVar1:     " + refVar1.text);
        System.out.println("Value checked with refVar2:     " + refVar2.text);

        // Step 1: Create a new object of our class specifically for method argument testing
        DemoItem argObj = new DemoItem("Original Argument Text");

        System.out.println("Before passing to method: " + argObj.text);

        // Step 2: Pass the object into a static method as an argument
        // Note: Java passes object references by value, meaning the method receives a copy of the reference
        // pointing to the same object in memory.
        MethodHelper.modifyItem(argObj);

        // Step 3: Check the object property outside the method
        // and ensure that the change influenced the original variable.
        System.out.println("After returning from method:  " + argObj.text);
    }
}

// Helper class representing a simple object with a property
class DemoItem {
    public String text;

    // Constructor to initialize the text property when an object is created
    public DemoItem(String text) {
        this.text = text;
    }
}

// Helper class containing a method to demonstrate passing objects as arguments
class MethodHelper {
    public static void modifyItem(DemoItem item) {
        // Step 3 inside section 2: Change the object property directly using its reference parameter inside the method
        item.text = "Changed inside method via argument";
    }
}