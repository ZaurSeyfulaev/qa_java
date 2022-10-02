package com.example;

import com.sun.source.tree.ModuleTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    private String gender;
    private boolean hasMane;

    public LionTest(String gender, boolean hasMane) {
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

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());

    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(gender);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void incorrectGenderException() throws Exception {
        String expected = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Лев");
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void getFoodTest() throws Exception{
        List<String> expectedResult=List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedResult);
        List <String> actualResult = lion.getFood();
        assertEquals(expectedResult, actualResult);
    }
}