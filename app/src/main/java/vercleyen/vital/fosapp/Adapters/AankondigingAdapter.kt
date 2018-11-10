package vercleyen.vital.fosapp.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import vercleyen.vital.fosapp.Domain.Aankondiging
import vercleyen.vital.fosapp.R



//This class sets the RecycleViews up incl click listeners
class AankondigingAdapter(private val aankondigingen : ArrayList<Aankondiging>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Gets the items inside the list
    override fun getItemCount(): Int {
        return aankondigingen.size
    }

    //when the viewHolder is created it adds the item to the holder (this happens for all items)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_announcement, parent, false))
    }


    //After the items are added this function calls the bind function
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(aankondigingen[position])
    }

}


