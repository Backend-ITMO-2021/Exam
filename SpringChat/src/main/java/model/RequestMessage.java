package model;

public class RequestMessage {
    String message = "request contains bad parameters";

    public RequestMessage(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
