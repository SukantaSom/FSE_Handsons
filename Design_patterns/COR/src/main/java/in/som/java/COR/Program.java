package in.som.java.COR;
public class Program {

	public static void main(String[] args) {
		
		Supervisor supervisor=new Supervisor();
		
		LeaveRequest leaveRequest = new LeaveRequest("ss", 5);
		supervisor.handleRequest(leaveRequest);
		
		LeaveRequest leaveRequest1 = new LeaveRequest("dubey", 3);
		supervisor.handleRequest(leaveRequest1);
		
		LeaveRequest leaveRequest3 = new LeaveRequest("Sougata", 4);
		supervisor.handleRequest(leaveRequest3);
		
	}
	
}