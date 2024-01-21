package vanitar.mdp.gardening_journal_app

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val type: String,
    val wateringFrequency: Int,
    val plantingDate: String
)

