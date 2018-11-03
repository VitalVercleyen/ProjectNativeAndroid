package vercleyen.vital.fosapp.Domain


import java.io.Serializable
import java.util.*

data class Aanwezigheid(val Id: Int,
                        val Date: String,
                        var Kids: ArrayList<ScoutsKid>?) : Serializable{


    public fun voegToe(naam : String, isboy : Boolean){
        var kid = ScoutsKid(Kids!!.size+ 1, naam, if (isboy) "boy" else "girl",false, false)
        Kids!!.add(kid)
    }
}