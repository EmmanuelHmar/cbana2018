package vanmang.com.Control_Page.Schedule;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import vanmang.com.Control_Page.BottomNavigationIntents;
import vanmang.com.Control_Page.R;


public class Qrgenerator extends AppCompatActivity {

    Button generate_QRCode;
    ImageView qrCode;
    EditText mEditText;
    EditText mEditText2;
    EditText mEditText3;
    EditText mEditText4;
    EditText mEditText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
       // View view= inflater.inflate(R.layout.fragment_main, container, false);
        generate_QRCode=(Button) findViewById(R.id.generate_qr);
        qrCode=(ImageView) findViewById(R.id.imageView);
        mEditText=(EditText) findViewById(R.id.editText);
        mEditText2=(EditText) findViewById(R.id.editText2);
        mEditText3=(EditText) findViewById(R.id.editText3);
        mEditText4=(EditText) findViewById(R.id.editText4);
        mEditText5=(EditText) findViewById(R.id.editText5);
        generate_QRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text=mEditText.getText().toString() + "," + mEditText2.getText().toString()+","+
                        mEditText3.getText().toString() + "," + mEditText4.getText().toString()
                        + "," + mEditText5.getText().toString();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    qrCode.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
       // return view;

        //To populate the bottom navigation menu on the layout
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav_Bar);
        new BottomNavigationIntents(this, bottomNavigationView,0);

    }
}