package com.practice.kmm.modules.task.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.practice.kmm.model.enums.TaskCategory
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.GradientPurpleEnd
import com.practice.kmm.theme.GradientPurpleMiddle
import com.practice.kmm.theme.GradientPurpleStart
import com.practice.kmm.theme.textSecondary
import com.practice.kmm.uiToolKit.CategoryChip
import com.practice.kmm.uiToolKit.PrimaryButton
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.action_create_task
import practicekmm.composeapp.generated.resources.cd_back_button
import practicekmm.composeapp.generated.resources.cd_search_icon
import practicekmm.composeapp.generated.resources.hint_task_description
import practicekmm.composeapp.generated.resources.label_category
import practicekmm.composeapp.generated.resources.label_date
import practicekmm.composeapp.generated.resources.label_description
import practicekmm.composeapp.generated.resources.label_end_time
import practicekmm.composeapp.generated.resources.label_name
import practicekmm.composeapp.generated.resources.label_start_time
import practicekmm.composeapp.generated.resources.title_create_task

/**
 * Create Task screen composable with editable form fields.
 *
 * @param onNavigateBack Callback to navigate back
 * @param onTaskCreated Callback when task is created
 * @param modifier Modifier for the screen
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CreateTaskScreen(
    onNavigateBack: () -> Unit,
    onTaskCreated: () -> Unit,
    modifier: Modifier = Modifier
) {
    var taskName by remember { mutableStateOf("Design Changes") }
    var taskDate by remember { mutableStateOf("Oct 24, 2020") }
    var startTime by remember { mutableStateOf("01:22 pm") }
    var endTime by remember { mutableStateOf("03:20 pm") }
    var description by remember { mutableStateOf("Lorem ipsum dolor sit amet, er adipiscing elit, sed dianummy nibh euismod dolor sit amet.") }
    var selectedCategory by remember { mutableStateOf(TaskCategory.Design) }

    val headerGradient = Brush.verticalGradient(
        colors = listOf(GradientPurpleStart, GradientPurpleMiddle, GradientPurpleEnd)
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Gradient header section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = Dimensions.cornerXLarge,
                            bottomEnd = Dimensions.cornerXLarge
                        )
                    )
                    .background(headerGradient)
                    .padding(Dimensions.spacing16)
            ) {
                Column {
                    // Header row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = onNavigateBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(Res.string.cd_back_button),
                                tint = Color.White
                            )
                        }

                        Text(
                            text = stringResource(Res.string.title_create_task),
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )

                        IconButton(onClick = { /* Search */ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = stringResource(Res.string.cd_search_icon),
                                tint = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(Dimensions.spacing24))

                    // Name field (editable)
                    Text(
                        text = stringResource(Res.string.label_name),
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                    OutlinedTextField(
                        value = taskName,
                        onValueChange = { taskName = it },
                        textStyle = MaterialTheme.typography.headlineSmall.copy(color = Color.White),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    HorizontalDivider(
                        color = Color.White.copy(alpha = 0.3f)
                    )

                    Spacer(modifier = Modifier.height(Dimensions.spacing12))

                    // Date field (editable)
                    Text(
                        text = stringResource(Res.string.label_date),
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                    OutlinedTextField(
                        value = taskDate,
                        onValueChange = { taskDate = it },
                        textStyle = MaterialTheme.typography.titleLarge.copy(color = Color.White),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(Dimensions.spacing16))
                }
            }

            // White content section
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(
                    topStart = Dimensions.cornerXLarge,
                    topEnd = Dimensions.cornerXLarge
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(Dimensions.spacing24)
                ) {
                    // Time section with editable fields and gap
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Start time
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = stringResource(Res.string.label_start_time),
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.textSecondary
                            )
                            Spacer(modifier = Modifier.height(Dimensions.spacing4))
                            OutlinedTextField(
                                value = startTime,
                                onValueChange = { startTime = it },
                                textStyle = MaterialTheme.typography.titleLarge,
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color.Transparent,
                                    unfocusedBorderColor = Color.Transparent
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        // Gap between start and end time
                        Spacer(modifier = Modifier.width(Dimensions.spacing24))

                        // End time
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = stringResource(Res.string.label_end_time),
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.textSecondary
                            )
                            Spacer(modifier = Modifier.height(Dimensions.spacing4))
                            OutlinedTextField(
                                value = endTime,
                                onValueChange = { endTime = it },
                                textStyle = MaterialTheme.typography.titleLarge,
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color.Transparent,
                                    unfocusedBorderColor = Color.Transparent
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        modifier = Modifier.padding(vertical = Dimensions.spacing16)
                    )

                    // Description section (editable)
                    Text(
                        text = stringResource(Res.string.label_description),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.textSecondary
                    )
                    Spacer(modifier = Modifier.height(Dimensions.spacing8))
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        textStyle = MaterialTheme.typography.bodyMedium,
                        placeholder = {
                            Text(
                                text = stringResource(Res.string.hint_task_description),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 3
                    )

                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        modifier = Modifier.padding(vertical = Dimensions.spacing16)
                    )

                    // Category section
                    Text(
                        text = stringResource(Res.string.label_category),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.textSecondary
                    )
                    Spacer(modifier = Modifier.height(Dimensions.spacing12))

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(Dimensions.spacing8),
                        verticalArrangement = Arrangement.spacedBy(Dimensions.spacing8)
                    ) {
                        TaskCategory.entries.forEach { category ->
                            CategoryChip(
                                category = category,
                                selected = category == selectedCategory,
                                onClick = { selectedCategory = category }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // Create Task button
                    PrimaryButton(
                        text = stringResource(Res.string.action_create_task),
                        onClick = onTaskCreated,
                        modifier = Modifier.padding(top = Dimensions.spacing24)
                    )
                }
            }
        }
    }
}
