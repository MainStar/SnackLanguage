package snackLanguage.service.interfaces;

import snackLanguage.dao.entities.UserEntity;

import java.io.IOException;
import java.io.InputStream;

public interface UserRegistrationService {

    UserEntity readUserFromJSON(InputStream is) throws IOException;
    String checkOnExistingAccount(UserEntity user);
    String registrationUser(UserEntity user);

}
