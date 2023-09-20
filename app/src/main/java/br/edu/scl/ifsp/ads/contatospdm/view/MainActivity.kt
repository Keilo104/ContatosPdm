package br.edu.scl.ifsp.ads.contatospdm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import br.edu.scl.ifsp.ads.contatospdm.R
import br.edu.scl.ifsp.ads.contatospdm.databinding.ActivityMainBinding
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.EXTRA_CONTACT
import br.edu.scl.ifsp.ads.contatospdm.model.Contact

class MainActivity : AppCompatActivity() ***REMOVED***
    private val amb: ActivityMainBinding by lazy ***REMOVED***
        ActivityMainBinding.inflate(layoutInflater)
***REMOVED***
    // Data Source
    private val contactList: MutableList<Contact> = mutableListOf()

    // Adapter
    private val contactAdapter: ArrayAdapter<String> by lazy ***REMOVED***
        ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            contactList.map ***REMOVED*** contact ->
                contact.name
    ***REMOVED***
        )
***REMOVED***

    private lateinit var carl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) ***REMOVED***
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        //fillContacts()
        amb.contatosLv.adapter = contactAdapter

        carl = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) ***REMOVED*** result ->
            if (result.resultCode == RESULT_OK) ***REMOVED***
                val contact = result.data?.getParcelableExtra<Contact>(EXTRA_CONTACT)
                contact?.let ***REMOVED*** _contact ->
                    contactList.add(_contact)
                    contactAdapter.add(_contact.name)
                    contactAdapter.notifyDataSetChanged()
        ***REMOVED***
    ***REMOVED***
***REMOVED***
***REMOVED***

    override fun onCreateOptionsMenu(menu: Menu?): Boolean ***REMOVED***
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
***REMOVED***

    override fun onOptionsItemSelected(item: MenuItem): Boolean ***REMOVED***
        return when(item.itemId) ***REMOVED***
            R.id.addContactMi -> ***REMOVED***
                carl.launch(Intent(this, ContactActivity::class.java))
                true
    ***REMOVED***
            else -> false
***REMOVED***
***REMOVED***

    private fun fillContacts() ***REMOVED***
        for (i in 1..50) ***REMOVED***
            contactList.add(
                Contact(
                    i,
                    "Nome $i",
                    "Endereço $i",
                    "Telefone $i",
                    "email $i"
                )
            )
***REMOVED***
***REMOVED***
***REMOVED***