package com.ibm.repository

import com.ibm.entity.Nachricht
import org.springframework.data.repository.CrudRepository

interface NachrichtRepository : CrudRepository<Nachricht, Int> {
}