package main.myExceptions;

public class Notfound extends RuntimeException {
    public Notfound(String message) {
        super(message);
    }
}
