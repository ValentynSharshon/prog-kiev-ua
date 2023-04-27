package com.gmail.woosay333.functional_interfaces.private_methods.null_safe_comparator;

public class CatEntity {

    private String name;
    private String breed;
    private String color;
    private double weight;

    private CatEntity() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "CatEntity{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static CatEntityBuilder newBuilder() {
        return new CatEntity().new CatEntityBuilder();
    }

    public class CatEntityBuilder {

        private CatEntityBuilder() {
            super();
        }

        public CatEntityBuilder setName(String name) {
            CatEntity.this.name = name;
            return this;
        }

        public CatEntityBuilder setBreed(String breed) {
            CatEntity.this.breed = breed;
            return this;
        }

        public CatEntityBuilder setColor(String color) {
            CatEntity.this.color = color;
            return this;
        }

        public CatEntityBuilder setWeight(double weight) {
            CatEntity.this.weight = weight;
            return this;
        }

        public CatEntity build() {
            return CatEntity.this;
        }
    }

}
