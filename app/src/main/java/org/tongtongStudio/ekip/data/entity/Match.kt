package org.tongtongStudio.ekip.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "match_table",
    foreignKeys = [ForeignKey(
        entity = Group::class,
        parentColumns = ["id"],
        childColumns = ["group_id"],
        onDelete = ForeignKey.SET_NULL
)])
data class Match(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val location: String,
    val date: Long,
    val opponent: String,
    val coachName: String,
    @ColumnInfo(name = "group_id") val groupId: Long
)