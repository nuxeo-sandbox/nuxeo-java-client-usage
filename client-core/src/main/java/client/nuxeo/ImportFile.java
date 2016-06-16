package client.nuxeo;
import org.nuxeo.client.api.NuxeoClient;
import org.nuxeo.client.api.objects.Document;

/**
 * Created by mgena on 6/16/16.
 */
public class ImportFile {
	public static void main(String[] args){
		String url = "http://bbva.cloud.nuxeo.com/nuxeo";
	    NuxeoClient nuxeoClient = new NuxeoClient(url, "Administrator", "Administrator");
	    
	    // Create a document
	    Document document = new Document("file", "File");
	    document.set("dc:title", "new title");
	    document = nuxeoClient.repository().createDocumentByPath("/default-domain/workspaces/java client", document);
	}
}
