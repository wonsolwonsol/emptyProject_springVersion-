package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FileDownServlet extends HttpServlet {
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

	        String fileName = request.getParameter( "fileName" );

	        File fNew = new File("c:\\upload", fileName);
			String sFilePath = fNew.getPath();
		//	String sFilePath = sDownloadPath + fileName;

			byte b[] = new byte[4096];
			FileInputStream in = new FileInputStream(sFilePath);

			String sMimeType = getServletContext().getMimeType(sFilePath);
System.out.println("sMimeType>>>"+sMimeType );

		 // octet-stream ��  8��Ʈ�� �� �Ϸ��� ����Ÿ�� ���մϴ�. �������� ���� ���� ������ �ǹ��մϴ�.
	
			if(sMimeType == null) sMimeType = "application/octet-stream";

			response.setContentType(sMimeType);

			//�ѱ� ���ε�
			String sEncoding = new String(fileName.getBytes("UTF-8"),"8859_1");

			response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
			
			ServletOutputStream out = response.getOutputStream();
			int numRead;

			// ����Ʈ �迭b�� 0�� ���� numRead�� ���� �������� ���
			while((numRead = in.read(b, 0, b.length)) != -1) {
				out.write(b, 0, numRead);
			}
			out.flush(); 
			out.close();
			in.close();

	}//end
}//end class


