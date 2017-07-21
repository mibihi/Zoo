package tutorialspoint7.example.com.zoo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {
    val inflator:LayoutInflater?=null
  var listOfAnimals  = ArrayList<Animal>()
   var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOfAnimals.add(Animal("Baboon","lives in the forest",R.drawable.baboon,false))
        listOfAnimals.add(Animal("Bulldog","lives in the house",R.drawable.bulldog,true))
        listOfAnimals.add(Animal("Panda","lives in the forest",R.drawable.panda,false))
        listOfAnimals.add(Animal("swallow","lives in the sky",R.drawable.swallow_bird,false))
        listOfAnimals.add(Animal("white Tiger","lives in the jungle",R.drawable.white_tiger,true))
        listOfAnimals.add(Animal("Zebra","lives in the savanna",R.drawable.zebra,false))

        adapter= AnimalsAdapter(this,listOfAnimals)
        lv.adapter = adapter
    }
    
    inner class AnimalsAdapter:BaseAdapter{
        var context:Context?=null
        var listOfAnimals=ArrayList<Animal>()
        val inflator:LayoutInflater?=null
        constructor(context:Context,listOfAnimals: ArrayList<Animal>):super(){
        this.listOfAnimals=listOfAnimals
        this.context = context

        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val animal = listOfAnimals[p0]
            if(animal.isKiller!!){
                var myView = inflator!!.inflate(R.layout.animal_killer_ticket, null)
                myView.txtname.text = animal.name
                myView.txtdescription.text = animal.des
                myView.animalimage.setImageResource(animal.image!!)
                myView.animalimage.setOnClickListener {

                    var intent = Intent(context,AnimalInfo::class.java)
                    intent.putExtra("name",animal.name)
                    intent.putExtra("des",animal.des)
                    intent.putExtra("image",animal.image!!)
                    intent.putExtra("iskiller", animal.isKiller!!)
                    context!!.startActivity(intent)
                }
                return myView
            } else {
                var myView = inflator!!.inflate(R.layout.animal_ticket, null)
                myView.txtname.text = animal.name
                myView.txtdescription.text = animal.des
                myView.animalimage.setImageResource(animal.image!!)
                myView.animalimage.setOnClickListener {

                    var intent = Intent(context,AnimalInfo::class.java)
                    intent.putExtra("name",animal.name)
                    intent.putExtra("des",animal.des)
                    intent.putExtra("image",animal.image!!)
                    intent.putExtra("iskiller", animal.isKiller!!)
                    context!!.startActivity(intent)
                }
                return myView
            }


        }
        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }


    }
}
