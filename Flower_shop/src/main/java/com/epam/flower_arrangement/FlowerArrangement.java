package main.java.com.epam.flower_arrangement;

/*Создать консольное приложение, удовлетворяющее следующим требованиям:
-Корректно спроектируйте и реализуйте предметную область задачи.
-Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования.
-Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
-для проверки корректности переданных данных можно применить регулярные выражения.
-Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
-Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().

Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
(объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы и упаковка.
 */

import java.util.List;

public class FlowerArrangement {
    private List<Flower> flowers;
    private Packaging packaging;

    public FlowerArrangement(List<Flower> flowers, Packaging packaging) {
        this.flowers = flowers;
        this.packaging = packaging;
    }

    @Override
    public String toString() {
        return "flowers: " + flowers +
                ", packaging: " + packaging.getType();
    }
}
