package lab_1;

public class Variables {
    public static void printVariables(){
        String myStr;
        int myInt;
        float myFloat;

        myStr= "Hello world";
        myInt = 10;
        myFloat= 34.5f;

        System.out.format("myStr: %s\n", myStr);
        System.out.format("myInt: %s\n", myInt);
        System.out.format("myFloat: %s\n", myFloat);
    }
}
