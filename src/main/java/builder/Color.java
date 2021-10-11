package builder;

import java.util.EnumSet;

public enum Color {

    WHITE,
    BLACK,
    BLUE,
    RED;


    public static void main(String[] args) {
        EnumSet<Color> colors = EnumSet.allOf(Color.class);

        colors.forEach(System.out::println);

        System.out.println(colors);
    }

}
