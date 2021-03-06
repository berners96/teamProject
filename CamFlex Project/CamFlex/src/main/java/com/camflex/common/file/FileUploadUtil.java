package com.camflex.common.file;


import java.io.File;
import java.io.IOException;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;



public class FileUploadUtil {

	private static Logger log = LoggerFactory.getLogger(FileUploadUtil.class);
	
	/* 파일 업로드할 폴더 생성 */
	public static void makeDir(String docRoot) {
		File fileDir = new File(docRoot);
		if(fileDir.exists()) {
			return;
		}
		fileDir.mkdirs();
	}
	
	/* 파일 업로드 메서드 */
	public static String fileUpload(MultipartFile file, HttpServletRequest request, String fileName)throws IOException{
		log.info("fileUpload 호출 성공");
		
		String real_name = null;
		
		// MultipartFile 클래스의 getFile() 메서드로 클라이언트가 업로드한 파일
		String org_name = file.getOriginalFilename();
		log.info("org_name: " + org_name);
		
		// 파일명 변경(중복되지 않게)
		if(org_name != null && (!org_name.equals(""))) {
			real_name = fileName + "_" + System.currentTimeMillis() + "_" + org_name;
			// 저장할 파일 이름
			
			
			String docRoot = request.getSession().getServletContext().getRealPath("/uploadStorage/" + fileName);
			makeDir(docRoot);
			
			File fileAdd = new File(docRoot + "/" + real_name);		// 파일 생성 후
			log.info("업로드할 파일(fileAdd) : " + fileAdd);
			
			file.transferTo(fileAdd);
		}
		return real_name;
	}
	public static String fileUpload1(MultipartFile file1, HttpServletRequest request, String fileName1)throws IOException{
		log.info("fileUpload 호출 성공");
		
		String real_name = null;
		
		// MultipartFile 클래스의 getFile() 메서드로 클라이언트가 업로드한 파일
		String org_name = file1.getOriginalFilename();
		log.info("org_name: " + org_name);
		
		// 파일명 변경(중복되지 않게)
		if(org_name != null && (!org_name.equals(""))) {
			real_name = fileName1 + "_" + System.currentTimeMillis() + "_" + org_name;
			// 저장할 파일 이름
			
			
			String docRoot = request.getSession().getServletContext().getRealPath("/uploadStorage/" + fileName1);
			makeDir(docRoot);
			
			File fileAdd = new File(docRoot + "/" + real_name);		// 파일 생성 후
			log.info("업로드할 파일(fileAdd) : " + fileAdd);
			
			file1.transferTo(fileAdd);
		}
		return real_name;
	}
	public static String fileUpload2(MultipartFile file2, HttpServletRequest request, String fileName2)throws IOException{
		log.info("fileUpload 호출 성공");
		
		String real_name = null;
		
		// MultipartFile 클래스의 getFile() 메서드로 클라이언트가 업로드한 파일
		String org_name = file2.getOriginalFilename();
		log.info("org_name: " + org_name);
		
		// 파일명 변경(중복되지 않게)
		if(org_name != null && (!org_name.equals(""))) {
			real_name = fileName2 + "_" + System.currentTimeMillis() + "_" + org_name;
			// 저장할 파일 이름
			
			
			String docRoot = request.getSession().getServletContext().getRealPath("/uploadStorage/" + fileName2);
			makeDir(docRoot);
			
			File fileAdd = new File(docRoot + "/" + real_name);		// 파일 생성 후
			log.info("업로드할 파일(fileAdd) : " + fileAdd);
			
			file2.transferTo(fileAdd);
		}
		return real_name;
	}
	public static String fileUpload3(MultipartFile file3, HttpServletRequest request, String fileName3)throws IOException{
		log.info("fileUpload 호출 성공");
		
		String real_name = null;
		
		// MultipartFile 클래스의 getFile() 메서드로 클라이언트가 업로드한 파일
		String org_name = file3.getOriginalFilename();
		log.info("org_name: " + org_name);
		
		// 파일명 변경(중복되지 않게)
		if(org_name != null && (!org_name.equals(""))) {
			real_name = fileName3 + "_" + System.currentTimeMillis() + "_" + org_name;
			// 저장할 파일 이름
			
			
			String docRoot = request.getSession().getServletContext().getRealPath("/uploadStorage/" + fileName3);
			makeDir(docRoot);
			
			File fileAdd = new File(docRoot + "/" + real_name);		// 파일 생성 후
			log.info("업로드할 파일(fileAdd) : " + fileAdd);
			
			file3.transferTo(fileAdd);
		}
		return real_name;
	}
	
	/* 파일 삭제 메서드 */
	public static void fileDelete(String fileName, HttpServletRequest request)throws IOException{
		log.info("fileDelet 호출 성공");
		boolean result = false;
		String dirName = fileName.substring(0, fileName.indexOf("_"));
		String docRoot = request.getSession().getServletContext().getRealPath("uploadStorage/" + dirName);
		File fileDelete = new File(docRoot + "/" + fileName);	// 파일 생성후
		log.info("삭제할 파일(fileDelete : " + fileDelete);
		if(fileDelete.exists() && fileDelete.isFile()) {
			result = fileDelete.delete();
		}
		log.info("파일 삭제 여부(true/false) : " + result);
	 }
	
	
}
