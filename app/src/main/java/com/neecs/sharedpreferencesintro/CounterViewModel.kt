// CounterViewModel.kt
package com.neecs.sharedpreferencesintro

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val sharedPreferences = context.getSharedPreferences("com.neecs.sharedpreferencesintro", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun getCounter(): Int {
        return sharedPreferences.getInt("counter", 0)
    }

    fun incrementCounter() {
        viewModelScope.launch {
            var counter = getCounter()
            counter++
            editor.putInt("counter", counter)
            editor.apply()
        }
    }
}