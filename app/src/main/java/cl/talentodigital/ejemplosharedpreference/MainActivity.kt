package cl.talentodigital.ejemplosharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object{
        const val IS_FIRST_OPEN_APP = "is-first-open-app"
    }
    private lateinit var sharedPreferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("primerArchivo", Context.MODE_PRIVATE)
        val primerInicio = sharedPreferences.getBoolean(IS_FIRST_OPEN_APP, true)
        if (primerInicio){
            Toast.makeText(this, "Este es el primer inicio",Toast.LENGTH_LONG).show()
            val editPreferences = sharedPreferences.edit()
            editPreferences.putBoolean(IS_FIRST_OPEN_APP, false)
            editPreferences.apply()

        }
    }
}