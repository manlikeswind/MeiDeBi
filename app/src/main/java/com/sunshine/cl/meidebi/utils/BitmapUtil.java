package com.sunshine.cl.meidebi.utils;

import android.content.Context;
import android.widget.ImageView;

public class BitmapUtil {
    /**
     * 通过magLoading加载图片
     *
     * @param Path
     * @param imageView
     */
    public static void setImageViewByImagLoading(Context mContext, String Path, ImageView imageView) {
        String imagePath;
        if (Path.trim().toString().startsWith("https://") || Path.trim().toString().startsWith("http://") || Path.trim().toString().startsWith("file://")) {
            imagePath = Path.trim().toString();
        } else {
            imagePath = "file://" + Path.trim().toString();
        }
        PicassoUtils.setAvatarImg(mContext, imagePath, imageView);
    }
}
