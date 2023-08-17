package edu.uchicago.ejcrane._03repos

import edu.uchicago.ejcrane._04models.Youtube
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import io.quarkus.mongodb.panache.kotlin.PanacheQuery
import jakarta.enterprise.context.ApplicationScoped
import org.bson.types.ObjectId

@ApplicationScoped
class MongoYTRepo: PanacheMongoRepository<Youtube>, YTRepoInterface {

    //CREATE

    override fun _create(yt: Youtube) {
        this.persist(yt)
    }

    //READ

    override fun _readById(id:String): Youtube {
        val ytId = ObjectId(id)
        return this.findById(ytId) ?: throw Exception("No Youtube with given ID")
    }

    override fun _readAll(): List<Youtube> {
        return this.listAll()
    }

    //UPDATE

    override fun _update(updatedYt: Youtube) {
        this.update(updatedYt)
    }

    //DELETE

    override fun _deleteById(id: String) {
        val ytId = ObjectId(id)
        this.deleteById(ytId)
    }

    override fun _deleteAll() {
        this.deleteAll()
    }

    //COUNT
    override fun _count(): Long {
        return this.count()
    }

    override fun _findAll(): PanacheQuery<Youtube>? {
        return this.findAll()
    }
}