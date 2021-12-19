package de.stylextv.gsigns.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import de.stylextv.gsigns.Constants;

public class StreamedFile {
	
	private static final String ROOT_FOLDER = "plugins/" + Constants.PLUGIN_ID + "/";
	
	private File file;
	
	private InputStream inputStream;
	
	private OutputStream outputStream;
	
	public StreamedFile(String path) {
		this(new File(ROOT_FOLDER + path));
	}
	
	private StreamedFile(File f) {
		this.file = f;
		
		f.getParentFile().mkdirs();
	}
	
	public byte[] readAll() {
		try {
			
			return getInputStream().readAllBytes();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public byte[] read(int length) {
		try {
			
			return getInputStream().readNBytes(length);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public byte read() {
		try {
			
			return (byte) getInputStream().read();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return -1;
	}
	
	public void write(byte[] data) {
		for(byte b : data) {
			
			write(b);
		}
	}
	
	public void write(byte b) {
		try {
			
			getOutputStream().write(b);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void close() {
		try {
			
			if(inputStream != null) inputStream.close();
			if(outputStream != null) outputStream.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean isEmpty() {
		return available() == 0;
	}
	
	public int available() {
		try {
			
			return getInputStream().available();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return 0;
	}
	
	public InputStream getInputStream() {
		if(inputStream == null) {
			try {
				
				InputStream stream = new FileInputStream(file);
				
				setInputStream(stream);
				
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
		}
		
		return inputStream;
	}
	
	public OutputStream getOutputStream() {
		if(outputStream == null) {
			try {
				
				OutputStream stream = new FileOutputStream(file);
				
				setOutputStream(stream);
				
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
		}
		
		return outputStream;
	}
	
	public void setInputStream(InputStream stream) {
		this.inputStream = stream;
	}
	
	public void setOutputStream(OutputStream stream) {
		this.outputStream = stream;
	}
	
	public boolean exists() {
		return file.exists();
	}
	
	public File getFile() {
		return file;
	}
	
}