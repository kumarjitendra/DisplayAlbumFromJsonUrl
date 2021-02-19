/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.album.leboncoin.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.album.leboncoin.R
import com.album.leboncoin.data.AlbumItem
import com.album.leboncoin.data.sharedPreference.SharedPreferenceManager
import com.album.leboncoin.ui.adapters.CustomAdapter
import com.static.leboncoin.api.JsonRetriever
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : Activity() {

    private val repoRetriever = JsonRetriever()
    lateinit var resultList: AlbumItem
  /*  data class AlbumToSave(var item: List<Item>)*/


    private val callback = object : Callback<AlbumItem> {
        override fun onFailure(call: Call<AlbumItem>?, t: Throwable?) {
            Log.e("MainActivity", "Problem calling Github API ${t?.message}")
        }

        override fun onResponse(call: Call<AlbumItem>?, response: Response<AlbumItem>?) {
            response?.isSuccessful.let {
                resultList = AlbumItem(response?.body()?.items ?: emptyList())

                // retrieved data is saved in sharePreference
                data class AlbumToSave(var albumItem : Response<AlbumItem>?)
                val albumToSave = AlbumToSave(response)
                SharedPreferenceManager.put(albumToSave, "KEY_Item")
                Log.i(TAG, "onResponse: $resultList")

                albumList.adapter = CustomAdapter(resultList)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        albumList.layoutManager = LinearLayoutManager(this)
        SharedPreferenceManager.with(this)

        if (isNetworkConnected()) {
            repoRetriever.getAlbumDetails(callback)
        } else {
            AlertDialog.Builder(this).setTitle("No Internet Connection")
                    .setMessage("Please check your internet connection and try again")
                    .setPositiveButton(android.R.string.ok) { _, _ -> }
                    .setIcon(android.R.drawable.ic_dialog_alert).show()
        }
        refreshButton.setOnClickListener {
            repoRetriever.getAlbumDetails(callback)
        }
        loggingPersisteddata()
    }

    private fun loggingPersisteddata() {
       /* val persisteddata = SharedPreferenceManager.get<retrievedItems>("KEY_Item")*/
       /* Log.i(TAG, "loggingPersisteddata: $persisteddata")*/
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onRestart() {
        super.onRestart()

    }

    override fun onResume() {
        super.onResume()
/*    SharedPreferenceManager.put(resultList, "KEY_BAG")*/
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStop() {
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager //1
        val networkInfo = connectivityManager.activeNetworkInfo //2
        return networkInfo != null && networkInfo.isConnected //3
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "configuration changed : landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "configuration changed : portrait", Toast.LENGTH_SHORT).show()
        }
    }
}
