package org.tongtongStudio.ekip.data

import org.tongtongStudio.ekip.data.dao.PlayerDao
import org.tongtongStudio.ekip.data.entity.Player
import javax.inject.Inject

class Repository @Inject constructor(
    private val playerDao: PlayerDao
) {

    suspend fun addPlayer(player: Player): Long {
        return playerDao.insertPlayer(player)
    }
}