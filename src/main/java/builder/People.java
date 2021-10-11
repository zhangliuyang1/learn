package builder;

/**
 *
 * 如果类的构造器或者静态工厂中具有多个参数，Builder模式是一种不错的选择
 * Builder 模式
 */
public class People {

    private String id;
    private String sex;
    private String name;
    private String height;
    private String weight;
    private String eyes;
    private String nose;


    public static class Builder {
        private String id = "";
        private String sex = "";
        private String name = "";
        private String height = "";
        private String weight = "";
        private String eyes = "";
        private String nose = "";


        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder hw(String height, String weight) {
            this.height = height;
            this.weight = weight;
            return this;
        }

        public Builder others(String eyes, String nose) {
            this.eyes = eyes;
            this.nose = nose;
            return this;
        }

        public People build() {
            return new People(this);
        }
    }

    private People(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.sex = builder.sex;
        this.height = builder.height;
        this.weight = builder.weight;
        this.eyes = builder.eyes;
        this.nose = builder.nose;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", eyes='" + eyes + '\'' +
                ", nose='" + nose + '\'' +
                '}';
    }
}
