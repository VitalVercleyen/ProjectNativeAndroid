package vercleyen.vital.fosapp.Adapters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_scoutskid.view.*
import vercleyen.vital.fosapp.Domain.ScoutsKid
import vercleyen.vital.fosapp.R

//This class sets the RecycleViews up incl click listeners
class ScoutsKidAdapter(private val scoutsKidLijst : ArrayList<ScoutsKid>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Gets the items inside the list
    override fun getItemCount(): Int {
        return scoutsKidLijst.size
    }

    //when the viewHolder is created it adds the item to the holder (this happens for all items)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_scoutskid, parent, false))
    }


    //After the items are added this function calls the bind function
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(scoutsKidLijst[position])
    }

}

//Subclass where the viewholder is defined
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    //Gets run after the viewholder is made, this adds data to the fields


    fun bind(scoutsKid: ScoutsKid) {
        itemView.tv_ScoutsKidName.text = scoutsKid.Name
        itemView.cb_Aanwezig.isChecked = scoutsKid.Aanwezig
        itemView.cb_vieruurtje.isChecked = scoutsKid.VierUurtje
    }

}
