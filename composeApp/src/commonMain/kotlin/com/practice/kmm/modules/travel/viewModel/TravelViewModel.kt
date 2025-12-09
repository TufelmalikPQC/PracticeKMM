package com.practice.kmm.modules.travel.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.practice.kmm.models.travel.Adventure
import com.practice.kmm.models.travel.Flight

data class TravelUiState(
    val selectedAdventureTab: Int = 0,
    val selectedTransportMode: Int = 0
    // Add other state as needed
)

class TravelViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TravelUiState())
    val uiState: StateFlow<TravelUiState> = _uiState.asStateFlow()

    fun updateAdventureTab(index: Int) {
        _uiState.value = _uiState.value.copy(selectedAdventureTab = index)
    }

    fun updateTransportMode(index: Int) {
        _uiState.value = _uiState.value.copy(selectedTransportMode = index)
    }
}
