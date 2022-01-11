package com.api.orange.controllers;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserControllerImplTest {

    @BeforeEach
    public void setup() {
        System.out.println("Before");
    }

    @AfterEach()
    public void afterSetup() {
        System.out.println("After");
    }

    @Test
    void Test() {
        assertEquals(2, 2);
    }

}
