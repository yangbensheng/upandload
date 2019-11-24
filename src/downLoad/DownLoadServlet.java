package downLoad;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String fileName = request.getParameter("fileName");
        String folder = "/downLoad/";
        response.addHeader("Content-Type","application/octet-stream");
        response.addHeader("Content-Disposition","attachment;filename="+fileName);
        InputStream in = this.getServletContext().getResourceAsStream(folder + fileName);
        ServletOutputStream out = response.getOutputStream();
        byte[] bytes = new byte[10 ];
        int len = -1;
        while ((len = in.read(bytes))!=-1){
            out.write(bytes);
        }
        in.close();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
