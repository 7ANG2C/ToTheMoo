package com.ang72c

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.ang72c.plugins.*
import io.ktor.server.application.*
import io.ktor.server.plugins.doublereceive.*

fun main() {
    val p = System.getenv("PORT")?.toIntOrNull()
    embeddedServer(Netty, port = p ?: 80) {
        install(DoubleReceive)
        configureRouting()
    }.start(wait = true)
}
