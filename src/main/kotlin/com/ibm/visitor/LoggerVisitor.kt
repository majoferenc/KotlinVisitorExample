package com.ibm.visitor

import com.ibm.entity.Nachricht
import com.ibm.entity.ValueBlob
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class LoggerVisitor : Visitor {

    val logger = LoggerFactory.getLogger(this::class.java)

    override fun visit(nachricht: Nachricht): Any {
        this.logger.info("Nachricht name: ${nachricht.name}")
        return 0
    }

    override fun visit(valueBlob: ValueBlob): Int {
        this.logger.info("ValueBlob name: ${valueBlob.name} Value: ${valueBlob.attachmentValue}")
        return 0
    }
}
