package com.example.mycoffeelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
// import com.example.mycoffeelist.databinding.ActivityMainBinding

import okhttp3.Headers

class MainActivity : AppCompatActivity() {

    private lateinit var coffeeList: MutableList<CoffeeData>
    private lateinit var rvCoffee: RecyclerView


    // private lateinit var searchView: SearchView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("coffeeURL", "coffee image URL set")

        rvCoffee = findViewById(R.id.coffee_list)
        coffeeList = mutableListOf()

        // searchView = findViewById(R.id.search)

        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        ResourcesCompat.getDrawable(resources , R.drawable.divider , null)?.let{
            dividerItemDecoration.setDrawable((it))
        }
        rvCoffee.addItemDecoration(dividerItemDecoration)

        getCoffeeImageURL()

    }

    private fun getCoffeeImageURL() {
        val client = AsyncHttpClient()

        client["https://api.sampleapis.com/coffee/hot/", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Coffee", "response successful")
                val coffeeArray = json.jsonArray
                Log.d("coffee image link", coffeeArray.getJSONObject(1).getString("image"))

                for (i in 0 until coffeeArray.length()) {
                    val coffeeJson = coffeeArray.getJSONObject(i)
                    val coffee = CoffeeData(
                        coffeeJson.getString("title"),
                        coffeeJson.getString("description"),
                        listOf(coffeeJson.getString("ingredients")).toString(),
                        coffeeJson.getString("image"),
                        coffeeJson.getInt("id")

                    )
                    coffeeList.add(coffee)

                }
                val adapter = CoffeeAdapter(coffeeList)
                rvCoffee.adapter = adapter
                rvCoffee.layoutManager = LinearLayoutManager(this@MainActivity)

            }



            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Coffee Error", errorResponse)
            }
        }]
    }
}
