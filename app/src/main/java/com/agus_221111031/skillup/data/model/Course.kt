package com.agus_221111031.skillup.data.model

data class Course(
    val name: String,
    val description: String,
    val materials: String,
    val platform: String,
    val level: String,
    val duration: String,
    val certificate: Boolean,
    val content: String,
    val progress: Int = 0 // Persentase progress kursus, default 0
)