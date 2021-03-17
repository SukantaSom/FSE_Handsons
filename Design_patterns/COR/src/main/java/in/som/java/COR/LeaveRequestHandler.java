package in.som.java.COR;

public interface LeaveRequestHandler {

	public LeaveRequestHandler nextHandler=null;
	
	public void handleRequest(LeaveRequest leaveRequest);
	
}