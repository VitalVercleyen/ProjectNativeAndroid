package vercleyen.vital.fosapp.SharedPreferences


import android.content.Context

class SharedPreferencesClass(val context: Context){

    val PREFERENCE_NAME = "ProjectNativeAnroid"
    val PREFERENCE_TOTEM = "Totem"
    val PREFERENCE_TAK = "Tak"
    val PREFERENCE_FIRSTSTART  = "first"


    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun getTotem() : String{
        return preference.getString(PREFERENCE_TOTEM, "Totemloos")
    }

    fun setTotem(actor: String){
        val editor = preference.edit()
        editor.putString(PREFERENCE_TOTEM, actor)
        editor.apply()
    }

    fun getTak() : String{
        return preference.getString(PREFERENCE_TAK, "Leiding")
    }

    fun setTak(tak: String){
        val editor = preference.edit()
        editor.putString(PREFERENCE_TAK, tak)
        editor.apply()
    }

    fun getFirstStart() : String{
        return preference.getString(PREFERENCE_FIRSTSTART, "0")
    }

    fun setFirstStart(bool : String){
        val editor = preference.edit()
        editor.putString(PREFERENCE_FIRSTSTART, bool)
        editor.apply()
    }

}