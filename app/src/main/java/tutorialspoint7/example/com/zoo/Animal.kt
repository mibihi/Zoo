package tutorialspoint7.example.com.zoo

/**
 * Created by mibihi on 7/19/17.
 */
class Animal {
    var name:String?=null
    var des:String?=null
    var image:Int?=null
    var isKiller:Boolean?=null
    constructor(name:String,des:String,image:Int,isKiller:Boolean){
        this.name=name
        this.des=des
        this.image=image
        this.isKiller=isKiller
    }
}