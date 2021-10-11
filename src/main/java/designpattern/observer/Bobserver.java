package designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Bobserver extends AbstractObserver {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(((Subject) o).getMsg() + "----" + arg);
    }
}
