package com.agus_221111031.skillup.data.job.provider

import com.agus_221111031.skillup.data.job.model.Job

interface JobProvider {
    suspend fun fetchJobs(): List<Job>
}
