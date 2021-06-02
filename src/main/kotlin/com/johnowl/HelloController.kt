package com.johnowl

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single
import kotlinx.coroutines.reactive.awaitSingle
import reactor.blockhound.BlockHound
import javax.inject.Singleton

// import kotlinx.coroutines.rx2.await

@Controller
class HelloController(
    private val httpClientSuspend: HttpClientSuspend,
    private val httpClientRx: HttpClientRx,
    private val httpClientDefault: HttpClientDefault
) {

    @Get("/suspend")
    suspend fun getSuspend(): String {
        return httpClientSuspend.get()
    }

    @Get("/rx")
    fun getRx(): Single<String> {
        return httpClientRx.get()
    }

    @Get("/default")
    fun getDefault(): String {
        return httpClientDefault.get()
    }

}

@Singleton
class Service1 {
    fun block() {
        Thread.sleep(5000)
    }
}

@Client("https://httpbin.org")
interface HttpClientSuspend {
    @Get("/get")
    suspend fun get(): String
}

@Client("https://httpbin.org")
interface HttpClientRx {
    @Get("/get")
    fun get(): Single<String>
}

@Client("https://httpbin.org")
interface HttpClientDefault {
    @Get("/get")
    fun get(): String
}