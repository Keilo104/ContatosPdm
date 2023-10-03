package br.edu.scl.ifsp.ads.contatospdm.model

import android.content.ContentValues
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import br.edu.scl.ifsp.ads.contatospdm.R
import java.sql.SQLException

class ContactDaoSqlite(context: Context): ContactDao ***REMOVED***
    companion object Constant ***REMOVED***
        private const val CONTACT_DATABASE_FILE = "incredibly_cool_database_TRUST"
        private const val CONTACT_TABLE = "contact"
        private const val ID_COLUMN = "id"
        private const val NAME_COLUMN = "name"
        private const val ADDRESS_COLUMN = "address"
        private const val PHONE_COLUMN = "phone"
        private const val EMAIL_COLUMN = "email"
        private const val CREATE_CONTACT_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS $CONTACT_TABLE (" +
                    "$ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$NAME_COLUMN TEXT NOT NULL, " +
                    "$ADDRESS_COLUMN TEXT NOT NULL, " +
                    "$PHONE_COLUMN TEXT NOT NULL, " +
                    "$EMAIL_COLUMN TEXT NOT NULL " +
                    ");"
***REMOVED***

    private val contactSqliteDatabase: SQLiteDatabase

    init ***REMOVED***
        contactSqliteDatabase =
            context.openOrCreateDatabase(CONTACT_DATABASE_FILE, MODE_PRIVATE, null)

        try ***REMOVED***
            contactSqliteDatabase.execSQL(CREATE_CONTACT_TABLE_STATEMENT)

***REMOVED*** catch(se: SQLException) ***REMOVED***
            Log.e(context.getString(R.string.app_name), se.message.toString())
***REMOVED***
***REMOVED***

    override fun createContact(contact: Contact): Int ***REMOVED***
        val cv = ContentValues()
        cv.put(NAME_COLUMN, contact.name)
        cv.put(ADDRESS_COLUMN, contact.address)
        cv.put(PHONE_COLUMN, contact.phone)
        cv.put(EMAIL_COLUMN, contact.email)

        return contactSqliteDatabase.insert(CONTACT_TABLE, null, cv).toInt()
***REMOVED***

    override fun retrieveContact(id: Int): Contact ***REMOVED***
        TODO("Not yet implemented")
***REMOVED***

    override fun retrieveContacts(): MutableList<Contact> ***REMOVED***
        TODO("Not yet implemented")
***REMOVED***

    override fun updateContact(contact: Contact): Int ***REMOVED***
        TODO("Not yet implemented")
***REMOVED***

    override fun deleteContact(id: Int): Int ***REMOVED***
        TODO("Not yet implemented")
***REMOVED***
***REMOVED***