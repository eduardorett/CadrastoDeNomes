package com.devedu.cadrastodenomes.views.viewHolder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devedu.cadrastodenomes.views.Listener.NomesListener
import com.devedu.cadrastodenomes.R
import com.devedu.cadrastodenomes.room.NomesEntity


class NomesViewHolder(itemView: View, private val listener: NomesListener) :
    RecyclerView.ViewHolder(itemView) {
  fun bind(guest: NomesEntity) {

    val textName = itemView.findViewById<TextView>(R.id.text_name)


        textName.text = guest.nome

        // Atribui eventos
        textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        // Atribui eventos
        textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNeutralButton(R.string.cancelar, null)
                .show()

            true
        }

    }
}