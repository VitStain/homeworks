package lesson7;


public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int n) {
        food += n;
        System.out.println("Х: - Вот добавка еды " + n + ", кушай на здоровье! :)");
    }
    //4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
//    наполовину сыт (это сделано для упрощения логики программы).
    public boolean decreaseFood(int n) {
        if (n > food)
            return false;
        else food -= n;
        return true;
    }

    // 2.Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
//            (например, в миске 10 еды, а кот пытается покушать 15-20):
    public void info() {
        if (food >= 0) System.out.println("Еды в миске: " + food);
        else if (food < 0) {
            food = 0;
            System.out.println("В миске: " + food + ", еда вся съедена.");
        }
    }
}

