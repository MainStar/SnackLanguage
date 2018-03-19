package snackLanguage.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import snackLanguage.dao.entities.UserEntity;
import snackLanguage.service.interfaces.UserRegistrationService;

import java.io.IOException;
import java.io.InputStream;

public class UserRegistrationServiceImpl implements UserRegistrationService {

    private UserEntity user;

    public UserEntity readUserFromJSON(InputStream is) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        user = mapper.readValue(is, UserEntity.class);
        return user;
    }

    public String checkOnExistingAccount(UserEntity user) {
        return null;
    }

    public String registrationUser(UserEntity user) {
        return null;
    }
}
