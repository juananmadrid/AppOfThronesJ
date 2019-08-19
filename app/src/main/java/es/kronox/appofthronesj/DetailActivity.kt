package es.kronox.appofthronesj

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_detail.*     // Kotlin extensions

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getStringExtra("key_id")
        val character = CharactersRepo.findCharacterById(id)

        character?.let{
            with(character) {
                labelName.text = name
                labelTitle.text = title
                labelActor.text = actor
                labelBorn.text = born
                labelParents.text = "${father} & ${mother}"         // interpolación de cadenas
                labelQuote.text = quote
                labelSpouse.text = spouse
                buttonHouse.text = house.name
            }
            // labelName.text = character.name                      // forma clásica, sin witch
        }


        buttonHouse.setOnClickListener {
            val toast = Toast.makeText(this@DetailActivity, character?.house?.words, Toast.LENGTH_SHORT)
            toast.show()
        }


    }
}
