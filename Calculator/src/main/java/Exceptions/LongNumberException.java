package Exceptions;


public class LongNumberException extends Exception {
    String message = "Number is too long.";
    public LongNumberException(){
        super("Number is too long.");
    }
}
