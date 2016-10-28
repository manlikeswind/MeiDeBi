package com.sunshine.cl.meidebi.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;

public class PicassoUtils {
    /**
     * Picasso加载本地图片
     * @param context
     * @param url
     * @param img
     */
    public static void setAvatarImg(Context context, String url, ImageView img) {
        Picasso.with(context)
                .load(url)
                .placeholder(R.mipmap.iv_no_avantar)
                .error(R.mipmap.iv_no_avantar)
                .fit()
                .config(Bitmap.Config.RGB_565)
                .into(img);
    }
}
