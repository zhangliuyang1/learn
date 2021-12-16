package protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import java.nio.charset.StandardCharsets;

public class ProtoDemo {
    public static void main(String[] args) {
        StudentOuterClass.Student.Builder builder = StudentOuterClass.Student.newBuilder();
        StudentOuterClass.Student student = builder.setId(1).setName("zzz").setSex(1).setWeight(1).setAge(18).build();
        System.out.println(student);
        byte[] bytes = student.toByteArray();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        System.out.println(student.toByteString().size());

        try {
            StudentOuterClass.Student student1 = StudentOuterClass.Student.parseFrom(bytes);
            System.out.println(student1);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        try {
            String print = JsonFormat.printer().print(student);
            System.out.println(print);
            System.out.println(print.getBytes(StandardCharsets.UTF_8).length);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }
}
