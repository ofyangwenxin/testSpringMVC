package spittr.pojo;

public class MessageDemo {

    private String message;

    public MessageDemo(String message) {
        this.message = message;
    }

    public String printMessage() {
        System.out.println(this.message);
        return message;
    }
}
