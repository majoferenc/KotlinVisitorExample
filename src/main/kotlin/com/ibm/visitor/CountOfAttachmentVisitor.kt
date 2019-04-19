package com.ibm.visitor

import com.ibm.entity.Nachricht
import com.ibm.entity.ValueBlob
import com.ibm.repository.NachrichtRepository
import com.ibm.repository.ValueBlobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CountOfAttachmentVisitor : Visitor {

    @Autowired
    lateinit var valueBlobRepository: ValueBlobRepository

    override fun visit(valueBlob: ValueBlob): Int? {
        return 0
    }

    override fun visit(nachricht: Nachricht): Int {
        var count = 0
        val valueBlobList = this.valueBlobRepository.findAllByNachricht(nachricht)
        valueBlobList.forEach {
            if (!it.attachmentValue.isNullOrEmpty()){
                count++
            }
        }
        println("Count of not null or empty attachments are $count")
        return count
    }
}