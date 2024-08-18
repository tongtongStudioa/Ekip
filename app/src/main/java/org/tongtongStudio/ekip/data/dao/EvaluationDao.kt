package org.tongtongStudio.ekip.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.tongtongStudio.ekip.data.entity.Evaluation

@Dao
interface EvaluationDao {
    @Insert
    suspend fun insertEvaluation(Evaluation: Evaluation): Long

    @Query("SELECT * FROM evaluations e JOIN evaluations_type et ON et.id = e.evaluation_type_id WHERE player_id = :playerId AND et.id = :evalType")
    suspend fun getEvaluationForPlayer(playerId: Int, evalType: Long): List<Evaluation>

    @Query("SELECT * FROM evaluations e " +
            "JOIN evaluations_type et ON et.id = evaluation_type_id " +
            "JOIN training_sessions ts ON ts.id = e.training_session_id " +
            "WHERE ts.date = :date")
    suspend fun getEvaluationByDate(date: String): List<Evaluation>
}
