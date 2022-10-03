package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    private int kittensCount;
    private int expected;

    public FelineParameterizedTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getKittensCount() {
        return new Object[][]{
                {1, 1},
                {9, 9},
                {100, 100}
        };

    }
    @Test
    public void getKittensMethodWithSignatureTest() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(kittensCount));
    }
}
