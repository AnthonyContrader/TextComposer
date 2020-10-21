package it.contrader.controller;

import junit.framework.TestCase;

public class SecurityControllerTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testHashPassword() {
        String testString = "test";
        String hashValueTest = "098f6bcd4621d373cade4e832627b4f6";
        String stringHashed = SecurityController.hashPassword(testString);
        assertNotNull(stringHashed);
        assertEquals(stringHashed, hashValueTest);
    }
}