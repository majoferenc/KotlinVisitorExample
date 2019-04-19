package com.ibm.visitor

import com.ibm.entity.Nachricht
import com.ibm.entity.ValueBlob
import org.springframework.stereotype.Component

@Component
class LoggerVisitor : Visitor {

    override fun visit(nachricht: Nachricht): Any {
        println("Nachricht name: " + nachricht.name)
        return 0
    }

    override fun visit(valueBlob: ValueBlob): Int {
        println("ValueBlob name: ${valueBlob.name} Value: ${valueBlob.attachmentValue}")
        return 0
    }
}
