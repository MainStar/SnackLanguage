package snackLanguage.service.Impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import snackLanguage.dao.utils.HibernateSessionFactory;
import snackLanguage.service.interfaces.UsersDaoService;
import snackLanguage.dao.entities.UserEntity;

import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;


/**
 * That class work with DataBase SnackLanguage with table "users". */

public class UsersDaoServiceImpl implements UsersDaoService {

    private SessionFactory sessionFactory;
    private Session session = openSession();

    public Session openSession() {
        return HibernateSessionFactory.getSessionFactory().withOptions().jdbcTimeZone(TimeZone.getTimeZone("UTC")).openSession();
    }

    /** Save field of Session to make some operations with DB */
    public void setSession(Session session) {
        this.session = session;
    }

    public void saveUser(UserEntity user) {
        System.out.println(user);
        session.save(user);
        Transaction th = session.getTransaction();
        th.begin();
        th.commit();
        closeSession();
    }

    /** Get user by ID from DB */
    public UserEntity getUserById(int id) {
        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.addOrder(Order.asc("id"));
        List<UserEntity> userList = criteria.list();

        int low = 0;
        int hight = userList.size();

        while (low < hight){
            int mid = (low + hight)/2;
            if (userList.get(mid).getId() == id){
                closeSession();
                return userList.get(mid);
            }else {
                if (id < userList.get(mid).getId()){
                    hight = mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        closeSession();
        return null;
    }

    public List<UserEntity> getAllUsers() {
        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.addOrder(Order.asc("id"));
        List<UserEntity> usersList = criteria.list();
        closeSession();
        return usersList;
    }

    public void updateUser(UserEntity user) {
        session.update(user);
        session.getTransaction().commit();
        closeSession();
    }

    public void deleteUser(UserEntity user) {
        session.delete(user);
        session.getTransaction().commit();
        closeSession();
    }

    public void closeSession() {
        if (!session.isConnected()){
            session.close();
        }
    }
}
