## Micronaut + Kotlin + BlockHound

Blockhound detects a blocking call when Jackson loads its modules.

```
Caused by: reactor.blockhound.BlockingOperationError: Blocking call! java.io.RandomAccessFile#readBytes
    at java.base/java.io.RandomAccessFile.readBytes(RandomAccessFile.java)
    at java.base/java.io.RandomAccessFile.read(RandomAccessFile.java:406)
    at java.base/java.io.RandomAccessFile.readFully(RandomAccessFile.java:470)
    at java.base/java.util.zip.ZipFile$Source.readFullyAt(ZipFile.java:1298)
    at java.base/java.util.zip.ZipFile$ZipFileInputStream.initDataOffset(ZipFile.java:997)
    at java.base/java.util.zip.ZipFile$ZipFileInputStream.read(ZipFile.java:1012)
    at java.base/java.util.zip.ZipFile$ZipFileInflaterInputStream.fill(ZipFile.java:467)
    at java.base/java.util.zip.InflaterInputStream.read(InflaterInputStream.java:159)
    at java.base/java.io.InputStream.readNBytes(InputStream.java:490)
    at java.base/java.util.jar.JarFile.getBytes(JarFile.java:805)
    at java.base/java.util.jar.JarFile.checkForSpecialAttributes(JarFile.java:1005)
    at java.base/java.util.jar.JarFile.isMultiRelease(JarFile.java:388)
    at java.base/java.util.jar.JarFile.getEntry(JarFile.java:507)
    at java.base/sun.net.www.protocol.jar.URLJarFile.getEntry(URLJarFile.java:131)
    at java.base/sun.net.www.protocol.jar.JarURLConnection.connect(JarURLConnection.java:137)
    at java.base/sun.net.www.protocol.jar.JarURLConnection.getInputStream(JarURLConnection.java:155)
    at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.parse(ServiceLoader.java:1164)
    at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.nextProviderClass(ServiceLoader.java:1205)
    at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNextService(ServiceLoader.java:1220)
    at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNext(ServiceLoader.java:1264)
    at java.base/java.util.ServiceLoader$2.hasNext(ServiceLoader.java:1299)
    at java.base/java.util.ServiceLoader$3.hasNext(ServiceLoader.java:1384)
    at com.fasterxml.jackson.databind.ObjectMapper.findModules(ObjectMapper.java:1081)
    at com.fasterxml.jackson.databind.ObjectMapper.findModules(ObjectMapper.java:1065)
    at com.fasterxml.jackson.databind.ObjectMapper.findAndRegisterModules(ObjectMapper.java:1115)
    at io.micronaut.jackson.ObjectMapperFactory.objectMapper(ObjectMapperFactory.java:93)
    at io.micronaut.jackson.$ObjectMapperFactory$ObjectMapper0Definition.build(Unknown Source)
    at io.micronaut.context.DefaultBeanContext.doCreateBean(DefaultBeanContext.java:1979)
    at io.micronaut.context.DefaultBeanContext.createAndRegisterSingletonInternal(DefaultBeanContext.java:2770)
    at io.micronaut.context.DefaultBeanContext.createAndRegisterSingleton(DefaultBeanContext.java:2756)
    at io.micronaut.context.DefaultBeanContext.getBeanForDefinition(DefaultBeanContext.java:2427)
    at io.micronaut.context.DefaultBeanContext.getBean(DefaultBeanContext.java:1242)
    at io.micronaut.context.UnresolvedProvider.get(UnresolvedProvider.java:51)
    at io.micronaut.jackson.codec.JacksonMediaTypeCodec.getObjectMapper(JacksonMediaTypeCodec.java:120)
    at io.micronaut.jackson.codec.JacksonMediaTypeCodec.encode(JacksonMediaTypeCodec.java:231)
    at io.micronaut.jackson.codec.JacksonMediaTypeCodec.encode(JacksonMediaTypeCodec.java:257)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeBodyAsByteBuf(RoutingInBoundHandler.java:2099)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeBodyWithCodec(RoutingInBoundHandler.java:2043)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeResponseBody(RoutingInBoundHandler.java:1824)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeHttpResponse(RoutingInBoundHandler.java:1746)
    at io.micronaut.http.server.netty.RoutingInBoundHandler.access$100(RoutingInBoundHandler.java:155)
    at io.micronaut.http.server.netty.RoutingInBoundHandler$2.doOnComplete(RoutingInBoundHandler.java:675)
    at io.micronaut.core.async.subscriber.CompletionAwareSubscriber.onComplete(CompletionAwareSubscriber.java:71)
    ... 978 common frames omitted

```


