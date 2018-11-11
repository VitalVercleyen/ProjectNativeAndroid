package vercleyen.vital.fosapp.Adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.list_item_activiteit.view.*
import kotlinx.android.synthetic.main.list_item_announcement.view.*
import kotlinx.android.synthetic.main.list_item_scoutskid.view.*
import vercleyen.vital.fosapp.Domain.Activiteit
import vercleyen.vital.fosapp.Domain.Aankondiging
import vercleyen.vital.fosapp.Domain.ScoutsKid
import vercleyen.vital.fosapp.R

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    //Gets run after the viewholder is made, this adds data to the fields
    private var genderMap : HashMap<String, Int> = hashMapOf("boy" to R.drawable.boy, "girl" to R.drawable.girl,"x" to R.drawable.xgender)
    fun bind(scoutsKid: ScoutsKid, itemClickListener: (ScoutsKid) -> Unit, aanwClickListener: (ScoutsKid) -> Unit,  vierClickListener: (ScoutsKid) -> Unit) {
        itemView.tv_ScoutsKidName.text = scoutsKid.Name
        itemView.cb_Aanwezig.isChecked = scoutsKid.Aanwezig
        itemView.cb_vieruurtje.isChecked = scoutsKid.VierUurtje
        itemView.cb_Aanwezig.setOnClickListener { aanwClickListener(scoutsKid) }
        itemView.cb_vieruurtje.setOnClickListener { vierClickListener(scoutsKid) }
        itemView.setOnClickListener{itemClickListener(scoutsKid)}
        itemView.imageView.setImageResource(genderMap[scoutsKid.gender]!!)
    }

    fun bind(activiteit : Activiteit, clickListener: (Activiteit) -> Unit){
        itemView.tv_date.text = activiteit.date
        itemView.tv_activiteit.text = activiteit.name
        itemView.setOnClickListener{clickListener(activiteit)}
    }

    fun bind(aankondiging : Aankondiging){
        itemView.tv_sender.text = aankondiging.sender
        itemView.tv_message.text = aankondiging.message
    }

}
