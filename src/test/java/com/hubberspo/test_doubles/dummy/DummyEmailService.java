package com.hubberspo.test_doubles.dummy;

public class DummyEmailService implements EmailService{
    @Override
    public void senEmail(String message) {
        throw new AssertionError("Method not implemented !!!!");
    }
}
