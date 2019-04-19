package com.ibm.entity

import com.ibm.visitor.Visitor
import java.io.Serializable
import kotlin.random.Random

data class Nachricht(var nachrichtId: Int = 0, var name: String? = null) : Element, Serializable {

    constructor(name: String?) : this(){
        this.nachrichtId = Random.nextInt()
        this.name = name
    }

    override fun accept(visitor: Visitor):Any? {
        return visitor.visit(this)
    }
}