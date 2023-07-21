package com.github.mrs;

/**
 * description: 改进后的if-else测试
 * date: 2023/7/21 11:16
 * author: MR.孙
 */
public class AnimalTest {

    public static AnimalEnums getAnimalEnums(String animalType) {
        return AnimalEnums.valueOf(animalType);
    }

    public static void main(String[] args) {
        AnimalEnums cat = getAnimalEnums("Dog");
        String eat = cat.eat();
        System.out.println(eat);
    }

}
