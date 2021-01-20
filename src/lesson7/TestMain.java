package lesson7;

public class TestMain {

    public static void main(String[] args) {
//        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
//        потом вывести информацию о сытости котов в консоль.
//        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.

        Cat[] cats = {
                new Cat("Барсик", 60, false),
                new Cat("Рыжик", 50, false),
                new Cat("Мурзик", 55, false) };
        Plate plate = new Plate(50);

        inviteCats(plate);

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
            plate.addFood(40);
            plate.info();
            cat.eat(plate);
            cat.info();
            plate.info();
        }
/* Или по старинке вот так:
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cat.info();
            plate.addFood(40);
            cats[i].eat(plate);
            cat.info();
            plate.info();
        }*/

    }

    private static void inviteCats(Plate plate) {
        System.out.println("Х: - Мои любимые котята, приглашаю Вас к обеденной миске, только поочереди!");
        plate.info();
    }


}