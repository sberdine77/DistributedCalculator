
public class CalcImplementation implements ICalc {
	
	@Override
	public float sum (float a, float b) {
		return a + b;
	}
	@Override
	public float sub (float a, float b) {
		return a - b;
	}
	@Override
	public float div (float a, float b) {
		return a / b;
	}
	@Override
	public float mul (float a, float b) {
		return a * b;
	}
}
