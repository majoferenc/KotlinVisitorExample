package com.ibm.entity

import com.ibm.visitor.Visitor
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Nachricht(
        @Id
        @GeneratedValue
        var nachrichtId: Int = 0,
        var name: String? = null
) : Element, Serializable {

    constructor(name: String?) : this(){
        this.name = name
    }

    override fun accept(visitor: Visitor):Any? {
        return visitor.visit(this)
    }
}