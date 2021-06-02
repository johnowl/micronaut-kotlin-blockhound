package com.johnowl

import io.micronaut.runtime.Micronaut.build
import reactor.blockhound.BlockHound
import reactor.blockhound.integration.*

fun main(args: Array<String>) {

	BlockHound.builder()
		.with(StandardOutputIntegration())
		.with(ReactorIntegration())
		.with(RxJava2Integration())
		.with(BlockHoundCustom())
		.install()

	build()
	    .args(*args)
		.packages("com.johnowl")
		.start()
}


class BlockHoundCustom : BlockHoundIntegration {
	override fun applyTo(builder: BlockHound.Builder) {
		builder.allowBlockingCallsInside("io.micronaut.jackson.codec.JacksonMediaTypeCode", "getObjectMapper")
		builder.allowBlockingCallsInside("java.util.concurrent.ThreadPoolExecutor", "getTask")
	}
}

