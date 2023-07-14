import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    public static List<User> addNewUser(List<User> users) {
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        int number = 0;
        while (true) {
            try {
                System.out.println("Введите номер");
                System.out.print("+");
                number = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Проверте символы");
                System.out.println();
                scanner = new Scanner(System.in);
            }
        }
        for (User u:users
             ) {
            if(u.getNumber()== number){
                System.out.println("есть такой номер: "+u.getName()+" "+u.getSurname());
                System.out.println();
                Menu.start(users);
            }
        }

            if (b){
                scanner = new Scanner(System.in);
                System.out.println("Введите имя");
                String name = scanner.nextLine();
                System.out.println("Введите фамилию");
                String surname = scanner.nextLine();
                User newUser = new User(number,name,surname);
                users.add(newUser);
                System.out.println("Контакт добавлен");
                System.out.println();
            }


        return users;
    }
    public static List<User> deleteUser(List<User> users){
        Scanner scanner = new Scanner(System.in);
        int number;
        int userNumber = 0;
        String name = "";
        String surName = "";
        boolean deleteUserByNumber = false;
        boolean deleteUserByName = false;
        boolean noContact = true;
        while (true) {
            try {
                System.out.println("""
                    как будете удалять?
                    1 - по номеру
                    2 - по имени и фамилии
                    3 - назад""");
                number = scanner.nextInt();
                break;

            }catch (Exception e){
                System.out.println("Неверный ввод");
                System.out.println();
                scanner = new Scanner(System.in);
            }

        }
        while (true) {
            if (number == 1) {
                try {
                    System.out.println("Введите номер");
                    System.out.print("+");
                    scanner = new Scanner(System.in);
                    userNumber = scanner.nextInt();
                    deleteUserByNumber = true;
                    break;
                } catch (Exception e) {
                    System.out.println("Проверьте номер");
                    System.out.println();
                    scanner = new Scanner(System.in);
                }
            } else if (number == 2) {
                scanner = new Scanner(System.in);
                System.out.println("Введите имя");
                name = scanner.nextLine();
                System.out.println("Введите фамилию");
                surName = scanner.nextLine();
                deleteUserByName = true;
                break;

            } else if (number==3) {
                Menu.start(users);
            } else {
                System.out.println("Нет такого пункта");
                System.out.println();
                deleteUser(users);
            }

        }
        if(deleteUserByNumber){
            for (User u:users
            ) {
                if (u.getNumber()==userNumber){
                    users.remove(u);
                    System.out.println("Контакт удален");
                    System.out.println();
                    noContact = false;
                    break;
                }
            }
        }
        if(deleteUserByName){
            for (User u:users
                 ) {
                if (u.getName().equals(name) && u.getSurname().equals(surName)){
                    users.remove(u);
                    System.out.println("Контакт удален");
                    System.out.println();
                    noContact = false;
                    break;
                }
            }

        }
            if(noContact){
                System.out.println("Нет такого контакта");
                System.out.println();
                deleteUser(users);
            }


            return users;
    }
    public static void findUser(List<User> users){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String surName ="";
        boolean findByNumber = false;
        boolean findByName = false;
        boolean noContact = true;
        int userNumber = 0;
        int res;
        while (true){
            try {
                System.out.println("""
                        1 - найти по номеру
                        2 - найти по имени и фамилии
                        3 - назад""");
                res = scanner.nextInt();
                break;

            }catch (Exception e){
                System.out.println("неверный ввод");
                scanner = new Scanner(System.in);
            }
        }
        while (true){
            if (res==1){
                try {
                    System.out.print("Введите номер : +");
                    userNumber = scanner.nextInt();
                    findByNumber = true;
                    break;

                }catch (Exception e){
                    System.out.println("проверте номер");
                    scanner = new Scanner(System.in);
                }
            } else if (res==3) {
                Menu.start(users);
            } else if (res==2) {
                scanner = new Scanner(System.in);
                System.out.println("Введите имя");
                name = scanner.nextLine();
                System.out.println("Введите фамилию");
                surName = scanner.nextLine();
                findByName = true;
                break;


            } else {
                System.out.println("нет такого пункта!!!");
                System.out.println();
                findUser(users);
            }
        }
        if (findByNumber){
            for (User u:users
                 ) {
                if(u.getNumber()==userNumber){
                    System.out.println(u.getName()+" "+ u.getSurname());
                    System.out.println();
                    noContact = false;
                }
            }
        }
        if (findByName){
            for (User u:users
                 ) {
                if (u.getName().equals(name) && u.getSurname().equals(surName)){
                    System.out.println("номер : +" + u.getNumber());
                    noContact = false;
                }
            }
        }
        if (noContact){
            System.out.println("нет такого номера");
            System.out.println();
            findUser(users);


        }

    }
    public static void saveUsers(List<User> users) throws IOException {
       FileOutputStream fos = new FileOutputStream("users.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        fos.close();
        System.out.println("список сохранен");
        System.out.println();
    }
    public static void printAllUsers(List<User> users){
        for (User u:users
             ) {
            System.out.println(u.toString());
        }
    }
}
