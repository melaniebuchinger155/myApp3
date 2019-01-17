package buchinger.melanie.myapp3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends Activity {

    ImageView imageView;
    Button picturebutton;
    Button photobutton;

    final int requcode = 1;
    Uri bilduri;
    InputStream is;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button picturebutton  = (Button) findViewById(R.id.picturebutton);
        imageView = (ImageView) findViewById(R.id.photoframe);


        picturebutton.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View view)


            {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, requcode);
            }

        });





        Button photobutton  = (Button) findViewById(R.id.photobutton);
        imageView = (ImageView) findViewById(R.id.photoframe);


        photobutton.setOnClickListener (new View.OnClickListener()

        {@Override
        public void onClick (View view) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,0);

        }

        } );
    }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data) {
            if (resultCode == RESULT_OK) {
                if (requestCode == requestCode) {


                    bilduri = data.getData();
                    try {
                        is = getContentResolver().openInputStream(bilduri);
                        bitmap = BitmapFactory.decodeStream(is);
                        imageView.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                }


            }
            super.onActivityResult(requestCode, resultCode, data);

        }


}


