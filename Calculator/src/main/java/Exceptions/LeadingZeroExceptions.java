package Exceptions;

public class LeadingZeroExceptions extends Exception{
    String message = "The number has leading zero.";
    public LeadingZeroExceptions(){
        super("The number has leading zero.");
    }
}
