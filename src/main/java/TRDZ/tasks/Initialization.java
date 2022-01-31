package TRDZ.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Initialization {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] accept = {"Yes","yes","1","true","True","Да","да","+"}; //Задаем перечень согласия
    protected static final Plate Plate = new Plate();
    protected static Cat[] Cats;
    private static String pref;
    private static String pref2;
    private static String pref3;
    private static boolean error;                   //Флаг ошибки

    public static void main(String[] args) {
        int cats = 1+(int)(Math.random()*8);
        pref = (cats==1) ? "" : "ы";                //Стилизация текста
        pref2 = (cats<5) ? "а" : "ов";              //Стилизация текста
        pref3 = (cats==1) ? "у" : "ам";             //Стилизация текста
        Cats=new Cat[cats];
        for (int i = 0; i < cats; i++) Cats[i]=new Cat(); //Определяем котов
        cats_game(); //Начало игры
        }

    /**
     * Выполнение процесса игры с мимской и котом(ами)
     */
    private static void cats_game(){
        while (true) {
            int action = 0;
            Faze_home();
        //region Ввод действия
            while (!(action >0)) {
                if (scanner.hasNextInt()) {
                    action = scanner.nextInt();} //Проверка на некоректный ввод
                else {error=true;}
                if (error||(action >4)) {        //Оформление ошибки ввода
                    Faze_home();
                    action =0;}
                scanner.nextLine();
                }
        //endregion
        //region Взаимодействия
            switch (action) {
            case 1: Faze_cats();
                break;
            case 2:
                Faze_plate(); //Новое меню
            //region Ввод действия
                action = 0;
                while (!(action >0)) {
                    if (scanner.hasNextInt()) {
                        action = scanner.nextInt();} //Проверка на некоректный ввод
                    else {error=true;}
                    if (error||(action >5)) {        //Оформление ошибки ввода
                        Faze_plate();
                        action =0;}
                    scanner.nextLine();
                    }
            //endregion
                if (action<5) Plate.add_food((action+((action-1)*(action-1)))); //добавляем еду
            case 3: Faze_time();
                break;
            case 4:
                System.out.println("Вы действительно хотите уйти");
                if (Arrays.asList(accept).contains(scanner.next())) {return;}
                }
        //endregion
            }
        }

    /**
     * Проверка есть ли голодные коты
     * @return true / false
     */
    private  static boolean isEat_Time(){
        for (Cat cat : Cats) {if (cat.isHungry()) return true;}
        return false;
        }

    /**
     * Вывод текста(сценки) в доме
     */
    private static void Faze_home() {
        System.out.println("\nВы дома у вас есть кот"+pref+" и миска");
        System.out.println("1 - Подойти к кот"+pref3);
        System.out.println("2 - Подойти к миске");
        System.out.println("3 - Ждать");
        System.out.println("4 - Уйти");
        }

    /**
     * Вывод текста(сценки) у места котов
     */
    private static void Faze_cats() {
        System.out.print("\nВы подошли к месту. ");
        if (Cats.length>1) System.out.println("Туда сюда шныряют "+Cats.length+" кот"+pref2+".");
        else System.out.println("Кот посмотрел на вас и пошел дальше.");
        if (isEat_Time()) {System.out.println("Похоже настало время кормешки.");}
        }

    /**
     * Вывод текста(сценки) у миски
     */
    private static void Faze_plate() {
        System.out.print("\nВы подошли к миске. ");
        if (Plate.get_food()<10) System.out.println("В ней почти ничего нет");
        else if (Plate.get_food()<15) System.out.println("В ней немного остатков");
        else System.out.println("В ней порций: "+(Plate.get_food()/15));
        System.out.println("1 - Добавить порцию");
        System.out.println("2 - Добавить 3 порции");
        System.out.println("3 - Добавить 7 порций");
        System.out.println("4 - Добавить 12 порций");
        System.out.println("5 - Уйти");
        }

    /**
     * Управление состоянием и действием котов с течением времени
     */
    private static void Faze_time(){
        System.out.println("\nПрошло 2 часа");
        for (Cat cat : Cats) {
            if (cat.isHungry()) {cat.Eat(Plate);}
            else {cat.Set_eattime();}
            }
        }

    }
