package in.som.java.COR;
public class ProjectManager implements LeaveRequestHandler{

	private LeaveRequestHandler nextHandler=new HR();
	
	@Override
	public void handleRequest(LeaveRequest leaveRequest) {
		
		if(leaveRequest.getLeaveDays()>3 && leaveRequest.getLeaveDays()<=5)
		{
			System.out.println(leaveRequest.getEmployee()+" leave accepted by ProjectManager");
		}
		else
		{
			// send request to project manager
			nextHandler.handleRequest(leaveRequest);
		}
		
	}

	
	
}