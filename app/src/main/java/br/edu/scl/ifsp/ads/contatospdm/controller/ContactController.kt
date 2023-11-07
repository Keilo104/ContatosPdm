package br.edu.scl.ifsp.ads.contatospdm.controller

import android.os.Message
import androidx.room.Room
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.CONTACT_ARRAY
import br.edu.scl.ifsp.ads.contatospdm.model.Contact
import br.edu.scl.ifsp.ads.contatospdm.model.ContactDao
import br.edu.scl.ifsp.ads.contatospdm.model.ContactDaoSqlite
import br.edu.scl.ifsp.ads.contatospdm.model.ContactRoomDao.Companion.CONTACT_DATABASE_FILE
import br.edu.scl.ifsp.ads.contatospdm.model.ContactRoomDaoDatabase
import br.edu.scl.ifsp.ads.contatospdm.view.MainActivity

class ContactController(private val mainActivity: MainActivity) ***REMOVED***
    private val contactDaoImpl: ContactDao by lazy ***REMOVED***
        /* SqlLite DAO
        ContactDaoSqlite(mainActivity)
        */

        /* Room DAO */
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

    fun getContact(id: Int) ***REMOVED***
        contactDaoImpl.retrieveContact(id)
***REMOVED***

    fun getContacts() ***REMOVED***
        Thread***REMOVED***
            val returnList = contactDaoImpl.retrieveContacts()

            val message = Message()
            message.data.putParcelableArray(
                CONTACT_ARRAY,
                returnList.toTypedArray()
            )

            mainActivity.updateContactListHandler.sendMessage(message)

***REMOVED***.start()
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