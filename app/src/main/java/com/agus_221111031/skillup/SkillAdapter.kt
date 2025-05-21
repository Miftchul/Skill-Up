package com.agus_221111031.skillup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.LayoutRes

class SkillAdapter(
    private val context: Context,
    private val skills: Array<String>
) : ArrayAdapter<String>(context, 0, skills) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_skill, parent, false)
        }

        val skillName = view!!.findViewById<TextView>(R.id.skillName)
        val skillIcon = view.findViewById<ImageView>(R.id.skillIcon)


        skillName.text = skills[position]
        skillIcon.setImageResource(R.drawable.ic_checklist) // pastikan ada gambar icon checklist di drawable

        return view
    }
}
