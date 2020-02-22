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
import java.util.Random;

@WebServlet(urlPatterns = "/render")
public class TossACoinServlet extends HttpServlet {

    private String responseTemplate;

    @Override
    public void init() throws ServletException {
        System.out.println("!!! TossACoin Servlet Initialized !!!");
        try {
            URI templateURI = getClass().getResource("/template/demo.html").toURI();
            responseTemplate = Files.readString(Paths.get(templateURI), StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String headsOrTails;

        boolean tossACoin = new Random().nextBoolean();
        if (tossACoin) {
            headsOrTails = "heads";
        } else {
            headsOrTails = "tails";
        }
        req.setAttribute("headsOrTails", headsOrTails);


        String responseBody = responseTemplate
                .replace("{headsOrTails}", headsOrTails);

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().print(responseBody);

    }

    @Override
    public void destroy() {
        System.out.println("!!! TossACoin Servlet Destroyed !!!");
    }
}
