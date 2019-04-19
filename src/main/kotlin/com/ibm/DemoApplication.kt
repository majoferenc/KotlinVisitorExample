package com.ibm

import com.ibm.entity.Nachricht
import com.ibm.entity.ValueBlob
import com.ibm.repository.NachrichtRepository
import com.ibm.repository.ValueBlobRepository
import com.ibm.visitor.LoggerVisitor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@SpringBootApplication
class DemoApplication{

    @Autowired lateinit var nachrichtRepository: NachrichtRepository
    @Autowired lateinit var valueBlobRepository: ValueBlobRepository

    @Bean
    fun databaseInitializer() = CommandLineRunner {
        val visitorA = LoggerVisitor()
        val nachricht1 = Nachricht("HD123456")
        nachrichtRepository.save(nachricht1)
        val kba_attachment1 = ValueBlob("kba1.xml")
        val nachricht_xml = ValueBlob("nachricht.xml")
        val protocol_xml = ValueBlob("protocol.xml")
        val xml1 = "xmlExample1"
        val xml2 = "xmlExample1"
        val xml3 = "xmlExample1"
        kba_attachment1.attachmentValue = xml1
        nachricht_xml.attachmentValue = xml2
        protocol_xml.attachmentValue = xml3
        kba_attachment1.nachricht = nachricht1
        nachricht_xml.nachricht = nachricht1
        protocol_xml.nachricht = nachricht1
        valueBlobRepository.save(kba_attachment1)
        valueBlobRepository.save(nachricht_xml)
        valueBlobRepository.save(protocol_xml)
    }
}