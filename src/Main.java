/*
7. Разработайте приложение по учету домашней коллекции компакт дисков. Коллекция состоит из дисков разных типов.
Типы носителей – DVD, CD-R, mini-disc. Информация на одном носителе может соответствовать нескольким категориям – фильмы, музыка, ПО и т.п.
 Каждый носитель характеризуется дополнительным описанием. Разрабатываемое приложение должно
 уметь добавлять/удалять/редактировать как состав коллекции, так и словари приложения – состав типов носителей и категории информации.
 */

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        TypeDisc typeD = new TypeDisc();
        TypeCategory typeC = new TypeCategory();
        Disc disc = new Disc(null,null,null,null);
        List<String> discType;
        List<String> discCat;
        List<String> discName;
        List<String> discInfo;
        boolean flag = true;
        while (flag) {
            System.out.println("Главное меню:");
            System.out.println();

            System.out.println("1. Коллекция");
            System.out.println("2. Типы носителей");
            System.out.println("3. Категории");
            System.out.println("4. Выход");

            System.out.println();
            int result = scan.nextInt();

            switch (result) {
                case 1:
                    discName = disc.getName();
                    discType = typeD.getType();
                    discCat = typeC.getCategory();
                    for (int i = 0; i < disc.idDisc; i++) {
                        System.out.print(i + 1 + ". ");
                        System.out.println(discName.get(i));
                    }
                    System.out.println();
                    System.out.println("1. Посмотреть описание");
                    System.out.println("2. Добавить");
                    System.out.println("3. Удалить");
                    System.out.println("4. Сохранить и вернуться в начало");

                    result = scan.nextInt();
                    System.out.println();
                    switch (result) {
                        case 1:
                            System.out.println("Выберите диск:");
                            for (int i = 0; i < disc.idDisc; i++) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(discName.get(i));
                            }
                            int idDisc = scan.nextInt();
                            discInfo = disc.showDiscInfo(idDisc);
                            for (int i = 0; i < 4; i++) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(discInfo.get(i));
                            }
                            break;
                        case 2:
                            System.out.println("Введите название диска:");
                            String name = scan.next();
                            disc.setName(name);
                            System.out.println();
                            System.out.println("Выберите тип диска:");
                            for (int i = 0; i < typeD.idType; i++) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(discType.get(i));
                            }
                            int typeId = scan.nextInt();
                            disc.setType(discType.get(typeId-1));
                            System.out.println();
                            System.out.println("Выберите категорию диска:");
                            for (int i = 0; i < typeC.idCategory; i++) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(discCat.get(i));
                            }
                            int typeIdCat = scan.nextInt();
                            disc.setCategory(discCat.get(typeIdCat-1));
                            System.out.println();
                            System.out.println("Введите описание диска:");
                            String descriptionDisc = scan.next();
                            disc.setDescription(descriptionDisc);
                            disc.saveCD();
                            System.out.println("Сохранение...");
                            break;
                        case 3:
                            System.out.println("Выберите диск, который хотите удалить:");
                            for (int i = 0; i < disc.idDisc; i++) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(discName.get(i));
                            }
                            System.out.println();
                            int typeId1 = scan.nextInt();
                            disc.deleteDisc(typeId1);
                            break;
                        default: continue;
                    }
                    break;

                case 2:
                    discType = typeD.getType();
                    for (int i = 0; i < typeD.idType; i++) {
                        System.out.print(i + 1 + ". ");
                        System.out.println(discType.get(i));
                    }
                    System.out.println();
                    System.out.println("1. Добавить");
                    System.out.println("2. Удалить");
                    System.out.println("3. Изменить");
                    System.out.println("4. Сохранить и вернуться в начало");

                    result = scan.nextInt();
                    System.out.println();
                    switch (result) {
                        case 1:
                            System.out.println("Введите тип диска, который хотите добавить:");
                            String nameOfType1 = scan.next();
                            typeD.addType(nameOfType1);
                            break;
                        case 2:
                            System.out.println("Выберите номер типа диска, который хотите удалить:");
                            for (int i = 0; i < typeD.idType; i++) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(discType.get(i));
                            }
                            System.out.println();
                            int typeId1 = scan.nextInt();
                            typeD.deleteType(typeId1);
                            break;
                        case 3:
                            System.out.println("Введите тип диска, который хотите изменить:");
                            int typeId2 = scan.nextInt();
                            System.out.println("Введите новое название типа диска:");
                            String nameOfType2 = scan.next();
                            typeD.updateType(typeId2, nameOfType2);
                            break;
                        default: continue;
                    }
                break;

                case 3:
                    discCat = typeC.getCategory();
                    for (int i = 0; i < typeC.idCategory; i++) {
                        System.out.print(i + 1 + ". ");
                        System.out.println(discCat.get(i));
                    }
                    System.out.println();
                    System.out.println("1. Добавить");
                    System.out.println("2. Удалить");
                    System.out.println("3. Изменить");
                    System.out.println("4. Сохранить и вернуться в начало");

                    result = scan.nextInt();
                    System.out.println();
                    switch (result) {
                        case 1:
                            System.out.println("Введите название категории, которую хотите добавить:");
                            String nameOfType1 = scan.next();
                            typeC.addCategory(nameOfType1);
                            break;
                        case 2:
                            System.out.println("Выберите номер категории, которую хотите удалить:");
                            for (int i = 0; i < typeC.idCategory; i++) {
                                System.out.print(i + 1 + ". ");
                                System.out.println(discCat.get(i));
                            }
                            System.out.println();
                            int typeId1 = scan.nextInt();
                            typeC.deleteCategory(typeId1);
                            break;
                        case 3:
                            System.out.println("Введите номер категории, который хотите изменить:");
                            int typeId2 = scan.nextInt();
                            System.out.println("Введите новое название выбранной категории:");
                            String nameOfType2 = scan.next();
                            typeC.updateCategory(typeId2, nameOfType2);
                            break;
                        default: continue;
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}