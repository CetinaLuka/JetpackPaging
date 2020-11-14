package com.i.paging.models

import com.google.gson.annotations.SerializedName

class Repository(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String?,
    @SerializedName("html_url") val url: String,
    @SerializedName("stargazers_count") val stars: Int,
    @SerializedName("forks_count") val forks: Int,
    @SerializedName("language") val language: String?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Repository

        if (id != other.id) return false
        if (name != other.name) return false
        if (fullName != other.fullName) return false
        if (description != other.description) return false
        if (url != other.url) return false
        if (stars != other.stars) return false
        if (forks != other.forks) return false
        if (language != other.language) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + fullName.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + url.hashCode()
        result = 31 * result + stars
        result = 31 * result + forks
        result = 31 * result + (language?.hashCode() ?: 0)
        return result
    }
}

