package com.plandel.borutoapp_compose.domain.model

@kotlinx.serialization.Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: String? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList()
)