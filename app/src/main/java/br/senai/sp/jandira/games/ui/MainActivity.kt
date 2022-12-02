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


    }

    private fun login (){
        if(validate()){
            val email = binding.idInputEmail.text.toString()
            val password = binding.idInputPassword.text.toString()

        }
    }
    private fun validate():Boolean{
        if(binding.idInputEmail.text.isEmpty()){
            binding.idInputEmail.error = "O email é obrigatório!"
            return false
        }
        if(binding.idInputPassword.text.isEmpty()){
            binding.idInputPassword.error = "A senha é obrigatória!"
            return false
        }
        return true
    }




}

