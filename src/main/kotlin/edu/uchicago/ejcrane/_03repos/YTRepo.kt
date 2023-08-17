package edu.uchicago.ejcrane._03repos

import edu.uchicago.ejcrane._04models.Youtube
import io.quarkus.mongodb.panache.kotlin.PanacheQuery
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class YTRepo: YTRepoInterface {
    //CREATE

    override fun _create(yt: Youtube) {
        //do nothing
    }

    //READ

    override fun _readById(id: String): Youtube {
        return Youtube()
    }

    override fun _readAll(): List<Youtube> {
        return mutableListOf(Youtube())
    }

    //UPDATE

    override fun _update(updatedYoutube: Youtube) {
        //nothing
    }

    //DELETE

    override fun _deleteById(id: String) {
        //does nothing
    }

    override fun _deleteAll() {
        //still... no
    }

    //COUNT

    override fun _count(): Long {
        return 100L
    }

    override fun _findAll(): PanacheQuery<Youtube>? {
        return null
    }
}