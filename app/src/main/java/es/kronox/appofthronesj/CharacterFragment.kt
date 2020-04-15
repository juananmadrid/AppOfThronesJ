package es.kronox.appofthronesj

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.IllegalArgumentException


class CharacterFragment : Fragment() {

    val list: RecyclerView by lazy {

        val list: RecyclerView = view!!.findViewById(R.id.list)         // view: vista devulta por onCreate
        list.layoutManager = LinearLayoutManager(context)               // !! le decimos a Kotlin k nunca va a ser nula
        list            // lo k devolvemos, similar a return list, que no se usa pq esto no es una función
    }


    val adapter: CharactersAdapter by lazy {
        val adapter = CharactersAdapter() { item, position ->     // lambda a ajecutar con un click
            clickListener.onItemClicked(item)
        }
        adapter
    }

    lateinit var clickListener: OnItemClickListener         // Solo la declaramos y ya la inicialicaremos en algún momento

    // Nos aseguramos de que la actividad es capaz de ejecutar un OnItemClickListener
    override fun onAttach(context: Context?) {              // Primer método que se ejecuta al arrancar un fragment
        super.onAttach(context)

        if (context is OnItemClickListener)                 // Pregunta si la actividad implementa ese interface
            clickListener = context
        else
            throw IllegalArgumentException("Attached activity doesn't implements CharacterFragment.OnItemClickListener")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    // Instanciamos adaptador con los personajes una vez arrancada pantalla
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characters: MutableList<Character> = CharactersRepo.characters  // Cargamos Mutablelist desde el Repositorio
        adapter.setCharacters(characters)                                   // Seteamos el adaptador con la Mutablelist cargada

        list.adapter = adapter                                              // Seteamos el adaptador del RecyclerView con ese adaptador

    }

    interface OnItemClickListener {
        fun onItemClicked(character: Character)
    }


}


