package net.strive.designpatterns.Action.iterator;

public interface Iterator {
    Object next();
    
    void first();
    
    void last();
    
    boolean hasNext();

}
