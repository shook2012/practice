package net.strive.designpatterns.Structuralpattern.proxy;

/**
 * 具体实现
 */
public class RealSubject implements Subject {
    public void doSomething() {
        System.out.println("call doSomething()");
    }
} 