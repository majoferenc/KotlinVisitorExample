package com.ibm.visitor

import com.ibm.entity.Nachricht
import com.ibm.entity.ValueBlob

class CountOfAttachmentVisitor {
    companion object : Visitor{
        override fun visit(valueBlob: ValueBlob): Int {
            return 0
        }

        override fun visit(nachricht: Nachricht): Int {
            var count = 0
            /*
            valueBlob.attachments?.forEach {attachment->
                if (!attachment.isNullOrEmpty()){
                    count++
                }
            }
            */
            println("Count of not null or empty attachments are $count")
            return count
        }
    }
}