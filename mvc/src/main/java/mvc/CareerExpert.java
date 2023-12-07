package mvc;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

public class CareerExpert {
	public String getAdvice(String qualification)
		{
		if(qualification.equalsIgnoreCase("BE"))
				return "galti krdi bhai";
		else
			return "majje karle";
		}

		
}
