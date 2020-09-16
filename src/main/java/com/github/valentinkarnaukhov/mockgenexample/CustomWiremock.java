package com.github.valentinkarnaukhov.mockgenexample;

import com.github.tomakehurst.wiremock.stubbing.StubMapping;

public class CustomWiremock {

    public static void mock(StubMapping stub) {
        System.out.println("Hello: " + stub);
    }

}
