package ni.edu.uca.myuca

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.myuca.databinding.CoordinadorItemBinding

class CoordinadorAdapter(private val coordinadores: List<Coordinador>) : RecyclerView.Adapter<CoordinadorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordinadorViewHolder {
        val binding = CoordinadorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoordinadorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoordinadorViewHolder, position: Int) {
        val coordinador = coordinadores[position]
        holder.bind(coordinador)
    }

    override fun getItemCount() = coordinadores.size
}