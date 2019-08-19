package es.kronox.appofthronesj

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val list: RecyclerView = findViewById(R.id.list)
        // list.layoutManager = LinearLayoutManager(this)

        val characters: MutableList<Character> = CharactersRepo.characters
        Log.d("CharactersActivity","${characters.size}")


// OPCIÓN 1: Usando CLASE ANÓNIMA (clase que se comporta como la INTERFACE View.OnClickListener)

        val button1 : Button  = findViewById<Button>(R.id.activity_detail__flipa_button)
        button1.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val toast1 = Toast.makeText(applicationContext, "Pulsado Butón 1", Toast.LENGTH_SHORT)
                toast1.show()
                val intent: Intent = Intent(this@MainActivity, CharactersActivity::class.java)
                startActivity(intent)
            }

        })

// OPCIÓN 2: USANDO LAMBDAS (la lambda recibe como argumento un buttonLambda)

        val buttonLambda : Button = findViewById(R.id.activity_detail__lambda_button)
        buttonLambda.setOnClickListener {
            val toast4 = Toast.makeText(this@MainActivity, "Pulsado Butón Lambda", Toast.LENGTH_SHORT)
            // val toast4 = Toast.makeText(applicationContext, "Pulsado Butón Lambda", Toast.LENGTH_SHORT)      // alternativa a context
            toast4.show()
        }


        /* val buttonLogin : Button  = findViewById<Button>(R.id.activity_detail__login_button)
        val buttonMenus : Button  = findViewById<Button>(R.id.activity_detail__menus_button)

        buttonFlipa.setOnClickListener() { it: View? ->
            Log.d("debug","setONClickLISTENER")
        } */

    }


// OPCIÓN 3: Usando Método OnCLICK en layout

    /* fun show_flipa_activity(button: View) {
        Log.d("debug","button FLIPA")
        val intent : Intent = Intent(this, FlipaActivity::class.java)
        startActivity(intent)
    } */

    fun show_login_activity(button: View) {
        Log.d("debug","button LOGIN")
        val toast2 = Toast.makeText(this, "Pulsado Butón Login", Toast.LENGTH_SHORT)
        toast2.show()
    }

    fun show_flipa_activity(button: View) {
        Log.d("debug","button MENU")
        val toast3 = Toast.makeText(this, "Pulsado Butón Flipa", Toast.LENGTH_LONG)
        toast3.show()
        val intent: Intent = Intent(this, FlipaActivity::class.java)
        startActivity(intent)
    }




}