package snackLanguage.rest.resources;

import snackLanguage.dao.entities.UserEntity;
import snackLanguage.service.Impl.UserValidationServiceImpl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;

@Path(value = "/authorization")
public class AuthorizationResources {

    private UserValidationServiceImpl userValidation = new UserValidationServiceImpl();
    private UserEntity user;
    private String checkAuthorization;

    @POST
    @Path(value = "/check")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkAuthorization(InputStream is) throws IOException {
        user = userValidation.readUser(is);
        if (user != null){
            checkAuthorization = userValidation.checkUser(user.getUser_email());
            return checkAuthorization;
        }
        return "invalid";
    }
}
