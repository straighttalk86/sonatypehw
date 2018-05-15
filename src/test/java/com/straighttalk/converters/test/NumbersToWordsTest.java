package com.straighttalk.converters.test;

import com.straighttalk.converters.NumbersToWords;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumbersToWordsTest {

    @Test
    public void testConvert() {
        NumbersToWords n = new NumbersToWords();

        assertEquals("Should return Zero","Zero", n.convert(0) );
        assertEquals("Should return Thirteen","Thirteen", n.convert(13) );
        assertEquals("Should return Eighty five","Eighty five", n.convert(85) );
        assertEquals("Should return Two hundred and thirty five","Two hundred and thirty five", n.convert(235) );
        assertEquals("Should return Five thousand two hundred and thirty seven","Five thousand two hundred and thirty seven", n.convert(5237) );
    }
}
