package nl.hu.ipass.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.Calendar;
import java.util.Map;

@Path("authentication")
public class AuthenticationResource {
    public static final Key key = MacProvider.generateKey();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(LogonRequest logonRequest) {
        System.out.println(logonRequest.username + " " + logonRequest.password);
        try {
            System.out.println("wordt aangeroepen1");
            String role = MyUser.validateLogin(logonRequest.username, logonRequest.password);
            System.out.println("wordt aangeroepen2");
            if (role==null) throw new IllegalAccessException("validation failed");
            System.out.println("wordt aangeroepen3");
            String token = createToken(logonRequest.username, role);
            System.out.println("wordt aangeroepen4");
            return Response.ok(Map.of("JWT", token)).build();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("wordt aangeroepen5");

        }
        System.out.println("wordt aangeroepen6");
        return Response.status(Response.Status.UNAUTHORIZED).build();

    }

    private String createToken(String username, String role) throws JwtException {
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);


        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

    }

    private static class LogonRequest{
        public String username;
        public String password;
    }


}
