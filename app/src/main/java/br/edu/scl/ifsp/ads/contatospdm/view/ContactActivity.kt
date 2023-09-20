package br.edu.scl.ifsp.ads.contatospdm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.scl.ifsp.ads.contatospdm.databinding.ActivityContactBinding
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.EXTRA_CONTACT
import br.edu.scl.ifsp.ads.contatospdm.model.Contact
import java.util.Random

class ContactActivity : AppCompatActivity() ***REMOVED***
    private val acb: ActivityContactBinding by lazy ***REMOVED***
        ActivityContactBinding.inflate(layoutInflater)
***REMOVED***

    override fun onCreate(savedInstanceState: Bundle?) ***REMOVED***
        super.onCreate(savedInstanceState)
        setContentView(acb.root)
        with(acb) ***REMOVED***
            saveBt.setOnClickListener ***REMOVED***
                val contact: Contact = Contact(
                    id = generateId(),
                    name = nameEt.text.toString(),
                    address = addressEt.text.toString(),
                    phone = phoneEt.text.toString(),
                    email = emailEt.text.toString()
                )

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_CONTACT, contact)
                setResult(RESULT_OK, resultIntent)
                finish()
    ***REMOVED***
***REMOVED***
***REMOVED***

    private fun generateId(): Int = Random(System.currentTimeMillis()).nextInt()
***REMOVED***