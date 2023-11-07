package br.edu.scl.ifsp.ads.contatospdm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import br.edu.scl.ifsp.ads.contatospdm.R
import br.edu.scl.ifsp.ads.contatospdm.adapter.ContactAdapter
import br.edu.scl.ifsp.ads.contatospdm.controller.ContactController
import br.edu.scl.ifsp.ads.contatospdm.databinding.ActivityMainBinding
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.CONTACT_ARRAY
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.EXTRA_CONTACT
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.VIEW_CONTACT
import br.edu.scl.ifsp.ads.contatospdm.model.Contact

class MainActivity : AppCompatActivity() ***REMOVED***
    private val amb: ActivityMainBinding by lazy ***REMOVED***
        ActivityMainBinding.inflate(layoutInflater)
***REMOVED***
    // Data Source
    private val contactList: MutableList<Contact> = mutableListOf()

    // Controller
    private val contactController: ContactController by lazy ***REMOVED***
        ContactController(this)
***REMOVED***

    // Adapter
    private val contactAdapter: ContactAdapter by lazy ***REMOVED***
        ContactAdapter(
            this,
            contactList
        )
***REMOVED***

    // Handler
    val updateContactListHandler = object: Handler(Looper.getMainLooper()) ***REMOVED***
        override fun handleMessage(msg: Message) ***REMOVED***
            super.handleMessage(msg)
            msg.data.getParcelableArray(CONTACT_ARRAY)?.also ***REMOVED*** contactArray ->
                contactList.clear()
                contactArray.forEach ***REMOVED***
                    contactList.add(it as Contact)
        ***REMOVED***
                contactAdapter.notifyDataSetChanged()
    ***REMOVED***
***REMOVED***
***REMOVED***

    private lateinit var carl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) ***REMOVED***
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        setSupportActionBar(amb.toolbarIn.toolbar)

        //fillContacts()
        amb.contatosLv.adapter = contactAdapter

        carl = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) ***REMOVED*** result ->
            if (result.resultCode == RESULT_OK) ***REMOVED***
                val contact = result.data?.getParcelableExtra<Contact>(EXTRA_CONTACT)
                contact?.let ***REMOVED*** _contact ->
                    if(contactList.any ***REMOVED*** it.id == contact.id ***REMOVED***) ***REMOVED***
                        contactController.editContact(_contact)
            ***REMOVED*** else ***REMOVED***
                        contactController.insertContact(_contact)
            ***REMOVED***
        ***REMOVED***
    ***REMOVED***
***REMOVED***

        amb.contatosLv.setOnItemClickListener ***REMOVED*** _, _, position, _ ->
            val contact = contactList[position]
            val viewContactIntent = Intent(this, ContactActivity::class.java)
                .putExtra(EXTRA_CONTACT, contact)
                .putExtra(VIEW_CONTACT, true)

            startActivity(viewContactIntent)
***REMOVED***

        registerForContextMenu(amb.contatosLv)
        contactController.getContacts()
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

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) ***REMOVED***
        menuInflater.inflate(R.menu.context_menu_main, menu)
***REMOVED***

    override fun onContextItemSelected(item: MenuItem): Boolean ***REMOVED***
        val position = (item.menuInfo as AdapterView.AdapterContextMenuInfo).position
        val contact = contactList[position]

        return when (item.itemId)***REMOVED***
            R.id.removeContactMi -> ***REMOVED***
                contactController.removeContact(contact)
                Toast.makeText(this,"Removido", Toast.LENGTH_SHORT).show()
                true
    ***REMOVED***
            R.id.editContactMo -> ***REMOVED***
                val _contact = contactList[position]
                val editContactIntent = Intent(this, ContactActivity::class.java)
                editContactIntent.putExtra(EXTRA_CONTACT, _contact)
                carl.launch(editContactIntent)
                true
    ***REMOVED***
            else -> ***REMOVED***true***REMOVED***
***REMOVED***
***REMOVED***

    override fun onDestroy() ***REMOVED***
        super.onDestroy()
        unregisterForContextMenu(amb.contatosLv)
***REMOVED***

    private fun fillContacts() ***REMOVED***
        for (i in 1..50) ***REMOVED***
            contactList.add(
                Contact(
                    i,
                    "Nome $i",
                    "Endereço $i",
                    "Telefone $i",
                    "Email $i"
                )
            )
***REMOVED***
***REMOVED***
***REMOVED***