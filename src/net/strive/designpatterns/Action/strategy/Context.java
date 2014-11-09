package net.strive.designpatterns.Action.strategy;

public class Context {
    Strategy stra;
    
    public Context(Strategy stra) {
        this.stra = stra;
    }
    
    public void doMethod() {
        stra.method();
    }

}
