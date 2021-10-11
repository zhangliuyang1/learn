package singleton;

public class Test {

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        Elvis2 elvis2 = Elvis2.getInstance();
        Elvis3 elvis3 = Elvis3.INTANCE;

        Elvis3[] elvis3s = Elvis3.values();

        SingtonEnum singtonEnum = SingtonEnum.INSTANCE;


        elvis.print();
        elvis2.print();
        elvis3.print();

        singtonEnum.print();



    }
}
