package com.example.mycoffeelist

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
// import com.example.mycoffeelist.databinding.ActivityMainBinding

import okhttp3.Headers
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var coffeeList: MutableList<CoffeeData>
    private lateinit var rvCoffee: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var adapter: CoffeeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("coffeeURL", "coffee image URL set")

        rvCoffee = findViewById(R.id.coffee_list)
        coffeeList = mutableListOf()
        searchView = findViewById(R.id.search)
        val searchEditText: EditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text)
        searchEditText.setTextColor(Color.BLUE) // Change the text color to red
        searchEditText.setHintTextColor(Color.GRAY) // Change the hint text color to gray


        // rvCoffee.setHasFixedSize(true)

        getCoffeeImageURL()
        adapter = CoffeeAdapter(coffeeList)
        rvCoffee.adapter = adapter
        rvCoffee.layoutManager = LinearLayoutManager(this@MainActivity)


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        ResourcesCompat.getDrawable(resources , R.drawable.divider , null)?.let{
            dividerItemDecoration.setDrawable((it))
        }
        rvCoffee.addItemDecoration(dividerItemDecoration)

    }

    private fun filterList(query: String?){
        if (query != null) {
            val filteredList = ArrayList<CoffeeData>()
            for (i in coffeeList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }

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
