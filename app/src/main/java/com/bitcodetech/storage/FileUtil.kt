package com.bitcodetech.storage

import android.content.Context
import java.io.File
import java.io.FileOutputStream

object FileUtil {


    fun createTempFile(context: Context, fileName: String) : Boolean {
        /*val tempDir = File(context.filesDir, "temp")
        if(!tempDir.exists()) {
            tempDir.mkdir()
        }
        val tempFile = File(tempDir, fileName)
        */
        val tempFile = File(context.cacheDir, fileName)
        if(tempFile.exists()) {
            return false
        }

        return tempFile.createNewFile()
    }


    fun createFileAndWriteData(context: Context, fileName : String, data : ByteArray) : Boolean{

        val newFile = File(context.filesDir, fileName)

        if(newFile.exists()) {
            return false
        }

        if( !newFile.createNewFile() ) {
            return false
        }

        val fout = FileOutputStream(newFile)
        fout.write(data)
        fout.close()

        return true
    }

}