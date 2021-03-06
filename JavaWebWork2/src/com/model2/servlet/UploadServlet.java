package com.model2.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {  
	  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();  
        System.out.print(request.getRemoteAddr());  
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
        if(!isMultipart){  
            throw new RuntimeException("请检查您的表单的enctype属性，确定是multipart/form-data");  
        }  
        DiskFileItemFactory dfif = new DiskFileItemFactory();  
        ServletFileUpload parser = new ServletFileUpload(dfif);  
          
        parser.setFileSizeMax(3*1024*1024);//设置单个文件上传的大小  
        parser.setSizeMax(6*1024*1024);//多文件上传时总大小限制  
          
        List<FileItem> items = null;  
        try {  
            items = parser.parseRequest(request);  
        }catch(FileUploadBase.FileSizeLimitExceededException e) {  
            out.write("上传文件超出了3M");  
            return;  
        }catch(FileUploadBase.SizeLimitExceededException e){  
            out.write("总文件超出了6M");  
            return;  
        }catch (FileUploadException e) {  
            e.printStackTrace();  
            throw new RuntimeException("解析上传内容失败，请重新试一下");  
        }  
          
        //处理请求内容  
        if(items!=null){  
            for(FileItem item:items){  
                if(item.isFormField()){  
                    processFormField(item);  
                }else{  
                    processUploadField(item);  
                }  
            }  
        }  
          
        out.write("上传成功！");  
    }  
    private void processUploadField(FileItem item) {  
        try {  
            String fileName = item.getName();  
              
              
            //用户没有选择上传文件时  
            if(fileName!=null&&!fileName.equals("")){  
                fileName = UUID.randomUUID().toString()+"_"+FilenameUtils.getName(fileName);  
                  
                //扩展名  
                String extension = FilenameUtils.getExtension(fileName);  
                //MIME类型  
                String contentType = item.getContentType();  
                  
                  
                  
                //分目录存储：日期解决  
    //          Date now = new Date();  
    //          DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
    //            
    //          String childDirectory  = df.format(now);  
                  
                  
                //按照文件名的hashCode计算存储目录  
                String childDirectory = makeChildDirectory(getServletContext().getRealPath("/WEB-INF/files/"),fileName);  
                  
                String storeDirectoryPath = getServletContext().getRealPath("/WEB-INF/files/"+childDirectory);  
                File storeDirectory = new File(storeDirectoryPath);  
                if(!storeDirectory.exists()){  
                    storeDirectory.mkdirs();  
                }  
                System.out.println(fileName);  
                item.write(new File(storeDirectoryPath+File.separator+fileName));//删除临时文件  
                  
            }  
        } catch (Exception e) {  
            throw new RuntimeException("上传失败,请重试");  
        }  
          
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
    private void processFormField(FileItem item) {  
        String fieldName = item.getFieldName();//字段名  
        String fieldValue;  
        try {  
            fieldValue = item.getString("UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException("不支持UTF-8编码");  
        }  
        System.out.println(fieldName+"="+fieldValue);  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doGet(request, response);  
    }  
  
}