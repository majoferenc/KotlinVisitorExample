package com.ibm.repository

import com.ibm.entity.Nachricht
import com.ibm.entity.ValueBlob
import org.springframework.data.repository.CrudRepository

interface ValueBlobRepository : CrudRepository<ValueBlob, Int> {
    fun findAllByNachricht (nachricht: Nachricht): List<ValueBlob>
}