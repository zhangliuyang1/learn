package designpattern.observer;

import java.util.Observable;

public abstract class AbstractObserver {

    protected abstract void update(Observable o, Object args);
}
