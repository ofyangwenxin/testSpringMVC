package spittr.junit;

import org.junit.Assert;
import org.junit.Test;
import spittr.pojo.MessageDemo;

public class TestMessageDemo2 {
    private String message = "Robert";
    private MessageDemo messageDemo = new MessageDemo(this.message);

    @Test
    public void testPrintMessage() {
//        message = "Hi";
        Assert.assertEquals(message, messageDemo.printMessage());
    }
}
