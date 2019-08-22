package spittr.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * 参数化测试：
 * 1. 用@RunWith(Parameterized.class)来注释test类
 * 2. 创建一个由@Parameters注释的公共的静态方法，他返回一个对象的集合（数组）来作为测试数据集合
 * 3. 创建一个公共的构造函数，他接受和一行测试数据相等同的东西
 * 4. 为每一行测试数据创建一个实例变量作为测试数据的来源来创建你的测试用例
 */
@RunWith(Parameterized.class)
public class TestPrimeNumberChecker {

    private int inputNumber;
    private boolean expectedResult;
    private PrimeNumberChecker primeNumberChecker;

    @Before
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    public TestPrimeNumberChecker(int inputNumber, boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {2, true},
                {6, false},
                {19, true},
                {22, false}
        });
    }

    @Test
    public void testPrimeNumberCheck() {
        System.out.println("Parameterized Number is : " + inputNumber);
        Assert.assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
    }
}
