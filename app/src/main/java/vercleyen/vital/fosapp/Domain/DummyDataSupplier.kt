package vercleyen.vital.fosapp.Domain

import android.icu.util.LocaleData
import java.text.SimpleDateFormat
import java.time.temporal.TemporalQueries
import java.util.*
import kotlin.collections.ArrayList

class DummyDataSuplier {

    public fun AanwezigheidData() : Aanwezigheid{
        var scoutsKids : ArrayList<ScoutsKid> = ArrayList()
        for(i in 1..10)   {
            var kid = ScoutsKid(i, ("kind" + i), false, false)
            scoutsKids.add(kid)

        }

        val currentDate = Date(System.currentTimeMillis())
        var aanwezigheid = Aanwezigheid(23, currentDate.toString(), scoutsKids)
        return aanwezigheid
    }

    public fun ActiviteitData() : ArrayList<Activiteit>{
        var activiteiten : ArrayList<Activiteit> = ArrayList()
        var activiteit = Activiteit("5/01", "spelletjes")
        activiteiten.add(activiteit)
        activiteit = Activiteit("12/01", "meer spelletjes")
        activiteiten.add(activiteit)
        activiteit = Activiteit("19/01", "nog spelletjes")
        activiteiten.add(activiteit)
        activiteit = Activiteit("26/01", "kleine spelletjes")
        activiteiten.add(activiteit)
        activiteit = Activiteit("02/02", "meer spelletjes")
        activiteiten.add(activiteit)
        activiteit = Activiteit("09/02", "grote spelletjes")
        activiteiten.add(activiteit)
        activiteit = Activiteit("16/02", "jaja spelletjes")
        activiteiten.add(activiteit)
        activiteit = Activiteit("25/02", "verschillende spelletjes")
        activiteiten.add(activiteit)

        return activiteiten
    }
}