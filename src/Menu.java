import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
   static List<User> users = new ArrayList<>();

    public static void start(List user){
        users = user;
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        while (true) {
            System.out.println("""
                Выберите действие
                1 - добавить контакт
                2 - удалить контакт
                3 - найти контакт
                5 - сохранить список
                6 - показать весь список""");
            try {
                res = scanner.nextInt();
                if (res==1){
                    users = PhoneBook.addNewUser(users);
                    for (User u:users
                    ) {
                        System.out.println(u.toString());
                    }
                } else if (res==2) {
                      users = PhoneBook.deleteUser(users);
                } else if (res==3) {
                    PhoneBook.findUser(users);
                } else if (res==5) {
                    PhoneBook.saveUsers(users);
                } else if (res==6) {
                    PhoneBook.printAllUsers(users);
                } else {
                    System.out.println("нет такого пункта");
                    System.out.println();
                }

            }catch (Exception e){
                System.out.println("Проверьте символы!");
                System.out.println();
                scanner = new Scanner(System.in);
            }
        }
    }
}
