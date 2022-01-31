package TRDZ.tasks;

public class Plate {
    private int food;

    {//def Initialize
        food=25;
        }

    /**
     * Увеличение значения еды в миске
     * @param bank количество порций(в каждой по 15ед)
     */
    protected  void add_food(int bank){
        System.out.println("Вы выложили в миску еду. Потеряно банок: "+bank);
        food+=bank*15;
        }

    /**
     * Уменьшение значения еды в миске
     * так как из нее ест кот
     * @param eat Сколько кот хочет сьесть
     * @return Наелся ли кот? true / false
     */
    protected boolean eat(int eat){
        if (food<eat) return false;
        else {food-=eat; return true;}
        }

    /**
     * Получение значения класса
     * @return Количество еды
     */
    public int get_food() {return food;}
    }

