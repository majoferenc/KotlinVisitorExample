package com.ibm.visitor

import com.ibm.entity.Nachricht
import com.ibm.entity.ValueBlob

interface Visitor {
    fun visit(nachricht: Nachricht): Any
    fun visit(valueBlob: ValueBlob): Int
}
