package tutorialspoint7.example.com.zoo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class AnimalInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        val bundle:Bundle = intent.extras
        val name = bundle.getString("name")
        val des  = bundle.getString("des")
        val image= bundle.getInt("image")


        imgdtl.setImageResource(image)
        txtname.text=name
        txtdes.text = des
    }
}
