package com.until;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTool {
    /**
     * 获取目录下的所有文件名称
     *
     * @param path
     * @return
     */
    public static List<String> getFileByPath(String path) {
        List<String> list = new ArrayList<String>();
        File f = new File(path);
        if (f.exists()) {
            File fa[] = f.listFiles();
            for (int i = 0; i < fa.length; i++) {
                File fs = fa[i];
                if (!fs.isDirectory()) {
                    list.add(fs.getName());
                }
                fs = null;
            }
        }
        f = null;
        return list;
    }
}
