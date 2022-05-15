package com.example;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Feline feline;

    @Test
    public void lionGetKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1); // создай стаб
        Assert.assertEquals(1, lion.getKittens());
    }


      @Test
    public void lionGetFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> actual = feline.getFood("Хищник");
        assertEquals(actual, lion.getFood());
    }


        private final String sex;
        private final Boolean expected;
        public LionTest(String sex, Boolean expected) {
            this.sex = sex;
            this.expected = expected;
        }
        @Parameterized.Parameters
        public static Object[][] getData() {
            return new Object[][] {
                    {"Самка", false},
                    {"Самец", true},
            };
        }
        @Test
        public void lionDoesHaveManeTest() throws Exception {
            Lion lion = new Lion(sex, feline);
            assertEquals(expected, lion.doesHaveMane(sex));
        }

        @Test
    public void lionDoesHaveManeTestException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Mane", feline));
        assertEquals(exception.getMessage(), "Используйте допустимые значения пола животного - самей или самка");
        }

}





