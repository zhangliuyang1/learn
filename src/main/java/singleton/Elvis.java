package singleton;

public class Elvis {

    private Elvis(){

    }

    public static final Elvis INSTANCE = new Elvis();

    public static Elvis getInstance(){
        return INSTANCE;
    }

    public void print(){
        System.out.println("print elvis");
    }

    public static void main(String[] args) {
        Elvis instance = Elvis.getInstance();
        Elvis instance1 = Elvis.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());

    }
}
