package org.example;

import org.example.config.AppConfig;
import org.example.dao.UserDAO;
import org.example.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add User\n2. Get All Users\n3. Get by ID\n4. Update\n5. Delete\n6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // clear the newline character after reading int

            switch (ch) {
                case 1:
                    User u = new User();
                    System.out.print("Enter name: ");
                    u.setName(sc.nextLine()); // reads full name
                    System.out.print("Enter email: ");
                    u.setEmail(sc.nextLine()); // reads full email
                    userDAO.save(u);
                    System.out.println("User added!");
                    break;
                case 2:
                    userDAO.getAll().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // optional: clear newline
                    System.out.println(userDAO.getById(id));
                    break;
                case 4:
                    User upd = new User();
                    System.out.print("Enter ID to update: ");
                    upd.setId(sc.nextInt());
                    sc.nextLine(); // clear newline
                    System.out.print("New Name: ");
                    upd.setName(sc.nextLine());
                    System.out.print("New Email: ");
                    upd.setEmail(sc.nextLine());
                    userDAO.update(upd);
                    System.out.println("User updated!");
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    userDAO.delete(delId);
                    System.out.println("User deleted!");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
