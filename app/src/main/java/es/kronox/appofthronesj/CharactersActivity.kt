package es.kronox.appofthronesj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.FrameLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_characters.*  // para acceder a la vista sin findview...

class CharactersActivity : AppCompatActivity(), CharacterFragment.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        if (savedInstanceState == null){
            val fragment = CharacterFragment()
            this.supportFragmentManager
                .beginTransaction()
                .add(R.id.listContainer, fragment)     // En vista "listContainer" insertamos "fragment
                .commit()
        }
    }

    override fun onItemClicked(character: Character) {

        if (isDetailViewAvailable())
            showFragmentDetails(character.id)
        else
            launchDetailActivity(character.id)
    }

    // fun isDetailViewAvailable() = findViewById<FrameLayout>(R.id.detailContainer) != null
    fun isDetailViewAvailable() = detailContainer != null

    private fun showFragmentDetails(characterId: String) {
        val detailFragment = DetailFragment.newInstance(characterId)       // instanciamos el fragmento

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.detailContainer, detailFragment)  // Replace reemplaza si hay un detailFragment mostrado
            .commit()
    }

    private fun launchDetailActivity(characterId: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("key_id", characterId)
        startActivity(intent)
    }






/* Para comprobar ciclo de vida de actividad
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

*/


}
