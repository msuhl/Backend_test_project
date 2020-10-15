package dk.andro.isten

import dk.andro.isten.scrape.GraphQlController
import dk.andro.isten.scrape.Scrapecontroller
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.engine.jetty.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val client = HttpClient(Jetty) {
    }

    routing {
        get("/") {
            val svend = "Svend"
            call.respondText("HELLO WORLD! $svend", contentType = ContentType.Text.Plain)
        }

        get("/svend") {
            val svend = "Svend"
            GraphQlController()
            call.respondText("HELLO WORLD! $svend", contentType = ContentType.Text.Plain)
        }
    }
}

