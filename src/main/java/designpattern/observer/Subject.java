package designpattern.observer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Subject extends Observable {


    private ArrayList<AbstractObserver> observers;
    private String msg;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyOb();
    }

    public void notifyOb() {
        for (AbstractObserver observer : observers) {
            observer.update(this, msg);
        }
    }

    public void addObserver(AbstractObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void deleteObserver(AbstractObserver observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    public void removeAll() {
        observers.removeAll(observers);
    }


    public String getMsg() {
        return msg;
    }


}
