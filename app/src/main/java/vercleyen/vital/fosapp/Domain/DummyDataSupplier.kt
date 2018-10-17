package vercleyen.vital.fosapp.Domain

import java.text.SimpleDateFormat
import java.util.*

class DummyDataSuplier {

    public fun AanwezigheidData() : Aanwezigheid{
        var scoutsKids : ArrayList<ScoutsKid> = ArrayList()
        for(i in 1..10)   {
            var kid: ScoutsKid = ScoutsKid(i, ("kind" + i), false, false)
            scoutsKids.add(kid)

        }

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        var aanwezigheid : Aanwezigheid = Aanwezigheid(23, currentDate, scoutsKids)
        return aanwezigheid
    }


}