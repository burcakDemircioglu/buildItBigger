package com.udacity.gradle.builditbigger;

import org.junit.Test;
import static org.junit.Assert.*;
import com.example.JokeProvider;

public class JokeTest {
    @Test
    public void testIfTheJokeExists(){
        String joke= JokeProvider.getJoke();
        assertFalse(joke.isEmpty());
    }
}