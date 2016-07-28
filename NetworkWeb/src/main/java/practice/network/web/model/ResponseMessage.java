package practice.network.web.model;

/**
 * Created by oleksii on 11/15/15.
 */
public class ResponseMessage {

	private String status;
	private String errorMessage;

	public static ResponseMessage okMessage() {
		return new ResponseMessage("OK");
	}

	public static ResponseMessage errorMessage(String message) {
		return new ResponseMessage("ERROR", message);
	}

	private ResponseMessage(String s){
	}

	private ResponseMessage(String status, String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
