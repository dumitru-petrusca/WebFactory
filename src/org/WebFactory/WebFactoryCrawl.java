/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.WebFactory;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import java.util.regex.Pattern;

/**
 *
 * @author apetrusca
 */
public class WebFactoryCrawl extends WebCrawler {

    private final static Pattern FILTERS =
            Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g"
            + "|png|tiff?|mid|mp2|mp3|mp4"
            + "|wav|avi|mov|mpeg|ram|m4v|pdf"
            + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    @Override
    public boolean shouldVisit(WebURL url) {
        String href = url.getURL().toLowerCase();
        return (!FILTERS.matcher(href).matches() /*&& href.startsWith("http://www.jurnal.md/")*/);
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println(url);

//        if (page.getParseData() instanceof HtmlParseData) {
//            HtmlParseData htmlParseData =
//                    (HtmlParseData) page.getParseData();
//            String text = htmlParseData.getText();
//            String html = htmlParseData.getHtml();
//            List<WebURL> links = htmlParseData.getOutgoingUrls();
//
//            System.out.println("Text length: " + text.length());
//            System.out.println("Html length: " + html.length());
//            System.out.println("Number of outgoing links: " + links.size());
//        }
    }
}
