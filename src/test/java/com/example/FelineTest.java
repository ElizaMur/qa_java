package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {
    @Test
    public void felineEatMeatTest() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }
    @Test
    public void felineGetFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void felineGetKittensTest() {
        Feline feline = new Feline();
        assertEquals((1), feline.getKittens());
    }
    @Test
    public void felineGetKittensTestWithParameter() {
        Feline feline = new Feline();
        assertEquals((2), feline.getKittens(2));
    }
}