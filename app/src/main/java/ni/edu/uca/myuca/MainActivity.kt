package ni.edu.uca.myuca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.myuca.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.200/api/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    val apiService = retrofit.create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.rvCoordinadores

        recyclerView.layoutManager = LinearLayoutManager(this)


        val scope = CoroutineScope(Dispatchers.Main)

        scope.launch {
            try {
                val coordinadores: List<Coordinador> = apiService.getCoordinadores(60)
                val adapter = CoordinadorAdapter(coordinadores)
                recyclerView.adapter = adapter
            } catch(error: Error) {
                Log.d("myuca", error.message.toString());
            }
        }
    }
}