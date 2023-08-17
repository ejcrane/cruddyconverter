package edu.uchicago.ejcrane._04models

import jakarta.validation.constraints.NotEmpty
import org.bson.types.ObjectId

class Youtube {
    var id: ObjectId? = null

    @NotEmpty(message = "invalid or missing video id")
    lateinit var videoId: String

    @NotEmpty(message = "invalid or missing title")
    lateinit var title: String

    var filePath: String? = null
}