package com.jfsaaved.solutions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Day1SolutionsTest {

    private Day1Solutions day1Solutions;

    @Before
    public void init() {
        day1Solutions = new Day1Solutions();
    }

    @Test
    public void shouldReplaceCharacters(){
        assertThat(day1Solutions.replace("Saavedra",'a','b')).isEqualTo("Sbbvedrb");
    }

}
