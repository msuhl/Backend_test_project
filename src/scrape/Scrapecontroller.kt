package dk.andro.isten.scrape

import org.jsoup.Jsoup

class Scrapecontroller {
    val url = "https://tv2.dk"

    fun init(){
        val doc = Jsoup.connect(url).get()
        println("Svend " + doc.body())
    }


}