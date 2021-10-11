package singleton;

public enum Elvis3 {
    INTANCE(2,"zzzlllyyy");

    private long id;
    private String name;

    Elvis3(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print(){
        System.out.println("print elvis3");

        System.out.println("id = " + id + "  name = " + name);
    }
}
