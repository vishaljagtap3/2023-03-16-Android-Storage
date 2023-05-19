package com.bitcodetech.storage

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //External storage
        val state = Environment.getExternalStorageState()
        when {
            state.equals(Environment.MEDIA_MOUNTED) ->
                mt("Ext storage is RW")
            else ->
                mt("Ext storage no available")
        }

        mt("emulated? ${Environment.isExternalStorageEmulated()}")

        val extRootDir : File = Environment.getExternalStorageDirectory()
        mt("Ext root dir: ${extRootDir.absolutePath}")

        val bitcodeDir = File(extRootDir, "bitcode")
        if(!bitcodeDir.exists()) {
            mt("dir created " + bitcodeDir.mkdir())
        }

        val appExtDir = getExternalFilesDir(null) //root dir
        mt("App ext storage dir: ${appExtDir!!.absolutePath}")
        val bitcodeDir1 = File(appExtDir, "bitcode")
        if(!bitcodeDir1.exists()) {
            mt("app ext dir created " + bitcodeDir1.mkdir())
        }

        val extAppMovies = getExternalFilesDir(Environment.DIRECTORY_MOVIES)
        mt("Ext app movies dir: ${extAppMovies!!.absolutePath}")


        val extDocs = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        mt("ext  docs: ${extDocs.absolutePath}")

        val extAppCache = externalCacheDir
        mt("Ext app cache dir: ${extAppCache!!.absolutePath}")


        //internal storage 2
        //getFilesDir() returns the File object representing the files root directory representing your app
        /*mt(filesDir.absolutePath)
        mt(cacheDir.absolutePath)*/


        //internal storage 1
        /*val fout : FileOutputStream =
            openFileOutput("my_file1.txt", Activity.MODE_PRIVATE or Activity.MODE_APPEND)
        fout.write("this is sample string".toByteArray())
        fout.close()

        val fin : FileInputStream = openFileInput("my_file1.txt")
        val data = ByteArray(200)
        val count = fin.read(data)
        fin.close()
        mt( String(data, 0, count) )

        //deleteFile("my_file1.txt")
        val dir = getDir("bitcode", Activity.MODE_PRIVATE)*/


        /*Settings.setBgColor(this, "Black")
        mt(Settings.getBgColor(this))

        val prefs: SharedPreferences =
            getSharedPreferences("my_prefs", Activity.MODE_PRIVATE)

        var editor: SharedPreferences.Editor = prefs.edit()
        editor.putString("name", "BitCode")
        editor.putInt("code", 101)
        editor.commit()

        var code = prefs.getInt("code", -1)
        var name = prefs.getString("name", "Not Available")

        mt("$name $code")

        val newPrefs = getPreferences(Activity.MODE_PRIVATE)
        editor = newPrefs.edit()
        editor.putString("name", "BitCode")
        editor.putInt("code", 101)
        editor.commit()

        code = newPrefs.getInt("code", -1)
        name = newPrefs.getString("name", "Not Available")

        mt("$name $code")*/

    }

    private fun mt(text: String) {
        Log.e("tag", text)
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}