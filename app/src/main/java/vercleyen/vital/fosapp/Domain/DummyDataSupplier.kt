package vercleyen.vital.fosapp.Domain

import java.util.*
import kotlin.collections.ArrayList

class DummyDataSuplier {

    public fun AanwezigheidData() : Aanwezigheid{
        var scoutsKids : ArrayList<ScoutsKid> = ArrayList()
        for(i in 1..10)   {
            var kid = ScoutsKid(i, ("kind" + i), if(i % 2 == 0) "boy" else "girl", false, false)
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


    public fun AankondigingData() : ArrayList<Aankondiging> {
        var aankondigingen : ArrayList<Aankondiging> = ArrayList()
        aankondigingen.add(Aankondiging("Agame","hallo, ik ben agame en ik typ dit voluit"))
        aankondigingen.add(Aankondiging("Insephe","hallo, ik ben Insephe en ik typ dit voluit, ik ben de zus van Agame en ik denk dat deze app goed zal komen, veel succes"))
        aankondigingen.add(Aankondiging("Phylax","ja"))
        aankondigingen.add(Aankondiging("Caprinae","Goeiemorgen"))

        return aankondigingen
    }
}