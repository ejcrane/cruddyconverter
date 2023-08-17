package edu.uchicago.ejcrane._02services

import edu.uchicago.ejcrane._03repos.MongoYTRepo
import edu.uchicago.ejcrane._03repos.YTRepoInterface
import edu.uchicago.ejcrane._04models.Youtube
import io.quarkus.mongodb.panache.kotlin.PanacheQuery
import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class YTService {
    @Inject
    lateinit var concreteRepository: MongoYTRepo

    lateinit var interfaceRepository: YTRepoInterface

    @PostConstruct
    fun initialize() {
        interfaceRepository = concreteRepository
    }
    fun create(yt: Youtube) {
        interfaceRepository._create(yt)
    }

    fun readById(id:String): Youtube{
        return  interfaceRepository._readById(id)
    }
    fun readAll(): List<Youtube>{
        return  interfaceRepository._readAll()
    }
    fun update(updatedYt: Youtube){
        return  interfaceRepository._update(updatedYt)
    }
    fun deleteById(id:String){
        return  interfaceRepository._deleteById(id)
    }
    fun deleteAll(){
        interfaceRepository._deleteAll()
    }
    fun count() : Long{
        return interfaceRepository._count()
    }
    fun findAll(): PanacheQuery<Youtube>?{
        return interfaceRepository._findAll()

    }
}