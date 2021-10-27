package com.example.shoppingstore.events;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//TODO LEARN AOP ANOTATIONS
@Aspect
public class MyEvents {

    @Before("execution(public String getBalance())")
    public void loginAdvice() {
        System.out.println("Advice run, withdraw method called");
    }

}
