package br.edu.scl.ifsp.ads.contatospdm.controller

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.room.Room
import br.edu.scl.ifsp.ads.contatospdm.model.Contact
import br.edu.scl.ifsp.ads.contatospdm.model.ContactRoomDao
import br.edu.scl.ifsp.ads.contatospdm.model.ContactRoomDao.Companion.CONTACT_DATABASE_FILE
import br.edu.scl.ifsp.ads.contatospdm.model.ContactRoomDaoDatabase
import br.edu.scl.ifsp.ads.contatospdm.view.MainActivity

class ContactRoomController(private val mainActivity: MainActivity) ***REMOVED***
    private val contactDaoImpl: ContactRoomDao by lazy ***REMOVED***
        Room.databaseBuilder(
            mainActivity,
            ContactRoomDaoDatabase::class.java,
            CONTACT_DATABASE_FILE
        ).build().getContactRoomDao()
***REMOVED***

    fun insertContact(contact: Contact) ***REMOVED***
        Thread ***REMOVED***
            contactDaoImpl.createContact(contact)
            getContacts()
***REMOVED***.start()
***REMOVED***

    fun getContact(id: Int) = contactDaoImpl.retrieveContact(id)

    fun getContacts() ***REMOVED***
        object: AsyncTask<Unit, Unit, MutableList<Contact>>() ***REMOVED***
            override fun doInBackground(vararg params: Unit?): MutableList<Contact> ***REMOVED***
                return contactDaoImpl.retrieveContacts()
    ***REMOVED***

            override fun onPostExecute(result: MutableList<Contact>?) ***REMOVED***
                super.onPostExecute(result)
                result?.also ***REMOVED***
                    mainActivity.updateContactList(result)
        ***REMOVED***
    ***REMOVED***
***REMOVED***.execute()
***REMOVED***

    fun editContact(contact: Contact) ***REMOVED***
        Thread ***REMOVED***
            contactDaoImpl.updateContact(contact)
            getContacts()
***REMOVED***.start()
***REMOVED***

    fun removeContact(contact: Contact) ***REMOVED***
        Thread ***REMOVED***
            contactDaoImpl.deleteContact(contact)
            getContacts()
***REMOVED***.start()
***REMOVED***

***REMOVED***