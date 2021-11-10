package uz.umarxon.qrcodegenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun create(view: android.view.View) {

        val barcodeEncoder = BarcodeEncoder()
        val multiFormatWriter = MultiFormatWriter()

        val text = edt.text.toString()
        val type1 = BarcodeFormat.QR_CODE
        val type2 = BarcodeFormat.CODE_128
        val size = 500

        try {
            setImage(rv_image,barcodeEncoder,multiFormatWriter,text,type1,size)
            setImage(rv_image1,barcodeEncoder,multiFormatWriter,text,type2,size)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun setImage(i: ImageView, b: BarcodeEncoder,m:MultiFormatWriter,text:String,type:BarcodeFormat,s:Int){
        i.setImageBitmap(b.createBitmap(m.encode(text,type,s,s)))
    }
}