import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HrefContentsParser {
    private static final String ANCHOR_TAG = "a";
    private static final String HREF_ATTR = "href";
    private static final String REGEX = "<a href=(\"[^\"]*\")[^<]*</a>";

    private static String getHrefUrl (final Node anchorTag) {
        final Node hrefAttribute = anchorTag.getAttributes().getNamedItem(HREF_ATTR);
        if (hrefAttribute != null) {
            return hrefAttribute.getNodeValue();
        }
        return null;
    }

    public static ArrayList<String> getHrefUrlContents (final HtmlPage htmlPage) {
        final ArrayList <String> hrefUrlList = new ArrayList<String>();
        final NodeList anchorTags = htmlPage.getElementsByTagName(ANCHOR_TAG);
        for (int iterator = 0; iterator < anchorTags.getLength(); iterator ++) {
            final Node anchorTag = anchorTags.item(iterator);
            final String hrefUrl = getHrefUrl(anchorTag);
            if (hrefUrl != null) {
                hrefUrlList.add(hrefUrl);
            }
        }
        return hrefUrlList;
    }

    public static ArrayList<String> getHrefUrlContentsUsingRegex (final HtmlPage htmlPage) {
        final ArrayList <String> hrefUrlList = new ArrayList<String>();
        final String pageContents = htmlPage.asXml();
        final Pattern pattern = Pattern.compile(REGEX);
        final Matcher matcher = pattern.matcher(pageContents);
        while (matcher.find()) {
            hrefUrlList.add(matcher.group(1));
        }
        return hrefUrlList;
    }
}
