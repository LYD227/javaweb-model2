package com.model2.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {  
	  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        String uuidfilename = request.getParameter("filename");//get方式提交的  
        uuidfilename = new String(uuidfilename.getBytes("ISO-8859-1"),"UTF-8");//UUID的文件名  
          
        String storeDirectory = getServletContext().getRealPath("/WEB-INF/files");  
        //得到存放的子目录  
        String childDirecotry = makeChildDirectory(storeDirectory, uuidfilename);  
          
        //构建输入流  
        InputStream in = new FileInputStream(storeDirectory+File.separator+childDirecotry+File.separator+uuidfilename);  
        //下载  
        String oldfilename = uuidfilename.substring(uuidfilename.indexOf("_")+1);  
        //通知客户端以下载的方式打开  
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(oldfilename, "UTF-8"));  
          
        OutputStream out = response.getOutputStream();  
          
        int len = -1;  
        byte b[] = new byte[1024];  
        while((len=in.read(b))!=-1){  
            out.write(b,0,len);  
        }  
        in.close();  
        out.close();  
          
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doGet(request, response);  
    }  
    //计算存放的子目录  
    private String makeChildDirectory(String realPath, String fileName) {  
        int hashCode = fileName.hashCode();  
        int dir1 = hashCode&0xf;// 取1~4位  
        int dir2 = (hashCode&0xf0)>>4;//取5~8位  
          
        String directory = ""+dir1+File.separator+dir2;  
        File file = new File(realPath,directory);  
        if(!file.exists())  
            file.mkdirs();  
          
        return directory;  
    }  
}