package vercleyen.vital.fosapp.Domain

import android.icu.util.LocaleData
import java.text.SimpleDateFormat
import java.time.temporal.TemporalQueries
import java.util.*

class DummyDataSuplier {

    public fun AanwezigheidData() : Aanwezigheid{
        var scoutsKids : ArrayList<ScoutsKid> = ArrayList()
        for(i in 1..10)   {
            var kid: ScoutsKid = ScoutsKid(i, ("kind" + i), false, false)
            scoutsKids.add(kid)

        }

        val currentDate = Date(System.currentTimeMillis())
        var aanwezigheid = Aanwezigheid(23, currentDate.toString(), scoutsKids)
        return aanwezigheid
    }


}