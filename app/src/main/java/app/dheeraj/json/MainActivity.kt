package app.dheeraj.json

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
//import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import okhttp3.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {
    val responsearray= arrayListOf<Result>()
    private val pokeapi="https://pokeapi.co/api/v2/pokemon/25"
    private val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val client = OkHttpClient()
        val request =Request.Builder().url(pokeapi).build()
        val call= client.newCall(request)
        call.enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
             e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
            val responseBody : ResponseBody? = response.body()
            val result= responseBody?.string()
            val parsedobject  = gson.fromJson(result,Result::class.java)
                Log.e("tag",parsedobject.species.name)
                responsearray.add(parsedobject)

                runOnUiThread() {
                    val ap = adapter(this@MainActivity, responsearray)
                    rcview.layoutManager = LinearLayoutManager(baseContext)
                    rcview.adapter = ap
                }
//                ap.notifyDataSetChanged()
            }





        })






    }
}
