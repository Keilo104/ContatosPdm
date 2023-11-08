package br.edu.scl.ifsp.ads.contatospdm.adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.edu.scl.ifsp.ads.contatospdm.R
import br.edu.scl.ifsp.ads.contatospdm.databinding.TileContactBinding
import br.edu.scl.ifsp.ads.contatospdm.model.Contact

class ContactAdapter(context: Context, private val contactList: MutableList<Contact>):
ArrayAdapter<Contact>(context, R.layout.tile_contact, contactList) ***REMOVED***

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View ***REMOVED***
        val contact = contactList[position]

        var contactTileView = convertView
        if(contactTileView == null) ***REMOVED***
            val tcb = TileContactBinding.inflate(
                context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                parent,
                false
            )

            contactTileView = tcb.root

            val tileContactHolder = TileContactHolder(tcb.nameTv, tcb.emailTv)
            contactTileView.tag = tileContactHolder
***REMOVED***

        val holder = contactTileView.tag as TileContactHolder
        holder.nameTv.text = contact.name
        holder.emailTv.text = contact.email

        /* old way of doing it
        tcb?.nameTv?.text = contact.name
        tcb?.emailTv?.text = contact.email
         */
        return contactTileView
***REMOVED***

    private class TileContactHolder(val nameTv: TextView, val emailTv: TextView)
***REMOVED***