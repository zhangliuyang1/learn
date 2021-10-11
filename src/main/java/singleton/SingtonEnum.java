package singleton;

/**
 * 单元素的枚举类型已经成为实现Singleton的最佳方法
 */
public enum SingtonEnum {

    INSTANCE;

    public void print(){
        System.out.println("SingtonEnum");
    }

}
