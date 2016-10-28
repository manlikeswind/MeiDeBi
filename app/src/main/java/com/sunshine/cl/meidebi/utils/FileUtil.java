package com.sunshine.cl.meidebi.utils;

import android.os.Environment;
import java.io.File;


public class FileUtil {
    private static final String FILE_ROOT = Environment.getExternalStorageDirectory() + "/RCB";//根目录
    public static File getFile(String filename) {
        File file = new File(FILE_ROOT, filename);
        file.getParentFile().mkdirs();
        return file;
    }
}
