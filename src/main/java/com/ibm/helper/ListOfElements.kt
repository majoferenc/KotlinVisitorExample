package com.ibm.helper

import com.ibm.entity.Element
import java.util.ArrayList

class ListOfElements {
    private val elementList = ArrayList<Element>()

    fun attach(element: Element) {
        this.elementList.add(element)
    }

    fun getElementList(): List<Element> {
        return this.elementList
    }
}
