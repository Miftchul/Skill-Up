package com.agus_221111031.skillup.data.job.repository

import com.agus_221111031.skillup.data.job.model.Job
import com.agus_221111031.skillup.data.job.provider.JobProvider

class JobRepository(private val providers: List<JobProvider>) {
    suspend fun getAllJobs(): List<Job> {
        val jobs = mutableListOf<Job>()
        providers.forEach { provider ->
            jobs.addAll(provider.fetchJobs())
        }
        return jobs
    }
}
