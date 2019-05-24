package com.mkyong.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.users.model.Relation_files_uui;
import com.mkyong.users.service.Relation_files_uuiService;
import com.ixanaui.utils.PreviewConfig;
import com.ixanaui.utils.ResponseFile;

@Controller
public class ArchivosController {
	
 
	@Autowired
	private Relation_files_uuiService relation_files_uuiService;
	
    @RequestMapping(value = { "/guardarImagen" }, method = RequestMethod.POST)
    public @ResponseBody ResponseFile guardarImagen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException {
 
    	/**Creamos un Objeto de tipo Properties*/
    	   Properties propiedades = new Properties();
    	   InputStream inputStream = getClass().getClassLoader().getResourceAsStream("archivo.properties");
    	   propiedades.load(inputStream);

    	List<Relation_files_uui> listArchivos = new ArrayList<Relation_files_uui>();
    	String idFile="";
    	ResponseFile respuesta = new ResponseFile();
    	PreviewConfig data = new PreviewConfig();
    	///////ResponseFile
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                    	Relation_files_uui files_uui = new Relation_files_uui();
                    	
                        String name = new File(item.getName()).getName();
                        item.write( new File(propiedades.getProperty("path") + File.separator + name));
                        files_uui.setName(name);
                        String cadena =
                        "<object data=\""+request.getContextPath()+"/resources/imagenes/"+name+"\" type=\"application/pdf\" width=\"160px\" height=\"160px\" internalinstanceid=\"21\">"
                        + "<param name=\"movie\" value=\""+request.getContextPath()+"/resources/imagenes/"+name+"\">"
                       + "<param name=\"controller\" value=\"true\">"
                       + "<param name=\"allowFullScreen\" value=\"true\">"
                       + "<param name=\"allowScriptAccess\" value=\"always\">"
                       + "<param name=\"autoPlay\" value=\"false\">"
                       + "<param name=\"autoStart\" value=\"false\">"
                       + "<param name=\"quality\" value=\"high\">"
                         +  "<div class=\"file-preview-other\">"
                        + "<i class=\"glyphicon glyphicon-file\"></i>"
                    + "</div>"
                    + "</object>";
                        respuesta.getInitialPreview().add(cadena);
                        data.setCaption(name);
                        data.setWidth("120px");
                        data.setUrl(request.getContextPath()+"/deleteImagen?name="+name+"");
                        data.setKey(name);
                        respuesta.getInitialPreviewConfig().add(data);
                        respuesta.setAppend(true);
                        listArchivos.add(files_uui);
                    }
                    else
                    {
                    	System.out.println("DATA "+item.getFieldName()+" "+item.getString("UTF-8") );
                    	idFile=item.getString("UTF-8");
                    }
                }
           
                
               //File uploaded successfully
                for(int x=0;x<listArchivos.size();x++){
                	Relation_files_uui copia = listArchivos.get(x);
                	copia.setUUI(idFile);
                	 relation_files_uuiService.insertRelation_files_uui(copia);
                }
               
               System.out.println("message"+ "File Uploaded Successfully");
            } catch (Exception ex) {
               System.out.println("message"+ "File Upload Failed due to " + ex);
            }          
         
        }else{
            System.out.println("message"+
                                 "Sorry this Servlet only handles file upload request");
        }
    	///////
    	
         
         return respuesta;
  
    }
    
    @RequestMapping(value = { "/deleteImagen" }, method = RequestMethod.DELETE)
    public @ResponseBody ResponseFile deleteImagen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException {
    	ResponseFile respuesta = new ResponseFile();
    	String nombre= request.getParameter("name");
    	System.out.println("nombre "+nombre);
    	/**Creamos un Objeto de tipo Properties*/
 	   Properties propiedades = new Properties();
 	   InputStream inputStream = getClass().getClassLoader().getResourceAsStream("archivo.properties");
 	   propiedades.load(inputStream);
    	
    	File fichero = new File(propiedades.getProperty("path") + File.separator + nombre);
    	if(fichero.delete()){

    		relation_files_uuiService.eliminarRelation_files_uui(relation_files_uuiService.buscarByName(nombre).get(0));
            System.out.println("archivo eliminado");
      
       }
    	else
    		System.out.println("archivo no eliminado"+propiedades.getProperty("path") + File.separator + nombre);
        
    	return respuesta;
    }
    
    
    @RequestMapping(value = { "/imagenesUUI" }, method = RequestMethod.POST)
    public @ResponseBody ResponseFile getimagenesUUI(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException {
 
    	/**Creamos un Objeto de tipo Properties*/
    	   Properties propiedades = new Properties();
    	   InputStream inputStream = getClass().getClassLoader().getResourceAsStream("archivo.properties");
    	   propiedades.load(inputStream);
    	   Relation_files_uui nuevo = new Relation_files_uui();
    	   nuevo.setUUI(request.getParameter("codec"));
    	   ResponseFile respuesta = new ResponseFile();
    	  List<Relation_files_uui> lista = relation_files_uuiService.consultaRelation_files_uui(nuevo);
    	  System.out.println("UUI "+request.getParameter("codec"));
    	  System.out.println("tamñaano de lista de archivos"+ lista.size());
    	  if(lista.size()>0){	
    	    	for(int z=0;z<lista.size();z++){
    	    		PreviewConfig data = new PreviewConfig();
    	    		 String cadena =
 	                        "<object data=\""+request.getContextPath()+"/resources/imagenes/"+lista.get(z).getName()+"\" type=\"application/pdf\" width=\"160px\" height=\"160px\" internalinstanceid=\"21\">"
 	                        + "<param name=\"movie\" value=\""+request.getContextPath()+"/resources/imagenes/"+lista.get(z).getName()+"\">"
 	                       + "<param name=\"controller\" value=\"true\">"
 	                       + "<param name=\"allowFullScreen\" value=\"true\">"
 	                       + "<param name=\"allowScriptAccess\" value=\"always\">"
 	                       + "<param name=\"autoPlay\" value=\"false\">"
 	                       + "<param name=\"autoStart\" value=\"false\">"
 	                       + "<param name=\"quality\" value=\"high\">"
 	                         +  "<div class=\"file-preview-other\">"
 	                        + "<i class=\"glyphicon glyphicon-file\"></i>"
 	                    + "</div>"
 	                    + "</object>";
 	                        respuesta.getInitialPreview().add(cadena);
 	                        data.setCaption("<a href='downloadFile?name="+lista.get(z).getName()+"'>"+lista.get(z).getName()+"</a>");
 	                        data.setWidth("120px");
 	                        data.setUrl(request.getContextPath()+"/deleteImagen?name="+lista.get(z).getName()+"");
 	                        data.setKey(lista.get(z).getName());
 	                        respuesta.getInitialPreviewConfig().add(data);
 	                        respuesta.setAppend(true);
    	    		
    	    	}
    	                       
    		  
    	  }
 
    	
                   
         
         return respuesta;
  
    }
    
    @RequestMapping(value = { "/downloadFile" },method = RequestMethod.GET)
	public void doDownload(HttpServletRequest request,
			HttpServletResponse response) {
    	
    	String nombre= request.getParameter("name");
    	
    	/**Creamos un Objeto de tipo Properties*/
 	   Properties propiedades = new Properties();
 	   InputStream inputStreamFile = getClass().getClassLoader().getResourceAsStream("archivo.properties");
 	   try {
		propiedades.load(inputStreamFile);
		
 	   } catch (IOException e) {
		// TODO Auto-generated catch block
 		   e.printStackTrace();
 		   return ;
 	   }
    	
    	int BUFFER_SIZE = 4096;
    	String fullPath = propiedades.getProperty("path") +"/"+nombre;

		// get absolute path of the application
		ServletContext context = request.getSession().getServletContext();
		String appPath = context.getRealPath("");
		System.out.println("appPath = " + appPath);

		// construct the complete absolute path of the file	
		File downloadFile = new File(fullPath);
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}
		
		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		try {
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 
}
