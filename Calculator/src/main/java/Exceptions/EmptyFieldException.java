package Exceptions;


public class EmptyFieldException extends Exception {
    String message = "Number field is empty.";
    public EmptyFieldException(){
        super("Number field is empty.");

    }
}
