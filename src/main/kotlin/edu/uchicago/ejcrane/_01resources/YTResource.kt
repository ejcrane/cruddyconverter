package edu.uchicago.ejcrane._01resources

import edu.uchicago.ejcrane._02services.YTService
import edu.uchicago.ejcrane._04models.Youtube
import io.quarkus.mongodb.panache.kotlin.PanacheQuery
import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import java.lang.Exception

@Path("/youtube")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class YTResource {

    @Inject
    lateinit var ytService: YTService

    val TOTAL_PER_PAGE = 20

    @POST
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    fun create(@Valid yt: Youtube): Youtube {
        try { //these checks, along with @Valid, prevent malformed JSON requests
            ytService.create(yt)
            return yt
        } catch (e: Exception) { throw BadRequestException(e) }

    }

    @GET
    fun readAll(): List<Youtube> {
        return ytService.readAll()
    }

    @GET
    @Path("{id}")
    fun readById(@PathParam("id") id: String): Youtube {
        try { return ytService.readById(id) }
        catch (e: Exception) { throw BadRequestException() }
    }

    @GET
    @Path("/paged/{page}")
    fun paged(@PathParam("page") page: Int): List<Youtube> {
        val pagedYtList: PanacheQuery<Youtube>? = ytService.findAll()
        return pagedYtList?.page(page, TOTAL_PER_PAGE)?.list() ?: throw Exception("Paged query returned null")
    }

    @PUT
    fun update(@Valid updatedYt: Youtube): Youtube {
        try {
            ytService.update(updatedYt)
            return updatedYt
        } catch (e: Exception) { throw BadRequestException() }

    }

    @DELETE
    @Path("/{id}")
    fun deleteById(@PathParam("id")id: String): Youtube {
        try {
            val yt = ytService.readById(id)
            ytService.deleteById(id)
            return yt
        } catch (e: Exception) {throw BadRequestException()
        }

        //if successful, return the deleted beer

    }

    @DELETE
    fun deleteAll():List<Youtube>{
        ytService.deleteAll()
        //if successful, return empty list
        return emptyList()
    }
}