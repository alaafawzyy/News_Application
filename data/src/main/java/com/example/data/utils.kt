package com.example.data

import android.telephony.TelephonyManager.TimeoutException
import android.util.Log
import com.example.domain.common.InternetConnectionError
import com.example.domain.common.Resource
import com.example.domain.common.ServerError
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.isActive
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response
//
//
//suspend fun <T>executeApi(apiCall:suspend ()->T):T{
//    try {
//        val responce=apiCall.invoke()
//        return responce
//
//    }catch (ex:HttpException){
//        if (ex.code() in 400..600) {
//            val serverResponse = ex.response()?.errorBody()?.string()
//            val response = Gson().fromJson<Response<Any>>(serverResponse, Response::class.java)
//
//            throw ServerError(null,null,ex)
//
//           // throw ServerError(response.statusMsg,response.message,ex)
//        }
//        throw ex
//    }

//    catch (ex:IOException){
//         throw InternetConnectionError(ex)
//    }
//    catch (ex:Exception){
//        throw ex
//    }
//
//}
suspend fun <T> executeApi(apiCall: suspend () -> T): T {
    try {
        val response = apiCall.invoke()
        return response
    } catch (ex: HttpException) {
        Log.e("API Error", "HTTP Exception: ${ex.message()}")
        if (ex.code() in 400..600) {
            val serverResponse = ex.response()?.errorBody()?.string()
            Log.e("API Error", "Server Response: $serverResponse")
            val response = Gson().fromJson(serverResponse, Response::class.java)
            throw ServerError(null, null, ex)
        }
        throw ex
    } catch (ex: Exception) {
        Log.e("API Error", "General Error: ${ex.message}")
        throw ex
    }
}




suspend fun <T>toFlow(getData:suspend ()->T): Flow<Resource<T>> {
return flow {
emit(Resource.loading)
    val responce=getData.invoke()
    emit(Resource.Success(responce))
}
    .catch {ex->
        when(ex){
            is ServerError ->{
                emit(Resource.ServerFail(ex))
            }
            is InternetConnectionError -> {
                emit((Resource.Fail(ex)))
            }
            else ->emit(Resource.Fail(ex))
        }

    }
}