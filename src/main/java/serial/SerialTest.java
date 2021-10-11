package serial;

import java.io.*;

/**
 * 1.必须实现Serializable接口
 * 2.serialVersionUID
 * 当一个类实现了Serializable接口，没有显式定义serialVersionUID，Java序列化机制会根据编译的class自动生成一个serialVersionUID作序列化版本比较用，如果Class文件（类名，新增方法，新增成员变量）没有发生变化，就算编译多次，serialVersionUID也不会变化的。如果序列化之后，Class发生了变化，那么在反序列化时会发生一下异常：Exception in thread "main" java.io.InvalidClassException: serial.Person; local class incompatible: stream classdesc serialVersionUID = 1106148740872496090, local class serialVersionUID = -1445763362175307200
 * 	at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:616)
 * 	at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1630)
 * 	at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1521)
 * 	at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:1781)
 * 	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1353)
 * 	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:373)
 * 	at serial.SerialTest.main(SerialTest.java:22)
 *
 * 3.所以在定义可序列化类的时候，既要实现Serializable接口，又需要显式定义serialVersionUID （兼容新老版本，static，final，long修饰）
 * @Author: zhangliuyang01
 * @Date: 2021/6/1 下午4:46
 */
public class SerialTest {
    public static void main(String[] args) throws Exception {
        String fileName = "/Users/liuyangzhang/Documents/58/project/learn/person";
//        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
//
//        Person person = new Person(18, "female");
//        Man man = new Man("190", "80kg");
//
//        os.writeObject(man);
//        os.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
        Object object = ois.readObject();
        Man man  = (Man)object;
        System.out.println(object.toString());
        System.out.println(man.hello());
        ois.close();
    }


}
