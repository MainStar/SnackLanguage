package snackLanguage.rest.resources;

import snackLanguage.dao.entities.UserEntity;
import snackLanguage.service.Impl.UserRegistrationServiceImpl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;

@Path(value = "/registration")
public class RegistrationResources {

    private UserRegistrationServiceImpl registrationService = new UserRegistrationServiceImpl();
    private UserEntity user;
    private String checkUserOnExist;

    /**
     * That method is get request from user to register someone.
     *
     *If registration process is OK, the response will be "ok", else "failed"!
     * */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String registration(InputStream is) throws IOException {
        user = registrationService.readUserFromJSON(is);
        checkUserOnExist = registrationService.checkOnExistingAccount(user);
        if (checkUserOnExist.equals("ok")) {
            registrationService.registrationUser(user);
            return "ok";
        }
        return "failed";
    }

}
