package command.polygon;

import java.util.ArrayList;
import java.util.List;

public class CommanderManage {

	List<ICommander> list = new ArrayList<ICommander>();

	public void add(ICommander c) {
		list.add(c);
	}

	public void executeCommand() {
		for (int i = 0; i < list.size(); i++) {
			float value = list.get(i).calc();
			String calName = list.get(i).getCalUsage();
			System.out.println("The " + calName + " is: " + value);
		}
	}
}
