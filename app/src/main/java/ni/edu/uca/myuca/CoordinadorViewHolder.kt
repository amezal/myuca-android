package ni.edu.uca.myuca

import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.myuca.databinding.CoordinadorItemBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.Locale

class CoordinadorViewHolder(private val binding: CoordinadorItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(coordinador: Coordinador) {

        val edad = getAge(coordinador.fecha_nacimiento)
        val text = "${coordinador.id} - ${coordinador.titulo} ${coordinador.nombres} ${coordinador.apellidos}, ${edad} años"
        binding.tvCoordinador.text = text
    }

    private fun getAge(birthDateString: String): Int {
        // Parse the birth date string into a LocalDate object
        val birthDate = LocalDate.parse(birthDateString, DateTimeFormatter.ISO_LOCAL_DATE)

        // Calculate the period between the birth date and today's date
        val period = Period.between(birthDate, LocalDate.now())

        // Return the age in years
        return period.years
    }

}