package spittr.junit;

import org.junit.Assert;
import org.junit.Test;
import spittr.pojo.MessageDemo;

public class TestMessageDemo {
    private String message = "HelloWorld";
    private MessageDemo messageDemo = new MessageDemo(this.message);

    @Test
    public void testPrintMessage() {
        Assert.assertEquals(message, messageDemo.printMessage());
    }
}
