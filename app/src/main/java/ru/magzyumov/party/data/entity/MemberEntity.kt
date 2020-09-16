package ru.magzyumov.party.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class MemberEntity (
    var id: String = UUID.randomUUID().toString(),
    var name: String = "",
    var avatar: String = ""

): Parcelable {


}