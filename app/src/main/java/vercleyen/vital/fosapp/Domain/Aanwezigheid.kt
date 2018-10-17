package vercleyen.vital.fosapp.Domain


import java.io.Serializable
import java.util.*

data class Aanwezigheid(val Id: Int,
                        val Date: String,
                        var Kids: ArrayList<ScoutsKid>?) : Serializable