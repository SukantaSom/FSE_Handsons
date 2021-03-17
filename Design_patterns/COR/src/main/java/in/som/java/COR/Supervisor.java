package in.som.java.COR;
public class Supervisor implements LeaveRequestHandler{

	private LeaveRequestHandler nextHandler=new ProjectManager();
	
	@Override
	public void handleRequest(LeaveRequest leaveRequest) {
		
		if(leaveRequest.getLeaveDays()>=1 && leaveRequest.getLeaveDays()<=3)
		{
			System.out.println(leaveRequest.getEmployee()+" leave accepted by Supervisor");
		}
		else
		{
			// sent request to Project manager
			nextHandler.handleRequest(leaveRequest);
		}
		
	}

}