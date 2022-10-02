package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {
    private int kittensCount;
    private int expected;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    private Feline feline = new Feline();

    public FelineTest(int kittensCount, int expected) {
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
    public void eatMeatTest() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensMethodWithSignatureTest() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(kittensCount));
    }

    @Test
    public void getKittensMethodWithoutSignatureTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);

    }
}