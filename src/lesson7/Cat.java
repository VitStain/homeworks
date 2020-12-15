package lesson7;


public class Cat {
    private String name;
    private int appetite;
    public boolean satiety;


    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;

    }
//3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
//    удалось покушать (хватило еды), сытость = true.
//4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
//    наполовину сыт (это сделано для упрощения логики программы).

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)!=satiety)
            satiety = true;
        else System.out.println(name + ": хозяин, обижаешь, мне мало еды, не буду есть пока не добавишь еще! Мне нужно " + appetite);
    }


    void info() {
        String checkSatiety = satiety ? ": хозяин, я уже покушал, сытый, мур-мур, спасибо!(сытость = " + satiety + ")" : ": хозяин, мяу-мяу, я голоден!!!(сытость = " + satiety + ")";
        System.out.println(name + checkSatiety);
    }
}
