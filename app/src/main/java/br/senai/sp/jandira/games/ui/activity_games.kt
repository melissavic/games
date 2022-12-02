package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.dao.GamesDAO
import br.senai.sp.jandira.games.databinding.ActivityGamesBinding

class activity_games : AppCompatActivity() {


    private lateinit var binding: ActivityGamesBinding
    lateinit var rvGames: RecyclerView
    lateinit var adapterGame: GamesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        binding = ActivityGamesBinding.inflate(layoutInflater)
        rvGames = binding.rvGames
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,)
        adapterGame = GamesAdapter(this)
        adapterGame.updateGamesList(GamesDAO.getGame(this))
        setContentView(binding.root)
        supportActionBar!!.hide()
        rvGames.adapter = GamesAdapter


    }
}
    private fun LinearLayoutManager(activityGames: activity_games, vertical: Int): RecyclerView.LayoutManager? {

    }

