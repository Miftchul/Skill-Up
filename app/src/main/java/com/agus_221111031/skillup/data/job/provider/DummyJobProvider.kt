package com.agus_221111031.skillup.data.job.provider

import com.agus_221111031.skillup.data.job.model.Job

class DummyJobProvider : JobProvider {
    override suspend fun fetchJobs(): List<Job> {
        return listOf(
            Job(
                id = "1",
                title = "Python Developer",
                company = "SkillTech",
                location = "Remote",
                source = "Dummy",
                tags = listOf("python", "remote"),
                description = "Bekerja dengan tim AI modern."
            )
        )
    }
}
