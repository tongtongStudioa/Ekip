package org.tongtongStudio.ekip.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "evaluations",
    foreignKeys = [ForeignKey(
        entity = Player::class,
        parentColumns = ["id"],
        childColumns = ["player_id"],
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = TrainingSession::class,
        parentColumns = ["id"],
        childColumns = ["training_session_id"],
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = EvaluationType::class,
        parentColumns = ["id"],
        childColumns = ["evaluation_type_id"],
        onDelete = ForeignKey.SET_NULL
    )]
)
data class Evaluation(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "player_id") val playerId: Int,
    @ColumnInfo(name = "training_session_id") val trainingId: Long,
    @ColumnInfo(name = "evaluation_type_id") val evalTypeId: Long,
    val score: Int, // Échelle de notation, par exemple de 0 à 100
    val evaluatorName: String,
    val remarks: String? = null
)
