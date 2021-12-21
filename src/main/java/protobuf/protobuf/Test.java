package protobuf.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import protobuf.StudentOuterClass;

import java.nio.charset.StandardCharsets;

public class Test {

    public static void main(String[] args) {

        PersonInfo.info_data.Builder infoBuilder = PersonInfo.info_data.newBuilder();
        PersonInfo.info_data info_data = infoBuilder.setAddress("beijing").setAvatar("touxiang").setEducation("benke").setJob("code").build();

        StudentOuterClass.Student.Builder studentBuilder = StudentOuterClass.Student.newBuilder();
        StudentOuterClass.Student student = studentBuilder.setSex(1).setSex(1).setWeight(11).setName("lll").setId(100).build();

        PersonInfo.person_data.Builder builder = PersonInfo.person_data.newBuilder();
        PersonInfo.person_data person_data = builder.setId(1).setAge(1).setName("zzz").setWeight(1).setInfo(info_data).setStudent(student).build();

        System.out.println(person_data.toByteArray().length);
        System.out.println(person_data);
        System.out.println("after json format##################");
        try {
            String print = JsonFormat.printer().print(person_data);
            System.out.println(print);
            System.out.println(print.getBytes(StandardCharsets.UTF_8).length);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
