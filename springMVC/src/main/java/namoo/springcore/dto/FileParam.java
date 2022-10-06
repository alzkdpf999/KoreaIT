package namoo.springcore.dto;

public class FileParam {
	private String filenName;
	private String originalFileName;
	private String contentType;

	public FileParam() {
	}

	public FileParam(String filenName, String originalFileName, String contentType) {
		this.filenName = filenName;
		this.originalFileName = originalFileName;
		this.contentType = contentType;
	}

	public String getFilenName() {
		return filenName;
	}

	public void setFilenName(String filenName) {
		this.filenName = filenName;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String toString() {
		return "File [filenName=" + filenName + ", originalFileName=" + originalFileName + ", contentType="
				+ contentType + "]";
	}
}
