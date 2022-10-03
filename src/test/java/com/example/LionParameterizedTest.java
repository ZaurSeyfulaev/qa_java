package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private String gender;
    private boolean hasMane;

    public LionParameterizedTest(String gender, boolean hasMane) {
        this.gender = gender;
        this.hasMane = hasMane;
    }


    @Parameterized.Parameters
    public static Object[][] doesHaveMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(gender, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }
}
