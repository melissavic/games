package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.GamesRepository
import com.google.android.material.slider.Slider
import java.util.*

class SignupActivity : AppCompatActivity() {
    lateinit var editName:EditText
    lateinit var editEmail:EditText
    lateinit var editPassword:EditText
    lateinit var editCity:EditText
    lateinit var editBirthDate:EditText
    lateinit var slider_gamer: Slider
    lateinit var spinnerGamerLevel:Spinner
    lateinit var checkboxMale:CheckBox
    lateinit var checkboxFemale:CheckBox
    private var id = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)
        supportActionBar!!.show()
        supportActionBar!!.title = "Games"

        editName = findViewById(R.id.edit_name)
        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
        editCity = findViewById(R.id.edit_city)
        editBirthDate = findViewById(R.id.edit_birth_date)
        spinnerGamerLevel =findViewById(R.id.spinner_console)
        slider_gamer = findViewById(R.id.slider_gamer)
        checkboxFemale = findViewById(R.id.checkbox_female)
        checkboxMale = findViewById(R.id.checkBox_male)

        spinnerGamerLevel.adapter


    }
    private fun saveUser(){

        val user = User()

        user.id = 1
        user.nome = editName.text.toString()
        user.email = editEmail.text.toString()
        user.senha = editPassword.text.toString()
        user.cidade = editCity.text.toString()

        var GamesRepository = GamesRepository(this)

        if(id>0){
            user.id = id
            GamesRepository.saveUser(user)
        }
        else{
            val id = GamesRepository.saveUser(user)
        }

        Toast.makeText(this,"ID : $id", Toast.LENGTH_LONG).show()

        finish()


//        val dados = getSharedPreferences("dados", MODE_PRIVATE)
//
//        val editor = dados.edit()
//
//        editor.putInt("id", user.id)
//        editor.putString("nome",user.nome)
//        editor.putString("email", user.email)
//        editor.putString("senha", user.senha)
//        editor.putString("cidade", user.cidade)
//
//        if (editor.commit()){
//            Toast.makeText(this, "O registro do usuário foi bem sucedido", Toast.LENGTH_SHORT).show()
//            finish()
//        }
//        else{
//            Toast.makeText(this, "Erro no registro", Toast.LENGTH_SHORT).show()
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_save) {
            saveUser()
        }
        else if(item.itemId == R.id.menu_settings) {
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
                return true
            }
        else{

            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            return true
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true

    }
}