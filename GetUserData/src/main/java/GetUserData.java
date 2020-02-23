import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(urlPatterns = "/render")

/***
 * This servlet has created as a part of the home task:
 * Realize a web-application, that accept a GET requests, and stores in the memory a list of unique ip-addresses, that
 * makes a request to it, and appropriate values of http-headers User-Agent.
 * In response application gives html document with the current list (IP and User-Agent must be bold - html tag <b></b>)
 *
 * Example of the list:
 *
 * 127.0.0.1 :: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0
 */
public class GetUserData extends HttpServlet {

    private String responseTemplate;
    public Set<String> userData;

    @Override
    public void init() throws ServletException {

        try {
            URI templateURI = getClass().getResource("/template/demo.html").toURI();
            responseTemplate = Files.readString(Paths.get(templateURI), StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {
            throw new ServletException(e);
        }

        System.out.println("!!! HtmlRendering Servlet Initialized !!!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUserData that = (GetUserData) o;
        return userData.equals(that.userData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userData);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String remoteHost = req.getRemoteHost(); //get ip

        System.out.println("GET from " + remoteHost);

        String parameter = req.getHeader("User-Agent");
        userData = ConcurrentHashMap.newKeySet();

        String username = Optional
                .ofNullable(parameter)
                .orElse("Anonymous");

        userData.add(remoteHost + " :: " + username);

        String responseBody = responseTemplate
                .replace("{userdata}", userData.toString());

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().print(responseBody);

    }

    @Override
    public void destroy() {
        System.out.println("!!! HtmlRendering Servlet Destroyed !!!");
    }
}
