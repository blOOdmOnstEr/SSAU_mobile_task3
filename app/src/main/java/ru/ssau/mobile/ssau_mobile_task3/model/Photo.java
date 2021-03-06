package ru.ssau.mobile.ssau_mobile_task3.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import ru.ssau.mobile.ssau_mobile_task3.R;

/**
 * Created by Pavel on 14.12.2016.
 */

public class Photo implements Serializable{
    private long id;
    private byte[] image;

    public Photo(){};

    public Photo(long id, byte[] image){
        this.id = id;
        this.image = image;
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public static Bitmap getSmallImage(byte[] image, Context context) {
        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
        options.outHeight = (int) context.getResources().getDimension(R.dimen.photo_size);
        options.outWidth = (int) context.getResources().getDimension(R.dimen.photo_size);
        options.inSampleSize = 16;
        options.inScaled = true;
        return BitmapFactory.decodeByteArray(image, 0, image.length, options);
    }
}
