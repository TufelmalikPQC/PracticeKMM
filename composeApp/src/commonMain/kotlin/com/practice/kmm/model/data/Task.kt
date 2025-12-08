package com.practice.kmm.model.data

import com.practice.kmm.model.enums.TaskCategory
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

/**
 * Task data model representing a single task.
 *
 * @property id Unique identifier for the task
 * @property name Task name/title
 * @property date Date of the task
 * @property startTime Start time of the task
 * @property endTime End time of the task
 * @property description Detailed description of the task
 * @property category Category/type of the task
 * @property createdAt Timestamp when the task was created
 */
data class Task(
    val id: String,
    val name: String,
    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val description: String,
    val category: TaskCategory,
    val createdAt: LocalDateTime
)
