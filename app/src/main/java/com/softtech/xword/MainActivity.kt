package com.softtech.xword

import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.Typeface.SANS_SERIF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.Gravity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import permision.give.myTools
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.PrintWriter
import java.lang.Exception
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    fun size(){
        when(spinner.selectedItem.toString()){
            "14"-> editText.textSize=14F
            "16"-> editText.textSize=16F
            "18"-> editText.textSize=18F
            "20"-> editText.textSize=20F
            "22"-> editText.textSize=22F
            "24"-> editText.textSize=24F
            "26"-> editText.textSize=26F
            "28"-> editText.textSize=28F
            "30"-> editText.textSize=30F
            "32"-> editText.textSize=32F
            "34"-> editText.textSize=34F
            "36"-> editText.textSize=36F

        }
    }//end size
    var tf:Typeface = SANS_SERIF
    fun myfont(){
        when(spinner2.selectedItem.toString()){
            "red" ->editText.setTextColor(resources.getColor(R.color.red))
            "green" ->editText.setTextColor(resources.getColor(R.color.green))
            "blue" ->editText.setTextColor(resources.getColor(R.color.blue))
            "black"->editText.setTextColor(resources.getColor(R.color.black))
            "yellow"->editText.setTextColor(resources.getColor(R.color.yellow))
            "gray"->editText.setTextColor(resources.getColor(R.color.gray))
            "orange"->editText.setTextColor(resources.getColor(R.color.orange))
            "pink"->editText.setTextColor(resources.getColor(R.color.pink))
        }
        when(spinner3.selectedItem.toString()){
            "default"->tf= Typeface.SANS_SERIF
            "AdobeClean_Regular"->tf=Typeface.createFromAsset(assets,"AdobeClean_Regular.otf")
            "AdobeDevanagari_Regular"->tf=Typeface.createFromAsset(assets,"AdobeDevanagari_Regular.otf")
            "arial"->tf=Typeface.createFromAsset(assets,"arial.ttf")
            "ariblk"->tf=Typeface.createFromAsset(assets,"ariblk.ttf")
            "BAUHS93"->tf=Typeface.createFromAsset(assets,"BAUHS93.TTF")
            "BERNHC"->tf=Typeface.createFromAsset(assets,"BERNHC.TTF")
            "BRADHITC"->tf=Typeface.createFromAsset(assets,"BRADHITC.TTF")
            "ARIALN"->tf=Typeface.createFromAsset(assets,"ARIALN.TTF")
            "calibriz"->tf=Typeface.createFromAsset(assets,"calibriz.ttf")
            "COOPBL"->tf=Typeface.createFromAsset(assets,"COOPBL.TTF")
            "CURLZ"->tf=Typeface.createFromAsset(assets,"CURLZ.TTF")
        }
        editText.typeface = tf
    }
    fun bold(){
        if (chk_bold.isChecked){
            editText.setTypeface(tf,Typeface.BOLD) //not work
           // tools.toastshort(chk_bold.isChecked.toString())
        }
        else {
            editText.setTypeface(tf,Typeface.NORMAL)
        }
        if (chk_I.isChecked){
            editText.setTypeface(tf,Typeface.ITALIC)
        }
        else {
            editText.setTypeface(tf,Typeface.NORMAL)
        }
        if (chk_bold.isChecked&&chk_I.isChecked){
            editText.setTypeface(tf,Typeface.BOLD_ITALIC)
        }
    }// bold
    var tools=myTools(this)
    var items_1= arrayOf("14","16","18","20","22","24","26","28","30","32","34","36")
    var items_2= arrayOf("black","red","green","blue","yellow","gray","orange","pink")
    var fonts= arrayOf("default","AdobeClean_Regular","AdobeDevanagari_Regular","arial","ariblk","BAUHS93","BERNHC","BRADHITC","ARIALN","calibriz","COOPBL","CURLZ")
    override fun onCreate(savedInstanceState: Bundle?) {
       fun permission() {
        tools.checkpermissin("android.permission.READ_EXTERNAL_STORAGE")
        tools.requestpermision("android.permission.READ_EXTERNAL_STORAGE",404)
           tools.checkpermissin("android.permission.WRITE_EXTERNAL_STORAGE")
           tools.requestpermision("android.permission.WRITE_EXTERNAL_STORAGE",405)
       }
        permission()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tools.myspinner(spinner,items_1)
        tools.myspinner(spinner2,items_2)
        tools.myspinner(spinner3,fonts)
       // var size=spinner.selectedItem.toString() //size 14 all time
        btn_ok.setOnClickListener {
            size()
            if(editText.text.toString()=="Thx to HA"){
                company.text="Abdalrhman Mostafa"
            }
        }//end ok
        btn_ce.setOnClickListener { editText.gravity = Gravity.CENTER_HORIZONTAL }
        btn_l.setOnClickListener { editText.gravity = Gravity.LEFT }
        btn_r.setOnClickListener { editText.gravity = Gravity.RIGHT }
        btn_fc.setOnClickListener {
            myfont()
            chk_bold.isChecked=false
            chk_I.isChecked=false
           // tools.toastshort((tf.toString()==editText.typeface.toString()).toString())
            /* try {
                 if (!(tf.toString()==editText.setTypeface(tf).toString() ||
                   spinner2.selectedItem.toString()==editText.textColors.toString())) {
                     chk_bold.isChecked=false
               chk_I.isChecked=false}}
             catch (ex:Exception){
                 tools.toastshort(ex.toString())
             }*/
        }//end btn

        chk_bold.setOnCheckedChangeListener{ btn,check ->
          if (check){
              editText.setTypeface(tf,Typeface.BOLD)
             if (chk_I.isChecked){ bold()}
          }
            else {
             // editText.setTypeface(null,Typeface.NORMAL)
              bold()
          }
           // bold()
        }
        chk_I.setOnCheckedChangeListener{ btn,check ->
            bold()
            if (chk_bold.isChecked&&!check){editText.setTypeface(tf,Typeface.BOLD) }// الهبد
        }
        chk_u.setOnCheckedChangeListener{ btn,check ->
            if (check){
                editText.paintFlags = Paint.UNDERLINE_TEXT_FLAG
            }
            else {
                editText.paintFlags = Paint.LINEAR_TEXT_FLAG
        }
        }
        btn_c.setOnClickListener {
           editText.text=null
            chk_bold.isChecked=false
            chk_I.isChecked=false
            chk_u.isChecked=false
            spinner.setSelection(0)
            size()
            spinner2.setSelection(0)
            spinner3.setSelection(0)
            myfont()
            editText.gravity = Gravity.LEFT
            fName.text=null
            editText.requestFocus()
            company.text="Sofπech" //R.string.sof_ech.toString()
            // editText.setTypeface(null,Typeface.BOLD)
            //editText.setTypeface(null,Typeface.ITALIC)
           // editText.setTypeface(null,Typeface.NORMAL)
        }
        btn_s.setOnClickListener {
            permission()
            if (editText.text.toString().trim()=="" || fName.text.toString().trim()==""){
         tools.toastshort("it's Empty!")
                editText.requestFocus()
            }
            else {
                try {
          var path=Environment.getExternalStorageDirectory().path+"/xWords"
                var f:File= File(path)
                f.mkdir()
               var pw:PrintWriter= PrintWriter(path+"/"+fName.text.toString()+".doc")
                    pw.write(editText.text.toString())
                    pw.close()
                    tools.toastshort("Saved ^^")
                    var pSet:PrintWriter= PrintWriter(path+"/"+fName.text.toString()+".abg")
                    var sSet:String= spinner.selectedItem.toString() + "\n"+
                            chk_bold.isChecked.toString()+ "\n"+
                            chk_I.isChecked.toString()+ "\n"+
                            chk_u.isChecked.toString()+ "\n"+
                            spinner2.selectedItem.toString() + "\n"+
                            spinner3.selectedItem.toString() + "\n"+
                            btn_ce.isPressed.toString()+ "\n"+
                            btn_l.isPressed.toString()+ "\n"+
                            btn_r.isPressed.toString()+ "\n"
                    pSet.write(sSet)
                    pSet.close()

                }
                catch (ex:Exception){
                    tools.toastshort(ex.toString())
                }
            }
        }
        btn_load.setOnClickListener {
            permission()
            try {
                var mypath=Environment.getExternalStorageDirectory().path+"/xWords/"+fName.text.toString()
                var fr= FileReader(mypath + ".doc")
                var i:Int =0
                var str:String=""
                while (true){
                    i= fr.read()
                    if (i==-1){break}
                    str += i.toChar()
                }
                fr.close()
                editText.setText(str)
                  // get text properts
        /*        var sfr= FileReader(mypath + ".abg")
                var myarr= Array<String>(9){""}
             // var br:BufferedReader=BufferedReader(sfr)
                var x:Int=0
               var line:String=""
              /* var sega = { line = br.readLine() }
                while ( (sega) !=null){
                    line = br.readLine()
                    myarr[x]=line // sega.toString()
                    x++
                }*/
                while (true){
                    x= sfr.read()

                    line +=x.toChar()
                    if (line=="\n"){
                        continue
                    }
                    myarr[x] = line
                    if (x==-1){break}

                }

                sfr.close()
               // br.close()
                editText.textSize=myarr[0].toFloat()
                spinner.setSelection(0)
                chk_bold.isChecked=myarr[1].toBoolean()
                chk_I.isChecked=myarr[2].toBoolean()
                chk_u.isChecked=myarr[3].toBoolean()*/

            }catch (ex:Exception){
                tools.toastshort(ex.toString())
            }
        }
        bclose.setOnClickListener {
            exitProcess(-1)
        }
    }// end on create

}//end class