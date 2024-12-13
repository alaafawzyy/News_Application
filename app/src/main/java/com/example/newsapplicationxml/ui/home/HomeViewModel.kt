package com.example.newsapplicationxml.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.model.BreakingNews
import com.example.domain.useCase.BreakingNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val breakingUseCase: BreakingNewsUseCase):ViewModel() {
    //val sourceLiveData= MutableLiveData<List<Source>?>()
   // val newsLiveData=MutableLiveData<List<Source>?>()
  //  val breakingNewsLiveData=MutableLiveData<List<BreakingNews>?>()
    private val _product = MutableStateFlow<List<BreakingNews>?>(null)
    val product: StateFlow<List<BreakingNews>?> get() = _product

    fun getBreakingNews() {
        viewModelScope.launch {
            breakingUseCase.invoke().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _product.value =
                            resource.data
                    }

                    is Resource.Fail -> {
                        Log.w("HomeViewModel", "Error: sss")
                        // يمكن أن تضيف هنا معالجة الخطأ
                    }

                    else -> {
                        Log.w("HomeViewModel", "Error:lll")


                    }
                }

            }}}}


