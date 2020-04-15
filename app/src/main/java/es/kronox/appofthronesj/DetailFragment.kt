package es.kronox.appofthronesj

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    companion object {
        fun newInstance(id: String): DetailFragment {
            val instance = DetailFragment()

            val args = Bundle()                         // creamos el bundel de argumentos para el fragmento
            args.putString("key_id", id)
            instance.arguments = args

            return instance
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString("key_id")
        val character = id?.let { CharactersRepo.findCharacterById(it) }

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
            val toast = Toast.makeText(context, character?.house?.words, Toast.LENGTH_SHORT)
            toast.show()
        }

    }

}

