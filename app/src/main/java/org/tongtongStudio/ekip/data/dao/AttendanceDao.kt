package org.tongtongStudio.ekip.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import org.tongtongStudio.ekip.data.entity.Attendance
import org.tongtongStudio.ekip.data.entity.Player
import org.tongtongStudio.ekip.data.entity.PlayerAttendance

@Dao
interface AttendanceDao {
    @Insert
    suspend fun insertAttendance(attendance: Attendance): Long

    // TODO: Separate query for match
    @Query("SELECT ts.date, a.isPresent, a.status, ts.location, lg.name as groupName FROM attendance a " +
            "JOIN players p ON p.id = a.player_id " +
            "JOIN training_sessions ts ON ts.id = a.training_id " +
            "JOIN level_groups lg ON p.group_id = lg.id " +
            "WHERE player_id = :playerId")
    suspend fun getAttendanceTrainingForPlayer(playerId: Int): List<PlayerAttendance>

    @Transaction
    @Query("SELECT p.* , a.isPresent, a.status  FROM attendance a " +
            "JOIN training_sessions ts ON ts.id = a.training_id " +
            "JOIN players p ON p.id = a.player_id " +
            "WHERE ts.id = :tsId")
    fun getAttendanceForTrainingSession(tsId: Long): Flow<List<Player>>
}

