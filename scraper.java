import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class scraper  {

    public static void main(String[] args) throws Exception {
        /*
        The following lines(11-15) are the url links to scrape actors, directors
        oscar winning and nominating films, film ratings and movie distributors.
        These URL's are time sensitive so if IMDB or any other site listed changes their URL this code
        will not function properly.
         */
        final Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();
        final Document document2 = Jsoup.connect("https://www.imdb.com/list/ls062419846/").get();
        final Document document3 = Jsoup.connect("https://www.imdb.com/list/ls054840033/").get();
        final Document document4 = Jsoup.connect("https://www.imdb.com/list/ls057163321/").get();
        final Document document5 = Jsoup.connect("https://www.imdb.com/list/ls000057871/").get();

        for (Element row : document.select("table.chart.full-width tr")) {

            final String title = row.select(".titleColumn a").text();
            final String rating = row.select(".imdbRating").text();

            System.out.println(title + " -> Rating: " + rating);
        }

        for (Element row : document2.select("div.lister-item.mode-detail")) {

            final String title = row.select(".titleColumn a").text();
            final String director = row.select(".Director Name").text();

            System.out.println(title + " -> Director: " + director);
        }

        for (Element row : document3.select("div.lister-list")) {

            final String title = row.select(".titleColumn a").text();
            final String actor = row.select("Actor Name").text();

            System.out.println(title + " -> Actor: " + actor);
        }

        for (Element row : document4.select("div.lister.list.detail.sub-list")) {

            final String title = row.select(".titleColumn a").text();
            final String oscarNom = row.select("Oscar Nominated Films").text();

            System.out.println(title + " -> Oscar Nominated " + oscarNom);
        }

        for (Element row : document5.select("div.lister-list")) {

            final String title = row.select(".titleColumn a").text();
            final String oscarWin = row.select(".oscarWinning").text();

            System.out.println(title + " -> Oscar Winning: " + oscarWin);
        }
    }



    }
