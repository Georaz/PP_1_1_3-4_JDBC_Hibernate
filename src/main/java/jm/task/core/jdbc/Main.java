package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Юрий", "Гагарин", (byte) 27);
        userService.saveUser("Валентина", "Терешкова", (byte) 26);
        userService.saveUser("Алексей", "Леонов", (byte) 30);
        userService.saveUser("Герман", "Титов", (byte) 25);
        userService.removeUserById(3);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
