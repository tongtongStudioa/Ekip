package org.tongtongStudio.ekip.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "injuries",
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
        entity = Match::class,
        parentColumns = ["id"],
        childColumns = ["match_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Injury(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "player_id") val playerId: Int,
    @ColumnInfo(name = "training_session_id") val trainingId: Long?,
    @ColumnInfo(name = "match_id") val matchId: Long?,
    val type: String, // Échelle de notation, par exemple de 0 à 100
    val recoveryTime: Int, // En nombre de jours
    val notes: String? = null
)