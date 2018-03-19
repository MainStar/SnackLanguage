package snackLanguage.service.interfaces;

import snackLanguage.dao.entities.UserEntity;

import java.io.IOException;
import java.io.InputStream;

public interface UserValidationService {

    UserEntity readUser(InputStream is) throws IOException;
    String checkUser(String email);

}
