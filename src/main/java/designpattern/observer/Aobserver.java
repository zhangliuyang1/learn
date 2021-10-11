package designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Aobserver extends AbstractObserver {

    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject)o;

        System.out.println(((Subject) o).getMsg() + "----" + arg);
    }
}
