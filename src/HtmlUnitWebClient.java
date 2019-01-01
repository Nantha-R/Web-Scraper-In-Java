import com.gargoylesoftware.htmlunit.WebClient;

public class HtmlUnitWebClient {
    public static WebClient getClient() {
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        return webClient;
    }
}
