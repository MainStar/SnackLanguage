package snackLanguage.service.Impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import snackLanguage.dao.entities.UserEntity;
import snackLanguage.service.interfaces.UserValidationService;

import java.io.*;
import java.util.List;

public class UserValidationServiceImpl implements UserValidationService {

    private UserEntity user;

    public UserEntity readUser(InputStream is) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        user = objectMapper.readValue(is, UserEntity.class);
        System.out.println(user);
        return user;
    }

    public String checkUser(String login) {
        UsersDaoServiceImpl usersService = new UsersDaoServiceImpl();
        Session session = usersService.openSession();
        usersService.setSession(session);
        List<UserEntity> usersList = usersService.getAllUsers();
        usersService.closeSession();
        System.out.println(usersList.size() + " Size of the array of users!");

        for (int i = 0; i < usersList.size(); i++){
            System.out.println("We are at cukl!!!");
            System.out.println(usersList.get(i).getUser_email() + " Проверка!!! " + login);
            if (usersList.get(i).getUser_email().equals(login)){
                return "valid";
            }
        }
        return "invalid";
    }
}
