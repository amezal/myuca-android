package ni.edu.uca.myuca

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("coordinadores.php")
    suspend fun getCoordinadores(@Query("mayor_a") mayorA: Int): List<Coordinador>
}