package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.room.Room
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.dao.GamesDB
import br.senai.sp.jandira.games.databinding.ActivityGamesBinding
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.ui.activity_games

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.idCreateAccount.setOnClickListener(){
            var openSignupActivity = Intent(this,SignupActivity::class.java)

            startActivity(openSignupActivity)
        }
        binding.idButtonLogin.setOnClickListener(){
            login()
        }
//        binding.buttonNextPage.setOnClickListener(){
//            var op = Intent(this, ActivityGames::class.java)
//            startActivity(op)
//        }

    }

    private fun login (){
        if(validate()){
            val email = binding.idInputEmail.text.toString()
            val password = binding.idInputPassword.text.toString()
//            val db =
//
//
//            val email_validate =db.toString("email", "Email não encontrado")
//            val pass_validate = db.("password","Senha não encontrada" )


//            if(email == email_validate && password == pass_validate){
//                val activity_profile = Intent(this, activity_games::class.java)
//                    startActivity(activity_profile)
//            }
//            else{
//                Toast.makeText(this,"Algo deu errado, tente novamente ", Toast.LENGTH_LONG).show()
//            }
        }
    }
    private fun validate():Boolean{
        if(binding.idInputEmail.text.isEmpty()){
            binding.idInputEmail.error = "O email é obrigatório"
            return false
        }
        if(binding.idInputPassword.text.isEmpty()){
            binding.idInputPassword.error = "A senha é obrigatória"
            return false
        }
        return true
    }




}

