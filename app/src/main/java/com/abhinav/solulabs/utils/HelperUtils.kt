package com.abhinav.solulabs.utils

import android.content.Context
import android.widget.Toast
import com.abhinav.solulabs.data.remote.ResultData
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

object HelperUtils {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ResultData<T> {
        val response = apiCall.invoke()
        return if (response.isSuccessful) {
            ResultData.success(response.body()!!)
        } else {
            var error = ""
            try {
                val errorBody = JSONObject(response.errorBody()?.string())
                error = errorBody.getString("message")
            }
            catch (e: JSONException)
            {
                error = response.message()
            }
            ResultData.failure(error)
        }
    }

    fun Context.showToast(msg:String,time:Int = Toast.LENGTH_SHORT)
    {
        Toast.makeText(this,msg,time).show()
    }

}