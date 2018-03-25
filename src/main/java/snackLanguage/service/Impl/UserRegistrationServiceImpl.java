package snackLanguage.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import snackLanguage.dao.entities.UserEntity;
import snackLanguage.service.interfaces.UserRegistrationService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserRegistrationServiceImpl implements UserRegistrationService {

    private UsersDaoServiceImpl userDao = new UsersDaoServiceImpl();

    private List<UserEntity> users = new ArrayList<UserEntity>();
    private UserEntity user;

    public UserEntity readUserFromJSON(InputStream is) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        user = mapper.readValue(is, UserEntity.class);
        return user;
    }

    public String checkOnExistingAccount(UserEntity user) {
        cleanUserList();
        users = userDao.getAllUsers();
        for (UserEntity el : users){
            if (user.getUser_email().equals(el.getUser_email()) && user.getPassword().equals(el.getPassword())){
                return "failed";
            }
            if (user.getUser_email().equals(el.getUser_email())){
                return "failed";
            }
        }
        //registrationUser(user);
        return "ok";
    }

    public String registrationUser(UserEntity user) {
        userDao.saveUser(user);
        return "ok";
    }

    private void cleanUserList(){
        users.clear();
    }
}
