package com.laowang.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 隔壁老王
 */

public class UploadUtil {

    public static String uploadFile(HttpServletRequest req){
        Part part = null;
        String fileName = "";
        try {
            part = req.getPart("file");
            fileName = UUID.randomUUID() + part.getSubmittedFileName();
            System.out.println(fileName);
            String path = "D:\\Stu_System\\MyEdu";
            File file = new File(path);
            if (!file.exists()){
                file.mkdirs();
            }
            part.write(path+"/"+ fileName);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
