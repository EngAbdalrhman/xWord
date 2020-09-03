package permision.give

import android.app.Activity
import android.content.pm.PackageManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.R
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.widget.Spinner
import java.io.FileReader
import java.io.FileWriter
import kotlin.reflect.KClass

class myTools {
    var currentactivty:Any
    constructor(activty:Activity){
       currentactivty=activty
   }
    constructor(contxt:Context){
        currentactivty=contxt
    }
    fun checkpermissin(pName:String):Boolean{
        return ContextCompat.checkSelfPermission(currentactivty as Context,pName)==PackageManager.PERMISSION_GRANTED
    }
    fun requestpermision(pName:String,requestcode:Int){
      try {

       ActivityCompat.requestPermissions(currentactivty as Activity, arrayOf(pName),requestcode)}
      catch (ex:Exception){
          toastshort(ex.message.toString())
      }
    }
    //some helpful tools
    fun tosatlong(msg:String){
        Toast.makeText(currentactivty as Context,msg,Toast.LENGTH_LONG).show()
    }
    fun toastshort(msg: String){
        Toast.makeText(currentactivty as Context,msg,Toast.LENGTH_SHORT).show()
    }
//spinner
    fun myspinner(spinner:Spinner,items:Array<String>){
val aa=ArrayAdapter(currentactivty as Context, R.layout.simple_spinner_item,items)
    spinner.adapter=aa

}
    //activity
    fun openactive(activty:KClass<*>){
        val i= Intent(currentactivty as Context, activty.java)
        ContextCompat.startActivity(currentactivty as Context,i,null)
    }
    fun openactive4r(activty:KClass<*>,req:Int){
        val i= Intent(currentactivty as Context, activty.java)
   try {//work in activity only
       ActivityCompat.startActivityForResult(currentactivty as Activity ,i,req,null)}
        catch (ex:Exception){
            toastshort(ex.message.toString())
        }
    }

   fun playsound(uri:Int){
      // val mp = MediaPlayer.create(this, R.raw.click)
       MediaPlayer.create(currentactivty as Context, uri).start()
   }
    fun saveFile(path:String,content:String){
        try {
            var fw=FileWriter(path)
            fw.write(content)
            fw.close()
        }
        catch (ex:Exception){
            toastshort(ex.message.toString())

        }
    }
    fun readfile(path: String):String{
        try {
            var fr=FileReader(path)
         var x:Int=0
            var str:String=""
            while (true){
         x=fr.read()
                str +=x.toChar()
                if (x==-1){break}
            }
                 fr.close()
            return str
        }
        catch (ex:Exception){
            toastshort(ex.message.toString())
         return ""
        }
    }

}