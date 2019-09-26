package com.zabee.just.java8.practice;
/**
 * This is strategy design pattern
 * @author zulla
 *
 */

public class EnumAndFnInterface {

	public static void main(String[] args) {
		System.out.println(OperationEnum.ADD.compute(1, 2));
	}

}

enum OperationEnum implements Operation {
	ADD((x, y) -> x + y), //
	SUB((x, y) -> x - y), //
	MUL((x, y) -> x * y), //
	DIV((x, y) -> x / y);

	private Operation op;

	OperationEnum(Operation argOp) {
		op = argOp;
	}

	@Override
	public double compute(double x, double y) {
		return op.compute(x, y);
	}

}

@FunctionalInterface
interface Operation {
	public double compute(double x, double y);
}
