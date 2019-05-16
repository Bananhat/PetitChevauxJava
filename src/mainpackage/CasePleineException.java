package mainpackage;
/**
 * Cette exception est appelé lorsqu'une case est occupé et ne peux être dépassé ou prise
 */
public class CasePleineException extends Exception {

	private static final long serialVersionUID = 1L;

	public CasePleineException(String mes)
	{
		super(mes);
	}
}
