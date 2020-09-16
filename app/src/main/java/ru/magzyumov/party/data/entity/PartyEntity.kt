package ru.magzyumov.party.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class PartyEntity(
    var id: String = UUID.randomUUID().toString(),
    var name: String = "Party",
    var picture: String = "",
    var organizer: MemberEntity = MemberEntity(),
    var members: List<MemberEntity> = arrayListOf()

): Parcelable {


}