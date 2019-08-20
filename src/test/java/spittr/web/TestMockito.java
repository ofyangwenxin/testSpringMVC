package spittr.web;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.*;

public class TestMockito {

    /**
     * 创建Mock对象
     */
    @Test
    public void createMockObject() {
        List mockedList = Mockito.mock(List.class);
        Assert.assertTrue(mockedList instanceof List);

        ArrayList mockedArrayList = Mockito.mock(ArrayList.class);
        Assert.assertTrue(mockedArrayList instanceof List);
        Assert.assertTrue(mockedArrayList instanceof ArrayList);
    }

    /**
     * 配置Mock对象
     */
    @Test
    public void configMockObject() {
        List mockedList = Mockito.mock(List.class);
        Mockito.when(mockedList.add("one")).thenReturn(true);
        Mockito.when(mockedList.size()).thenReturn(1);

        Assert.assertTrue(mockedList.add("one"));
        Assert.assertFalse(mockedList.add("two"));
        Assert.assertEquals(mockedList.size(), 1);

        Iterator i = Mockito.mock(Iterator.class);
        Mockito.when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");
        String result = i.next() + " " + i.next();
        Assert.assertEquals("Hello, Mockito!", result);
    }

    @Test(expected = NoSuchElementException.class)
    public void testForIOException() throws Exception {
        Iterator i = Mockito.mock(Iterator.class);
        Mockito.when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");
        String result = i.next() + " " + i.next();
        Assert.assertEquals("Hello, Mockito!", result);

        Mockito.doThrow(new NoSuchElementException()).when(i).next();
        i.next();
    }

    /**
     * 校验Mock对象的方法调用
     */
    @Test
    public void testVerify() {
        List mockedList = Mockito.mock(List.class);
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        Mockito.when(mockedList.size()).thenReturn(3);
        Assert.assertEquals(mockedList.size(), 3);

        Mockito.verify(mockedList, Mockito.atLeastOnce()).add("one");
        Mockito.verify(mockedList, Mockito.times(1)).add("two");
        Mockito.verify(mockedList, Mockito.times(3)).add("three times");
        Mockito.verify(mockedList, Mockito.never()).isEmpty();
    }

    /**
     * 使用spy()部分模拟对象
     */
    @Test
    public void testSpy() {
        List list = new LinkedList();
        List spy = Mockito.spy(list);
        Mockito.when(spy.size()).thenReturn(100);
        spy.add("one");
        spy.add("two");
        Assert.assertEquals(spy.get(0), "one");
        Assert.assertEquals(spy.get(1), "two");
        System.out.println(list.size());
        Assert.assertEquals(spy.size(), 100);
    }

    /**
     * 参数捕获
     */
    @Test
    public void testCaptureArgument() {
        List<String> list = Arrays.asList("1", "2");
        List mockedList = Mockito.mock(List.class);
        ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
        mockedList.addAll(list);
//        Mockito.verify(mockedList).addAll(argument.capture());
        Assert.assertEquals(2, argument.getValue().size());
        Assert.assertEquals(list, argument.getValue());
    }
}
