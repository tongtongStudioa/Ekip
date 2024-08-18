package org.tongtongStudio.ekip.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.devtools.ksp.symbol.Location

@Entity(
    tableName = "attendance",
    foreignKeys = [ForeignKey(
        entity = Player::class,
        parentColumns = ["id"],
        childColumns = ["player_id"],
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = TrainingSession::class,
        parentColumns = ["id"],
        childColumns = ["training_id"],
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = Match::class,
        parentColumns = ["id"],
        childColumns = ["match_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Attendance(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "training_id") val trainingId: Long?,
    @ColumnInfo(name = "match_id") val matchId: Long?,
    @ColumnInfo(name = "player_id") val playerId: Long,
    val isPresent: Boolean,
    val status: String // Exemples: "Present", "Absent", "Excused"
)

data class PlayerAttendance(
    val date: Long,
    val isPresent: Boolean,
    val status: String,
    val location: String,
    val groupName: String
)