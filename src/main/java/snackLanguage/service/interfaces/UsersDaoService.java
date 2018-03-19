package snackLanguage.service.interfaces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import snackLanguage.dao.entities.UserEntity;

import java.util.List;

public interface UsersDaoService {

    Session openSession();
    void setSession(Session session);
    void saveUser(UserEntity user);
    UserEntity getUserById(int id);
    List<UserEntity> getAllUsers();
    void updateUser(UserEntity user);
    void deleteUser(UserEntity user);
    void closeSession();

}
