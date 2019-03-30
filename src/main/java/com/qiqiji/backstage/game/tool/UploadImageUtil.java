package com.qiqiji.backstage.game.tool;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UploadImageUtil {
    public static String uploadImage(HttpServletRequest request,MultipartFile file) throws  Exception{
        File targetFile=null;
        String url="";//返回存储路径
        int code=1;
        System.out.println(file);
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){
            String path ="/beiyong/photoqqj/scenarioandmenu"; //request.getSession().getServletContext().getRealPath(""); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名
            //先判断文件是否存在
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String fileAdd = sdf.format(new Date());
            //获取文件夹路径
            File file1 =new File(path);
            //如果文件夹不存在则创建
            if(!file1 .exists()  && !file1 .isDirectory()){
                file1 .mkdir();
            }
            //将图片存入文件夹
            targetFile = new File(file1+"/"+ fileName);
            BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream(targetFile));
            out.write(file.getBytes());
            out.flush();
            out.close();
                //将上传的文件写到服务器上指定的文件。
                url=fileName;
        }
        return url;
    }
}
