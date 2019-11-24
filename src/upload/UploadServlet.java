package upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

public class UploadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        System.out.println(session);
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload load = new ServletFileUpload(factory);
        load.setHeaderEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        try {
            List<FileItem> fileItems = load.parseRequest(req);
            for (FileItem item:fileItems) {
                if(item.isFormField()){
                    String name = item.getFieldName();
                    if(name.equals("name")){
                        String value = item.getString("utf-8");
                        writer.print("上传者："+value+"<br />");
                    }

                }else {
                    String fieldName = item.getName();
                    writer.print("上传的文件名是"+fieldName+"<br />");
                    String path = "upload";
                    String filePath = this.getServletContext().getRealPath(path);
                    System.out.println("路径"+filePath);
                    File file = new File(filePath+"\\"+fieldName);
                    InputStream in =item.getInputStream();
                    FileOutputStream out = new FileOutputStream(file);
                    byte[] bytes = new byte[1024];
                    int lenth = 0;
                    while (in.read(bytes)!=-1){
                        out.write(bytes);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    writer.print("文件上传成功！");
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
