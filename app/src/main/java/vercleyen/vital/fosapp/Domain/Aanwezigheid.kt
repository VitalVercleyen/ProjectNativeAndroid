package vercleyen.vital.fosapp.Domain


import java.io.Serializable
import java.util.*

data class Aanwezigheid(val Id: Int,
                        val Date: String,
                        var Kids: ArrayList<ScoutsKid>?) : Serializable{


    public fun voegToe(naam : String, gender : String){
        var kid = ScoutsKid(Kids!!.size+ 1, naam, gender,false, false)
        Kids!!.add(kid)
    }
}