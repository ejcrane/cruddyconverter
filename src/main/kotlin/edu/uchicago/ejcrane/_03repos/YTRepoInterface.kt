package edu.uchicago.ejcrane._03repos

import edu.uchicago.ejcrane._04models.Youtube
import io.quarkus.mongodb.panache.kotlin.PanacheQuery

interface YTRepoInterface {
    fun _create(yt: Youtube)
    fun _readById(id:String): Youtube
    fun _readAll(): List<Youtube>
    fun _update(updatedYoutube: Youtube)
    fun _deleteById(id:String)
    fun _deleteAll()
    fun _count() : Long
    fun _findAll(): PanacheQuery<Youtube>?
}