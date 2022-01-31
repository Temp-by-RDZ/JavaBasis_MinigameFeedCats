package TRDZ.tasks;

public class Cat {
    public static int count;
    protected int MyID;
    protected boolean hungry;
    protected int eattime;

    {//def Initialize
        MyID=++count;
        hungry=true;
        }

    /**
     * Проверка голоден ли кот
      * @return true / false
     */
    protected boolean isHungry() {
        return hungry;
        }

    /**
     * Появление апетита у кота
     */
    protected void Set_eattime() {
        eattime--;
        if (eattime<=0) {hungry=true;}
        }

    /**
     * Кот идет есть
     */
    protected void Eat(Plate plate){
        System.out.print("Кот "+MyID+" проголодался и пошел есть. ");
        if (plate.eat(10+(int)(Math.random()*5))) {
            System.out.println("Теперь кот сыт");
            hungry=false;
            eattime=(int)(2+Math.random()*2);}
        else System.out.println("Но в мимке для него не было еды. Кот все еще голоден.");
        }
    }
