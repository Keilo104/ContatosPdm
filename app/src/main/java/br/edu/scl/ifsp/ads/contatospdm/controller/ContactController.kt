package br.edu.scl.ifsp.ads.contatospdm.controller

import android.os.Message
import androidx.room.Room
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.CONTACT_ARRAY
import br.edu.scl.ifsp.ads.contatospdm.model.Contact
import br.edu.scl.ifsp.ads.contatospdm.model.ContactDao
import br.edu.scl.ifsp.ads.contatospdm.model.ContactDaoRtDbFb
import br.edu.scl.ifsp.ads.contatospdm.model.ContactDaoSqlite
import br.edu.scl.ifsp.ads.contatospdm.model.ContactRoomDao.Companion.CONTACT_DATABASE_FILE
import br.edu.scl.ifsp.ads.contatospdm.model.ContactRoomDaoDatabase
import br.edu.scl.ifsp.ads.contatospdm.view.MainActivity

class ContactController(private val mainActivity: MainActivity) {
    private val contactDaoImpl: ContactDao by lazy {
        // SqlLite DAO
        ContactDaoSqlite(mainActivity)

        // Room DAO
        Room.databaseBuilder(
            mainActivity,
            ContactRoomDaoDatabase::class.java,
            CONTACT_DATABASE_FILE
        ).build().getContactRoomDao()

        // Realtime Database Firebase DAO
        ContactDaoRtDbFb()
    }

    fun insertContact(contact: Contact) {
        Thread {
            contactDaoImpl.createContact(contact)
        }.start()
    }

    fun getContact(id: Int) {
        contactDaoImpl.retrieveContact(id)
    }

    fun getContacts() {
        Thread{
            val returnList = contactDaoImpl.retrieveContacts()

            val message = Message()
            message.data.putParcelableArray(
                CONTACT_ARRAY,
                returnList.toTypedArray()
            )

            mainActivity.updateContactListHandler.sendMessage(message)

        }.start()
    }

    fun editContact(contact: Contact) {
        Thread {
            contactDaoImpl.updateContact(contact)
        }.start()
    }

    fun removeContact(contact: Contact) {
        Thread {
            contactDaoImpl.deleteContact(contact)
        }.start()
    }
}