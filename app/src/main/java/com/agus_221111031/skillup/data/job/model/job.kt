package com.agus_221111031.skillup.data.job.model

data class Job(
    val id: String,
    val title: String,
    val company: String,
    val location: String,
    val source: String,
    val tags: List<String>,
    val description: String
)
