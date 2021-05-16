package hrynkevych.serhii.homework7_4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = "";

        while (true) { //проверяем, введен ли -конец-
            inputLine = scanner.nextLine();
            if (inputLine.contains("конец")) break; //завершаем программу, если ввели -коонец-

            String[] nameAndMarks = inputLine.split(":"); //создаем массив из введеной строки, разделяя по -:-
            NameAndMarks nameMarks = new NameAndMarks();
            nameMarks.name = nameAndMarks[0]; //создаем строку с именем, взяв данные из нулевого элемента массива
            nameMarks.marksString = nameAndMarks[1]; //создаем строку с оценками, взяв данные из первого элемента массива
            String[] marksArray = nameMarks.marksString.split(","); //создаем массив с оценками, разделив строку с оценками по -,-

            MaxMinAverage maxMin = new MaxMinAverage();
            maxMin.max = 0; //создаём переменную для максимума
            maxMin.min  = Integer.MAX_VALUE; //создаём переменную для минимума
            maxMin.average = 0; //создаём переменную для средней оценки

            for (String mark : marksArray){ //создаём цикл, что б пройтись по всем оценкам
                int markInt = Integer.parseInt(mark); //преобразовываем строковое значение оценки в Инт
                if (maxMin.max < markInt){ //ищем максимальный балл
                    maxMin.max = markInt;
                }
                if (maxMin.min > markInt){ //ищем минимальный балл
                    maxMin.min = markInt;
                }

                maxMin.average = (((float)maxMin.min + maxMin.max) / 2); //находим среднее знасение между макс и мин
            }

            //выводим результаты в консоль
            System.out.println("Максимальная оценка для " + nameMarks.name + " - " + maxMin.max);
            System.out.println("Минимальная оценка для " + nameMarks.name + " - " + maxMin.min);
            System.out.println("Средняя оценка для " + nameMarks.name + " - " + maxMin.average);
        }
    }
}