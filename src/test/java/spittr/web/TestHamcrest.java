package spittr.web;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import spittr.pojo.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHamcrest {

    @Test
    public void testMethod() {
        // 判断是否相等
        String name = "Hello";
        MatcherAssert.assertThat(name, Matchers.equalTo("Hello"));

        // 比较时忽略字符串大小写
        name = "HELLO";
        MatcherAssert.assertThat(name, Matchers.equalToIgnoringCase("hello"));

        // 去掉实际和预期字符串前后空格，中间多个空格变成一个，然后比较是否相等
        name = "   he   llo   ";
        MatcherAssert.assertThat(name, Matchers.equalToIgnoringWhiteSpace("  he  llo  "));

        // 判断是否包含某个字符串
        name = "Hello the world";
        MatcherAssert.assertThat(name, Matchers.containsString("the"));
        MatcherAssert.assertThat(name, Matchers.startsWith("Hello"));
        MatcherAssert.assertThat(name, Matchers.endsWith("world"));

        // 判断字符串是否为空或null
        String a = null;
        String b = "";
        MatcherAssert.assertThat(b, Matchers.isEmptyString());
        MatcherAssert.assertThat(a, Matchers.isEmptyOrNullString());

        // hamcrest将原子值封装成对象(int -> Integer),然后调用对象的equals方法
        double price = 11.23;
        MatcherAssert.assertThat(price, Matchers.equalTo(11.23));

        // 比较大小时将数值封装成对象，然后调用对象的compareTo方法
        MatcherAssert.assertThat(price, Matchers.greaterThan(10.01));
        MatcherAssert.assertThat(price, Matchers.lessThan(13.22));
        MatcherAssert.assertThat(price, Matchers.greaterThanOrEqualTo(10.01));
        MatcherAssert.assertThat(price, Matchers.lessThanOrEqualTo(13.22));

        // 布尔值比较
        boolean isLocked = true;
        MatcherAssert.assertThat(isLocked, Matchers.equalTo(true));

        // 比较是否是同一个对象
        String person1 = new String("Monday");
        String person2 = person1;
        MatcherAssert.assertThat(person1, Matchers.sameInstance(person2));

        // 判断是否是某个类的实例
        String str = "hello";
        MatcherAssert.assertThat(str, Matchers.instanceOf(String.class));

        // 判断一个对象是否为null
        Object obj = null;
        MatcherAssert.assertThat(obj, Matchers.nullValue());
        obj = new Object();
        MatcherAssert.assertThat(obj, Matchers.notNullValue());

        // 当两个数组长度相等，且按顺序每个元素相同时，他们相等
        Integer[] nums = {1, 2, 3};
        MatcherAssert.assertThat(nums, Matchers.arrayContaining(1, 2, 3));

        // 判断数组大小
        MatcherAssert.assertThat(nums, Matchers.arrayWithSize(3));

        // 两数组，长度相同，不考虑顺序，它们包含相同的元素，则断言为true
        MatcherAssert.assertThat(nums, Matchers.arrayContainingInAnyOrder(2, 1, 3));

        // hasEntry判断是否包含某个<key,value>, hasKey判断是否包含某个key，hasValue判断是否包含某个value
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        MatcherAssert.assertThat(map, Matchers.hasEntry("key", "value"));
        MatcherAssert.assertThat(map, Matchers.hasKey("key"));
        MatcherAssert.assertThat(map, Matchers.hasValue("value"));

        List<Integer> list = Arrays.asList(1, 2, 3);
        // 判断集合的大小
        MatcherAssert.assertThat(list, Matchers.hasSize(3));
        // 判断是否包含一个或多个元素
        MatcherAssert.assertThat(list, Matchers.hasItem(2));
        MatcherAssert.assertThat(list, Matchers.hasItems(3, 2));

        List<String> strs = Arrays.asList("Alex", "alzhang");
        MatcherAssert.assertThat(strs, Matchers.hasItem(Matchers.anyOf(Matchers.equalTo("Alex"), Matchers.equalTo("alzhang"))));
        MatcherAssert.assertThat(strs, Matchers.hasItem(Matchers.allOf(Matchers.startsWith("a"), Matchers.endsWith("g"))));

        // 两个list的size相同，并且按顺序，每个元素相等
        MatcherAssert.assertThat(list, Matchers.contains(1, 2, 3));

        // 两个list的size相同，并且按顺序，每个元素相等
        MatcherAssert.assertThat(list, Matchers.containsInAnyOrder(1, 2, 3));

        // 对集合的每个元素，进行match，只有都match了，断言才为true
        MatcherAssert.assertThat(list, Matchers.everyItem(Matchers.greaterThan(0)));

        Person person = new Person("abcd");
        // 判断Bean是否有某个类变量，该变量至少有一个get方法或set方法，否则Hamcrest不认为其是个property
        MatcherAssert.assertThat(person, Matchers.hasProperty("name"));
        MatcherAssert.assertThat(person, Matchers.hasProperty("name", Matchers.equalTo("abcd")));

        Person p1 = new Person("abcd");
        // 判断两个bean是否有相同的property，并且它们的value值也相等
        MatcherAssert.assertThat(person, Matchers.samePropertyValuesAs(p1));

        // 对一个元素的判断，需要同时成立
        int width = 13;
        MatcherAssert.assertThat(width, Matchers.allOf(Matchers.greaterThan(10), Matchers.lessThanOrEqualTo(13)));

        // 对一个元素的判断，只要有一个成立
        MatcherAssert.assertThat(width, Matchers.anyOf(Matchers.greaterThan(0), Matchers.greaterThan(100)));

        // 对一个判断取反
        MatcherAssert.assertThat(list, Matchers.not(Matchers.hasItem(5)));
    }
}
