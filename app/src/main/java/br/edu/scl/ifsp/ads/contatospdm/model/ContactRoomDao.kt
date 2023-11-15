package br.edu.scl.ifsp.ads.contatospdm.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactRoomDao: ContactDao {

    companion object {
        const val CONTACT_DATABASE_FILE = "contacts_room"
        private const val CONTACT_TABLE = "contact"
        private const val ID_COLUMN = "id"
        private const val NAME_COLUMN = "name"
    }

    @Insert
    override fun createContact(contact: Contact)

    @Query("SELECT * FROM $CONTACT_TABLE WHERE $ID_COLUMN = :id")
    override fun retrieveContact(id: Int): Contact?

    @Query("SELECT * FROM $CONTACT_TABLE ORDER BY $NAME_COLUMN")
    override fun retrieveContacts(): MutableList<Contact>

    @Update
    override fun updateContact(contact: Contact): Int

    @Delete
    override fun deleteContact(contact: Contact): Int

}