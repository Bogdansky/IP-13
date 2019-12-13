import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Sss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Servlet:Sss");
        String filename = req.getParameter("file");
        String docdir = getServletContext().getInitParameter("doc-dir");
        File file = new File(docdir + "/" + filename);
        OutputDoc(file,  res);
        System.out.println("Send " + file.getAbsolutePath());
    }

    protected void OutputDoc(File doc, HttpServletResponse rs)
            throws IOException {
        rs.setContentType("application/msword");
        rs.addHeader("Content-Disposition", "attachment; filename="+
                doc.getName());
        rs.setContentLength((int) doc.length());

        FileInputStream in = new FileInputStream(doc);
        BufferedInputStream buf = new BufferedInputStream(in);
        ServletOutputStream out = rs.getOutputStream();
        int readBytes = 0;
        while ((readBytes = buf.read()) != -1)
            out.write(readBytes);

    }

}
