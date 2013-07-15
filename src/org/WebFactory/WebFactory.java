package org.WebFactory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

class WebFactory {

    public static void main(String args[]) {

        String crawlStorageFolder = "/data/crawl/root";
        int numberOfCrawlers = 4;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);

        try {

            CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

            // controller.addSeed("http://www.ics.uci.edu/~welling/");
            // controller.addSeed("http://www.ics.uci.edu/~lopes/");
            // controller.addSeed("http://www.ics.uci.edu/");

            controller.addSeed("http://www.jurnal.md/");
            controller.start(WebFactoryCrawl.class, numberOfCrawlers);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
