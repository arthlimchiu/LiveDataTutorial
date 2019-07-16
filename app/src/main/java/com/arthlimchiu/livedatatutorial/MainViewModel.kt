package com.arthlimchiu.livedatatutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var currentCount = 0

    // Only this view model can change the value of this liveData
    private val _count = MutableLiveData<Int>()

    // Expose and immutable LiveData
    val count: LiveData<Int>
        get() = _count

    fun add() {
        currentCount++
        _count.value = currentCount
    }

    fun subtract() {
        currentCount--
        _count.value = currentCount
    }
}