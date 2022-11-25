package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.*
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.User


@Dao
interface GamesDAO {

    @Insert
    fun save(context: Game): Long

    @Insert
    fun save (context: User): Long

    @Delete
    fun delete(context:Game): Int

    @Update
    fun update(context: Game): Int

    @Query("SELECT * FROM TBL_GAMES order by nome " ) fun getAll(): List <Game>

    @Query("SELECT * FROM TBL_GAMES WHERE id = :id") fun getGameById(id:Int) : Game
}