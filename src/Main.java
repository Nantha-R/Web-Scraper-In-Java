
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.WebClient;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final String searchUrl = "https://xyz.to";
        final WebClient webClient = HtmlUnitWebClient.getClient();
        try {
            HtmlPage htmlPage = webClient.getPage(searchUrl);
            final ArrayList<String> hrefUrlLinks = HrefContentsParser.getHrefUrlContents(htmlPage);
        }
        catch (Exception exception) {
            System.out.println(String.format("Exception occured while accessing the given URL - '%s' : %s",
                               searchUrl,
                               exception.getMessage()));
        }
    }
}