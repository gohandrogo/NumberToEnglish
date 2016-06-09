package io.handro;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
/**
 * Created by alejandrolondono on 6/9/16.
 */
public class DollarsToEnglishTest {

    String number, notANumber;

    @Before
    public void setup(){
        number= "2345";
        notANumber="hello";
    }

    @Test
    public void isNumberTest(){
        assertTrue(DollarsToEnglish.isNumber(number));
    }

    @Test
    public void isNotNumberTest(){
        assertFalse(DollarsToEnglish.isNumber(notANumber));
    }

    @Test
    public void splitInputTest(){
        String[] expected = {"5","4","3","2"};
        String[] actual = DollarsToEnglish.reverseSplitInput(number);
        assertEquals(Arrays.asList(expected),Arrays.asList(actual));
    }

    @Test
    public void parseStringArrayTest(){
        ArrayList<Integer> expected= new ArrayList<Integer>(Arrays.asList(5,4,3,2));
        String[] strActual = DollarsToEnglish.reverseSplitInput(number);
        ArrayList<Integer>  actual = DollarsToEnglish.parseStringArray(strActual);
        assertEquals(expected.get(3), actual.get(3));
    }

    @Test
    public void onesTest(){
        String expected="Seven";
        String actual = DollarsToEnglish.ones(7);
        assertEquals(expected,actual);
    }

    @Test
    public void tensTest(){
        String expected="Fifty";
        String actual = DollarsToEnglish.tens(5);
        assertEquals(expected,actual);
    }

    @Test
    public void DecimalTest(){
        String expected = "Thousand";
        String actual = DollarsToEnglish.decimal(1,4);
        assertEquals(expected,actual);
    }

    @Test
    public void HundredsTest(){
        String expected = "FourHundred";
        String actual = DollarsToEnglish.hundreds(4);
        assertEquals(expected,actual);
    }

    @Test
    public void correctFormatTest(){
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0,2,1));
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(2,1));
        ArrayList<Integer> actual = DollarsToEnglish.correctFormat(test);
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void toEnglishTest(){
        String expected = "FortySevenThousandTwoHundredNine";
        ArrayList<Integer> number = new ArrayList<>(Arrays.asList(9,0,2,7,4));
        String actual = DollarsToEnglish.toEnglish(number);
        assertEquals(expected,actual);
    }

    @Test
    public void appendDollars(){
        String expected="Dollars";
        String actual = DollarsToEnglish.appendDollars("");
        assertEquals(expected,actual);
    }

    @Test
    public void engineTest(){
        String expected="TwoThousandThreeHundredFortyFiveDollars";
        String actual = DollarsToEnglish.engine(number);
        assertEquals(expected,actual);
    }

    @Test
    public void engineTwoTest(){
        String expected="OneMillionDollars";
        String actual = DollarsToEnglish.engine("55352");
        assertEquals(expected,actual);
    }
}
