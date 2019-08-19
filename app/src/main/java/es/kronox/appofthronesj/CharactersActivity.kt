package es.kronox.appofthronesj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast

class CharactersActivity : AppCompatActivity() {

    val list: RecyclerView by lazy {
        val list: RecyclerView = findViewById(R.id.list)
        list.layoutManager = LinearLayoutManager(this)
        list            // lo k devolvemos, similar a return list, que no se usa pq esto no es una función
    }

    val adapter: CharactersAdapter by lazy {
        val adapter = CharactersAdapter() { item, position ->     // lambda a ajecutar con un click
            showDetails(item.id)
        }
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)


        /* Declaración sencilla, ahora hecha con operador LAZY arriba

        val list: RecyclerView = findViewById(R.id.list)
        val adapter = CharactersAdapter() { item, position ->     // lambda a ajecutar con un click
            showDetails()
        } */

        val characters: MutableList<Character> = CharactersRepo.characters
        adapter.setCharacters(characters)

        list.adapter = adapter

    }

    fun showDetails(characterId: String) {

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("key_id", characterId)
        startActivity(intent)
    }





}
