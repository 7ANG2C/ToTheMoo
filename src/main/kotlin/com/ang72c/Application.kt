package com.ang72c

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.ang72c.plugins.*

fun main() {
    val p = System.getenv("PORT")?.toIntOrNull()
    embeddedServer(Netty, port = p ?: 80) {
        configureRouting()
    }.start(wait = true)
}
