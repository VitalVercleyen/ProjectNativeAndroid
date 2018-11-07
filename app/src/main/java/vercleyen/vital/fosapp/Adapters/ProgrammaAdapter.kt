package vercleyen.vital.fosapp.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_scoutskid.view.*
import vercleyen.vital.fosapp.Domain.Activiteit
import vercleyen.vital.fosapp.Domain.ScoutsKid
import vercleyen.vital.fosapp.R

//This class sets the RecycleViews up incl click listeners
class ProgrammaAdapter(private val programma : ArrayList<Activiteit>, private val clickListener: (Activiteit) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Gets the items inside the list
    override fun getItemCount(): Int {
        return programma.size + 1
    }

    //when the viewHolder is created it adds the item to the holder (this happens for all items)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_activiteit, parent, false))
    }


    //After the items are added this function calls the bind function
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(programma[position], clickListener)
    }

}

//Subclass where the viewholder is defined

