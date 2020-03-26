package es.kronox.appofthronesj

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder> {
                                               // Hereda de clase interna o aniada

    // Creamos 2 constructores, uno que no detecta clicks y otro que sí y que recibe lambda a ejecutar con click

    constructor() : super() {
        itemClickListener = null
    }

    constructor(itemClickListener: ((Character, Int) -> Unit)) : super() {
        this.itemClickListener = itemClickListener
    }

    private val items = mutableListOf<Character>()         // Abreviado con inferencia de tipos
    // val items : MutableList<Character> = mutableListOf()

    // Lambda a ejecutar cuando haya un click sobre una fila
    private val itemClickListener: ((Character, Int) -> Unit)?


    // 3 Métodos del adapter como interface
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = items[position]          // extraemos contenido
        holder.character = item             // lo insertamos en  viewholder
    }


    // método para añadir elementos a esa instancia local de la colección de datos "items"
    fun setCharacters(characters: MutableList<Character>) {
        items.clear()
        items.addAll(characters)

        notifyDataSetChanged()              // NOTIFICAMOS al Adaptador para recargar toda la lista cada vez k añadamos un nuevo elemento
    }


    // inner class: clase anidada ó clase dentro de otra clase
    // VIEW HOLDER
    inner class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {    // itemView: elemento de una sola fila en una lista

        var character: Character? = null
            // seteamos datos del viewholder
            set(value) {                                                                    // seteamos a la vez que el character toda la información del campo en la vista
                itemView.findViewById<TextView>(R.id.label_name).text = value?.name         // solo ejecuta si value dist. null
                field = value             // character = value
            }

        // Para detectar CLICK añadimos setOnClickListener a itemView
        init {
            itemView.setOnClickListener {
                character?.let {
                    itemClickListener?.invoke(character as Character, adapterPosition)      // Ejecuto lambda enviada desde CharacterActivity
                }
            }

        }

    }


}