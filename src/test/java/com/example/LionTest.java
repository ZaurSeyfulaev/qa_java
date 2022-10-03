package com.example;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception{
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());

    }


    @Test
    public void incorrectGenderException() throws Exception {
        String expected = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Лев", feline);
        });
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void getFoodTest() throws Exception{
        List<String> expectedResult=List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самец",feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedResult);
        List <String> actualResult = lion.getFood();
        assertEquals(expectedResult, actualResult);
    }
}