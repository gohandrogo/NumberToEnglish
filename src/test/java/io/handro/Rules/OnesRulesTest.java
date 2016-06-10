package io.handro.Rules;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public class OnesRulesTest {
    OnesRules onesRules;
    StringBuilder english;
    ArrayList<Integer> digits;
    @Before
    public void setUp() throws Exception {
        onesRules = new OnesRules();
        english = new StringBuilder();
        digits = new ArrayList<>(Arrays.asList(5));
    }

    @Test
    public void conditionTest() throws Exception {
        assertTrue(onesRules.condition(6));
    }

    @Test
    public void actionTest() throws Exception {
        String expected = "Five";
        StringBuilder actual = onesRules.action(english, digits, 0);
        assertEquals(expected,actual.toString());
    }

}