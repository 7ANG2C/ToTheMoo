package com.ang72c.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request

fun Application.configureRouting() {
    routing {
        get("/ethbusd") {
            val request = Request.Builder()
                .url("https://fapi.binance.com/fapi/v1/klines?symbol=ETHBUSD&limit=5&interval=1m")
                .addHeader("Content-Type", "application/json")
                .build()
            val response = OkHttpClient().newBuilder()
                .build().newCall(request).execute().body?.string() ?: "NULL RESPONSE"
            call.respondText(response)
        }
    }
    routing {
        post("/post") {
            val value = when (call.receiveText()) {
                "BUY" -> "show hand buy"
                "SELL" -> "show hand sell"
                else -> "show hand what?"
            }
            call.respondText(value, status = HttpStatusCode.OK)
        }
    }
}