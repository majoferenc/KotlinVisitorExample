package com.ibm.controller

import com.ibm.repository.NachrichtRepository
import com.ibm.repository.ValueBlobRepository
import com.ibm.visitor.CountOfAttachmentVisitor
import com.ibm.visitor.LoggerVisitor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SpringController{

    @Autowired
    lateinit var nachrichtRepository: NachrichtRepository
    @Autowired
    lateinit var valueBlobRepository: ValueBlobRepository
    @Autowired
    lateinit var countOfAttachmentVisitor: CountOfAttachmentVisitor
    @Autowired
    lateinit var loggerVisitor: LoggerVisitor

    @RequestMapping("/blob")
    fun visitAllValueBlobs(){
        val valueBlobList = this.valueBlobRepository.findAll()
        valueBlobList.forEach { element ->
            element.accept(loggerVisitor)
            val elementReturn = element.accept(countOfAttachmentVisitor)
            println("Element returned: $elementReturn")
        }
    }

    @RequestMapping("/nachricht")
    fun visitAllNachrichts(){
        val valueBlobList = this.nachrichtRepository.findAll()
        valueBlobList.forEach { element ->
            element.accept(loggerVisitor)
            val elementReturn = element.accept(countOfAttachmentVisitor)
            println("Element returned: $elementReturn")
        }
    }
}