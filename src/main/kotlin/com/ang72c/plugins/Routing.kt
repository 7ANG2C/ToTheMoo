package com.ang72c.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
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
                .build().newCall(request).execute().body?.string() ?: "OUO?"
            call.respondText(response)
        }
    }
    routing {
        post("/post") {
            call.respondText("POST SUCCESS", status = HttpStatusCode.Created)
        }
    }
}