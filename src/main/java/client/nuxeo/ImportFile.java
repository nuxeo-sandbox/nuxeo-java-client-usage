package client.nuxeo;
import java.io.File;

import org.nuxeo.client.api.NuxeoClient;
import org.nuxeo.client.api.objects.Document;
import org.nuxeo.client.api.objects.upload.BatchUpload;

/**
 * Created by mgena on 6/16/16.
 */
public class ImportFile {
	public static void main(String[] args){
		String url = "http://bbva.cloud.nuxeo.com/nuxeo";
	    NuxeoClient nuxeoClient = new NuxeoClient(url, "Administrator", "Administrator");
	    
	    // Create a document
	    Document document = new Document("document1", "File");
	    document.set("dc:title", "new title");
	    document = nuxeoClient.repository().createDocumentByPath("/default-domain/workspaces/java", document);
	    
	    // Upload the file
	    BatchUpload batchUpload = nuxeoClient.fetchUploadManager().enableChunk();
	    File file = new File("/Users/mgena/Documents/BBVA/NatGeo01.jpg");
	    batchUpload = batchUpload.upload(file.getName(), file.length(), "jpg", batchUpload.getBatchId(), "1", file);
	    
	    // Attach the file to the document
	    document.set("file:content", batchUpload.getBatchBlob());
	    document = document.updateDocument();

	}
}
