package com.gmail.woosay333.functional_interfaces.private_methods.null_safe_comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class NullFriendlyComparatorRunner {

    public static void main(String[] args) {
        List<CatEntity> catList = new ArrayList<>();
        catList.add(null);
        catList.add(CatEntity.newBuilder()
                .setName("Vaska")
                .setColor("Black")
                .setBreed("Scotland")
                .setWeight(7.8)
                .build());
        catList.add(CatEntity.newBuilder()
                .setName("Umka")
                .setColor("White")
                .setBreed("Scotland")
                .setWeight(6.6)
                .build());
        catList.add(CatEntity.newBuilder()
                .setName("Kuzia")
                .setColor("Yellow")
                .setBreed("Scotland")
                .setWeight(7.2)
                .build());
        catList.add(null);
        catList.add(CatEntity.newBuilder()
                .setName("Barsik")
                .setColor("Red")
                .setBreed("Scotland")
                .setWeight(3.3)
                .build());
        catList.add(null);
        catList.add(null);

        Comparator<CatEntity> catWeightComparator = Comparator.comparingDouble(CatEntity::getWeight);

        catWeightComparator = NullFriendlyComparator.rangeNullFirst(catWeightComparator);

        catList.sort(catWeightComparator);

        catList.forEach(out::println);
    }

}
