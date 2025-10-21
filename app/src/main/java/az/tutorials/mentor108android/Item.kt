package az.tutorials.mentor108android

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val title: String,
    val desc: String,
    val image: Int,
    val isSelected: Boolean
): Parcelable