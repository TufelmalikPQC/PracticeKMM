package com.practice.kmm.model.data

import kotlinx.datetime.LocalDate

/**
 * Project data model representing a project card.
 *
 * @property id Unique identifier for the project
 * @property name Project label (e.g., "Project 1")
 * @property title Project title (e.g., "Front-End Development")
 * @property date Project date
 */
data class Project(
    val id: String,
    val name: String,
    val title: String,
    val date: LocalDate
)
